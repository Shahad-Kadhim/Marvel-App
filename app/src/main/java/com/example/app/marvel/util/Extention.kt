package com.example.app.marvel.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import java.math.BigInteger
import java.security.MessageDigest

fun String.md5(): String {
    with(MessageDigest.getInstance("MD5")){
        return BigInteger(1, digest(toByteArray())).toString(16).padStart(32, '0')
    }
}


fun <T> LiveData<Event<T>>.observeEvent(owner: LifecycleOwner, function:(T) ->Unit){
    this.observe(owner, EventObserver{ it ->
        function(it)
    })
}

fun String.replaceHttpWithHttps() =
    this.replace("http","https")

fun String.getRate() =
    this.count { it == '+' }.toFloat() + 1