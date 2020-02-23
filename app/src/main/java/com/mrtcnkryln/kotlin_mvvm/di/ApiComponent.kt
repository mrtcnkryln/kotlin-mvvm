package com.mrtcnkryln.kotlin_mvvm.di

import com.mrtcnkryln.kotlin_mvvm.ui.viewmodel.HotelViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ApiComponent {
    @Component.Builder
    interface Builder {
        fun build(): ApiComponent
        fun networkModule(networkModule: NetworkModule): Builder
    }

    fun inject(hotelViewModel: HotelViewModel)

}