package com.claucas90.sprintmodulo6.Model.Repository

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.claucas90.sprintmodulo6.Model.Phone
import com.claucas90.sprintmodulo6.Model.PhoneDao
import com.claucas90.sprintmodulo6.Model.Remote.RetrofitClient
import com.claucas90.sprintmodulo6.Model.Remote.Clases.DetailsPhoneApiClass

class PhoneRepository (private val phoneDao: PhoneDao){

    private val networkService = RetrofitClient.retrofitInstance()

    val allDatos: LiveData<List<Phone>> = phoneDao.getAllDatos()


    @WorkerThread
    suspend fun insert(phone: List<Phone>) {
        phoneDao.insertAllPhones(phone)
    }
    @WorkerThread
    suspend fun deleteAll() {
        phoneDao.deleteAll()
    }
    @WorkerThread
    suspend fun deleteUno(id:Int) {
        phoneDao.deleteUno(id)
    }
    //Agregamos los datos desde la Api

    suspend fun fechPhone() {
        val service = kotlin.runCatching { networkService.fecthPhoneList() }
        service.onSuccess { response ->
            when (response.code()) {
                in 200..299 -> response.body()?.let {
                        phoneList -> val detailsResponseList = mutableListOf<DetailsPhoneApiClass>()

                    // Obtener los detalles de cada teléfono
                    phoneList.forEach { phoneApi ->
                        val detailsResponse = networkService.fechPhoneDetail(phoneApi.id)
                        if (detailsResponse.isSuccessful) {
                            val detailsPhoneApi = detailsResponse.body()
                            if (detailsPhoneApi != null) {
                                detailsResponseList.add(detailsPhoneApi)
                            }
                        }
                    }

                    // Insertar la lista de teléfonos con detalles en la base de datos
                    val phonesWithDetails = fromInternetToCoursesEntity(phoneList, detailsResponseList) //mapeo Mapper.kt
                    phoneDao.insertAllPhones(phonesWithDetails)
                }
                else -> Log.d("Repo", "${response.code()}-${response.errorBody()}")
            }
        }
        service.onFailure { error ->
            Log.e("Error", "${error.message}")
        }
    }

}