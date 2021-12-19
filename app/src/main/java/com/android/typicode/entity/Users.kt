package com.android.typicode.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

 data class Users(
    val id: Int,
    val name: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String
):Serializable


 data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipCode: String
):Serializable