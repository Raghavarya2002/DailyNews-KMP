package com.example.dailypulse2

expect class Logger {
    companion object {
        fun d(tag: String, message: String)
    }
}