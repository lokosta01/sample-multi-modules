package com.sample.core.data.network.result

interface HttpResponse {

    val statusCode: Int

    val statusMessage: String?

    val url: String?
}
