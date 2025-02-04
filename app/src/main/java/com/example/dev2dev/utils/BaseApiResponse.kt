package com.example.dev2dev.utils

import retrofit2.Response

abstract class BaseApiResponse {

//    suspend fun <T> safeApiCall(api:suspend ()-> Response<T>): NetworkResult<T> {
//        try {
//            val response = api()
//            if (response.isSuccessful){
//                val body = response.body()
//                body?.let {
//                    return NetworkResult.Success(body)
//                }?: return errorMessage("Body is empty")
//            } else {
//                return errorMessage("${response.code()} ${response.message()}")
//            }
//        } catch (e: Exception) {
//            return errorMessage(e.message.toString())
//        }
//    }

    suspend fun <T> safeApiCall(api: suspend () -> Response<T>): NetworkResult<T> {
        return try {
            val response = api()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    NetworkResult.Success(body)
                } else {
                    NetworkResult.Success(null) // Возвращаем успешный результат с пустым телом
                }
            } else {
                errorMessage("${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            errorMessage(e.message.toString())
        }
    }

    private fun <T> errorMessage(e: String): NetworkResult.Error<T> =
        NetworkResult.Error(null, "Api call failed: ${e}")
}