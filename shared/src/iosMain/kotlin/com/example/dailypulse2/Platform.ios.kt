package com.example.dailypulse2

import platform.UIKit.UIDevice

actual class Platform(){
    actual val osName: String
    get() = UIDevice.currentDevice.systemName()

    actual val osVersion: String
        get() = UIDevice.currentDevice.systemName()

    actual val deviceModel: String
        get() = UIDevice.currentDevice.systemName()

    actual val density: Int
        get() = UIDevice.currentDevice.systemName()

    actual fun logSystemInfo(){
        println("OS Name: $osName")
    }

}