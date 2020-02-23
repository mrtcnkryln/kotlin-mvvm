package com.mrtcnkryln.kotlin_mvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mrtcnkryln.kotlin_mvvm.R
import com.mrtcnkryln.kotlin_mvvm.model.HotelModel
import com.mrtcnkryln.kotlin_mvvm.ui.viewmodel.HotelViewModel

class HotelActivity : AppCompatActivity() {

    companion object {
        fun newInstance() = HotelActivity()
    }

    private lateinit var hotelViewModel: HotelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateUI() //observe the view model
    }

    fun updateUI() {
        hotelViewModel = ViewModelProvider(this).get(HotelViewModel::class.java)
        hotelViewModel.getHotel()
        hotelViewModel.resultLiveData.observe(this, Observer { setHotel(it)  })
    }

    fun setHotel(hotelModel: HotelModel) {
        //binding hotel model to view

    }
}
