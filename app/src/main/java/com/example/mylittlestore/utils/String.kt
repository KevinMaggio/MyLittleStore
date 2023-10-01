package com.example.mylittlestore.utils

fun String?.orEmpty(): String{
    return this ?: ""
}
