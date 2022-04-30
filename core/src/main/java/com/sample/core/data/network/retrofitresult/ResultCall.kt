package com.sample.core.data.network.retrofitresult

import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import com.sample.core.data.network.result.Result

internal class ResultCall<T>(proxy: Call<T>) : CallDelegate<T, Result<T>>(proxy) {

    override fun enqueueImpl(callback: Callback<Result<T>>) {
        proxy.enqueue(ResultCallback(this, callback))
    }

    override fun cloneImpl(): ResultCall<T> {
        return ResultCall(proxy.clone())
    }

    private class ResultCallback<T>(
        private val proxy: ResultCall<T>,
        private val callback: Callback<Result<T>>
    ) : Callback<T> {

        override fun onResponse(call: Call<T>, response: Response<T>) {
            var result: Result<T>? = null
            if (response.isSuccessful) {
                result = Result.Success.HttpResponse(
                    value = response.body() as T,
                    statusCode = response.code(),
                    statusMessage = response.message(),
                    url = call.request().url.toString(),
                )
            } else {
                result = Result.Failure.HttpError(
                    HttpErrorException(
                        statusCode = response.code(),
                        response = response.errorBody()
                    )
                )

            }
            callback.onResponse(proxy, Response.success(result))
        }

        override fun onFailure(call: Call<T>, error: Throwable) {
            val result = when (error) {
                is retrofit2.HttpException -> {
                    val body = error.response()?.raw()?.body
                    Result.Failure.HttpError(
                        HttpErrorException(error.code(), response = body, cause = error)
                    )
                }
                is IOException -> {
                    Result.Failure.Error(error)
                }
                else -> {
                    Result.Failure.Error(error)
                }
            }

            callback.onResponse(proxy, Response.success(result))
        }
    }

    override fun timeout(): Timeout {
        return proxy.timeout()
    }
}
