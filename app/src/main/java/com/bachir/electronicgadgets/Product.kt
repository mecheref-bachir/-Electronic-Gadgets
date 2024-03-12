package com.bachir.electronicgadgets

import java.io.Serializable

data class Product(val productName: String, val productDescription: String,val srcProduct:Int,val srcLogo:Int,
                   val cost: Double):Serializable
