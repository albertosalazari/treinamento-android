package com.example.nesspresso.presentation.extension

import java.text.NumberFormat
import java.util.*

fun Double.toMoneyFormat(fractionDigits: Int = 2): String {

    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = fractionDigits
    format.currency = Currency.getInstance("BRL")

    return format.format(this)
}