package com.mrtcnkryln.kotlin_mvvm.util

import android.icu.text.SimpleDateFormat
import java.text.ParseException

class DateManager {
    companion object {
        fun getFormattedTime(date : String, format : String) : String  {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val dateFormatted = SimpleDateFormat(format)
            return try {
                val dateAt = dateFormat.parse(date)
                dateFormatted.format(dateAt)
            } catch (e: ParseException) {
                e.printStackTrace()
                ""
            }

        }
    }
}