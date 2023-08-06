package com.claucas90.sprintmodulo6.Model.Repository

import com.claucas90.sprintmodulo6.Model.Phone
import com.claucas90.sprintmodulo6.Model.Remote.Clases.DetailsPhoneApiClass
import com.claucas90.sprintmodulo6.Model.Remote.Clases.PhoneApiClass
fun fromInternetToCoursesEntity(phoneList: List<PhoneApiClass>, detailsPhoneList: List<DetailsPhoneApiClass>): List<Phone> {

    return phoneList.mapIndexed { index, phoneApi ->
        val detailsPhoneApi = detailsPhoneList[index]

        Phone(
            id = phoneApi.id,
            phoneName = phoneApi.name,
            phonePrice = phoneApi.price,
            phoneImage = phoneApi.image,
            phoneDescription = detailsPhoneApi.description,
            phoneLastPrice = detailsPhoneApi.lastPrice,
            phoneCredit = detailsPhoneApi.credit,
        )
    }
}