package com.feint.file_manager.utility

import java.io.InputStream
import java.math.BigInteger
import java.security.MessageDigest

object FileUtils{
    fun md5(input: InputStream):String= BigInteger(1, MessageDigest.getInstance("MD5").digest(input.readBytes())).toString(16);
}