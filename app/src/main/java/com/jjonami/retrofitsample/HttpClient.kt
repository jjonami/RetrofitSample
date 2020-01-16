package com.jjonami.retrofitsample

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

/**
 * HTTP 통신 관련 변수 및 상수
 */
object HttpClient{
    private const val TIMEOUT_CONNECT: Long = 15
    private const val TIMEOUT_WRITE: Long = 15
    private const val TIMEOUT_READ: Long = 15
    private const val URL = "https://api.github.com/"

    private var mClient: OkHttpClient
    private var mRetrofit: Retrofit
    private var mRetrofitInterface: RetrofitInterface

    init{
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        mClient = OkHttpClient().newBuilder().apply {
            addInterceptor(logInterceptor)
            connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
            writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
            readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
        }.build()

        mRetrofit = Retrofit.Builder().apply {
            baseUrl(URL)
            client(mClient)
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            addConverterFactory(GsonConverterFactory.create())
        }.build()

        mRetrofitInterface = mRetrofit.create()
    }

    fun getInstance(): RetrofitInterface {
        return mRetrofitInterface
    }
}