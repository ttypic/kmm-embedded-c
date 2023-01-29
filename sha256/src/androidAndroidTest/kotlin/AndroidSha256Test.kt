package com.ttypic.clibs

import kotlin.test.*

class AndroidSha256Test {

    @Test
    fun should_pass_library_sha256_checks() {
        checkEncodeToString("Kotlin", "c78f6c97923e81a2f04f09c5e87b69e085c1e47066a1136b5f590bfde696e2eb")
        checkEncodeToString("abc", "ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad")
        checkEncodeToString("abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlmnomnopnopq", "248d6a61d20638b8e5c026930c3e6039a33ce45964ff2167f6ecedd419db06c1")
        checkEncodeToString("aaaaaaaaaa", "bf2cb58a68f684d95a3b78ef8f661c9a4e5b09e82cc8f9cc88cce90528caeb27")
    }

    private fun checkEncodeToString(input: String, expectedOutput: String) {
        assertEquals(
            expectedOutput,
            Sha256Factory.createEncoder().encodeToString(input.asciiToByteArray())
        )
    }
}

private fun String.asciiToByteArray() = ByteArray(length) {
    get(it).code.toByte()
}
