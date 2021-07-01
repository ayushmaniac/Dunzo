package com.dunzo.project.utils.factory

import com.dunzo.project.utils.network.NetworkError
import com.dunzo.project.utils.network.Resource
import retrofit2.Response
import retrofit2.Retrofit

/**
 *Created by Ayush Shrivastava
 * on 9/5/21.
 */
/**
 * Synthetic sugaring to create Retrofit Service.
 */
inline fun <reified T> Retrofit.create(): T = create(T::class.java)

/**
 * Converts Retrofit [Response] to [Resource] which provides state
 * and data to the UI.
 */
fun <ResultType> Response<ResultType>.toResource(): Resource<ResultType> {
    val error = errorBody()?.toString() ?: message()
    return when {
        isSuccessful -> {
            val body = body()
            when {
                body != null -> Resource.success(body)
                else -> Resource.error(error, NetworkError())
            }
        }
        else -> Resource.error(error, NetworkError())
    }
}