package com.android.typicode.datasource

import com.android.typicode.utils.Result
import retrofit2.Response

//import timber.log.Timber

/**
 * Abstract Base Data source class with error handling
 */
abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.Success(body)
            }
            return error(" ${response.code()} ${response.message()} ")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        //Timber.e(message)
        // return Result.Erro("Network call has failed for a following reason: $message")
        return Result.Error(message)
    }

}

