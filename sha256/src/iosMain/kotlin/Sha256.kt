package com.ttypic.clibs

import com.ttypic.clibs.sha256.*
import kotlinx.cinterop.*

actual object Sha256Factory {
    actual fun createEncoder(): Sha256Encoder = NativeSha256Encoder
}

object NativeSha256Encoder : Sha256Encoder {
    @OptIn(ExperimentalUnsignedTypes::class)
    override fun encode(src: ByteArray): ByteArray =
        memScoped {
            val ctx = alloc<SHA256_CTX>()
            sha256_init(ctx.ptr)
            val srcPointer = src.toUByteArray().toCValues().ptr
            sha256_update(ctx.ptr, srcPointer, src.size.toULong())

            UByteArray(32).apply {
                usePinned {
                    sha256_final(ctx.ptr, it.addressOf(0))
                }
            }.toByteArray()
        }
}
