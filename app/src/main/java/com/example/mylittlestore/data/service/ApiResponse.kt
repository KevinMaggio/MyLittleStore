package com.example.mylittlestore.data.service

import java.io.Serializable

class ApiResponse<out T>(var status: Status, val data: T?, val message: String) : Serializable {

    companion object {
        fun <T> create(code: Int, data: T?, message: String?): ApiResponse<T> {
            return ApiResponse(
                status = getStatusByCode(code),
                data = data,
                message = message ?: getMessageByCode(code)
            )
        }

        private fun getStatusByCode(code: Int): Status {
            return when (code) {
                200 -> {
                    Status.SUCCESS
                }

                404 -> {
                    Status.ERROR_QUERY
                }

                403 -> {
                    Status.ERROR_AUTH
                }

                500 -> {
                    Status.ERROR_SERVER
                }

                0 -> {
                    Status.ERROR_TIME_OUT
                }

                else -> {
                    Status.ERROR_GENERIC
                }
            }
        }

        private fun getMessageByCode(code: Int): String {
            return when (code) {
                200 -> {
                    "success"
                }

                404 -> {
                    "error in query"
                }

                403 -> {
                    "error identification"
                }

                500 -> {
                    "ups error - server disconnect"
                }

                0 -> {
                    "time out"
                }

                else -> {
                    "generic error"
                }
            }
        }

        enum class Status {
            SUCCESS, ERROR_QUERY, ERROR_AUTH, ERROR_TIME_OUT, ERROR_SERVER, ERROR_GENERIC
        }
    }
}
