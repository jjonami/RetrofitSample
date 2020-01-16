package com.jjonami.retrofitsample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = HttpClient.getInstance()
        client.requestContributors("jjonami", "RetrofitSample")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {
                Log.d(TAG, "doOnError")
            }
            .unsubscribeOn(Schedulers.io())
            .onErrorReturn { t: Throwable ->
                Log.d(TAG, "onErrorReturn : " + t.message)
                arrayOf(Contributors())
            }
            .subscribe { result ->
                if ("User" == result[0].type) {
                    Log.d(TAG, "subscribe ok")
                } else {
                    Log.d(TAG, "subscribe ng")
                }
            }
    }
}
