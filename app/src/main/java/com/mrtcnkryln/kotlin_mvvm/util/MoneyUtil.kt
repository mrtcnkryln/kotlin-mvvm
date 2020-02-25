package com.mrtcnkryln.kotlin_mvvm.util

class MoneyUtil {
    companion object {
        fun getFormattedMoney(price : String) : String  {
            return "$price$"
        }
    }
}