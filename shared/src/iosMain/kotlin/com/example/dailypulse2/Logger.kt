package com.example.dailypulse2

actual class Logger {
    actual companion object {
        actual fun d(tag: String, message: String) {
            println("[$tag] $message")
        }
    }
}