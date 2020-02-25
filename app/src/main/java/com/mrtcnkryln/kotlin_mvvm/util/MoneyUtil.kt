package com.mrtcnkryln.kotlin_mvvm.util

import android.icu.text.SimpleDateFormat
import java.text.ParseException

class MoneyUtil {
    companion object {
        fun getFormattedMoney(price : String) : String  {
            return "$price$"
        }
    }
}