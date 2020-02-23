package com.mrtcnkryln.kotlin_mvvm.ui.viewmodel.base

import androidx.lifecycle.ViewModel
import com.mrtcnkryln.kotlin_mvvm.di.ApiComponent
import com.mrtcnkryln.kotlin_mvvm.di.DaggerApiComponent
import com.mrtcnkryln.kotlin_mvvm.di.NetworkModule
import com.mrtcnkryln.kotlin_mvvm.ui.viewmodel.HotelViewModel

abstract class BaseViewModel : ViewModel () {
    private val injector: ApiComponent = DaggerApiComponent
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is HotelViewModel -> {
                injector.inject(this)
            }


        }
    }
}