package com.claucas90.sprintmodulo6.Model.Remote

import com.claucas90.sprintmodulo6.Model.Remote.Clases.DetailsPhoneApiClass
import com.claucas90.sprintmodulo6.Model.Remote.Clases.PhoneApiClass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PhoneApi {

    // listado de telefonos
    @GET("products")
    suspend fun fecthPhoneList(): Response<List<PhoneApiClass>>

    // seleccionar uno

    @GET("details/{id}")
    suspend fun fechPhoneDetail(@Path("id") id: Int): Response<DetailsPhoneApiClass>
}