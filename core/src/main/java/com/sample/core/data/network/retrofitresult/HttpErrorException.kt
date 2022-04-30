package com.sample.core.data.network.retrofitresult

import com.sample.core.data.network.result.HttpException
import okhttp3.ResponseBody

class HttpErrorException(
    statusCode: Int,
    cause: Throwable? = null,
    val response: ResponseBody? = null
) : HttpException(statusCode, cause = cause)