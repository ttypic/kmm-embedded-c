package com.ttypic.clibs

/**
 * Encoder interface which can encode byte arrays to Sha256 format.
 */
interface Sha256Encoder {
    fun encode(src: ByteArray): ByteArray

    fun encodeToString(src: ByteArray): String {
        val encoded = encode(src)
        return buildString(encoded.size) {
            encoded.forEach { append(it.toUByte().toString(16).padStart(2, '0')) }
        }
    }
}

expect object Sha256Factory {
    /**
     * Creates a new instance of [Sha256Encoder]
     */
    fun createEncoder(): Sha256Encoder
}
