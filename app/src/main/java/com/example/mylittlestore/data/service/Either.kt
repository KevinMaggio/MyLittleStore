package com.example.mylittlestore.data.service

sealed class Either<out T, out E> {
    data class Success<out T>(val value: T) : Either<T, Nothing>()
    data class Error<out E>(val error: E) : Either<Nothing, E>()

    companion object {
        fun <T> success(value: T): Either<T, Nothing> = Success(value)
        fun <E> error(error: E): Either<Nothing, E> = Error(error)
    }
}