package com.sandeep.security

import io.ktor.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec



private val ALGORITHM="HmacSHA1"
private val HASH_KEY=hex(System.getenv("SECRET_KEY"))
private val HMAC_KEY=SecretKeySpec(HASH_KEY, ALGORITHM)


fun hash(password:String):String{

    val hmac= Mac.getInstance(ALGORITHM)
    hmac.init(HMAC_KEY)
    return hex(hmac.doFinal(password.toByteArray(Charsets.UTF_8)))

}