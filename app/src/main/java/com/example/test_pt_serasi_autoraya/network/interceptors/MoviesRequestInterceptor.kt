package com.example.test_pt_serasi_autoraya.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class MoviesRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newUrl = originalRequest.url
            .newBuilder()
            .addQueryParameter(
                "api_key",
                "26162142fd7ece3adcc479bc1214feb6"
            )
            .build()
        return chain.proceed(
            originalRequest.newBuilder().url(newUrl).header("accept", "application/json")
                .build()
        )
    }

}