package com.example.test_pt_serasi_autoraya.network

import java.lang.Exception

sealed class DataState<out R> {
    data class Success<T>(val data:T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}