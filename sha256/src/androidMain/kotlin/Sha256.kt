package com.ttypic.clibs

actual object Sha256Factory {
    actual fun createEncoder(): Sha256Encoder = AndroidSha256Encoder
}

object AndroidSha256Encoder : Sha256Encoder {

    init {
        System.loadLibrary("sha256")
    }
    external override fun encode(src: ByteArray): ByteArray
}
