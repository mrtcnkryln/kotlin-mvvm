package com.mrtcnkryln.kotlin_mvvm.util

interface AppConstants {
    companion object {
        const val BASE_URL = "http://pastebin.com/raw/"
        const val READ_TIMEOUT = 60L
        const val WRITE_TIMEOUT = 60L
        const val MAX_REQUESTS = 2
    }
}