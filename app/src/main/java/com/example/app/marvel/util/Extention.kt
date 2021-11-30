package com.example.app.marvel.util

import java.math.BigInteger
import java.security.MessageDigest

fun String.md5(): String {
    with(MessageDigest.getInstance("MD5")){
        return BigInteger(1, digest(toByteArray())).toString(16).padStart(32, '0')
    }
}
