package com.example.domain.base

sealed class FilimoResult<out T: Any> {

    data class Success<out T: Any>(val data: T) : FilimoResult<T>()

    data class Error(val error: com.example.domain.base.Error) : FilimoResult<Nothing>()
}