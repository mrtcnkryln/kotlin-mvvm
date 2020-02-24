package com.mrtcnkryln.kotlin_mvvm.ui.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mrtcnkryln.kotlin_mvvm.R
import com.mrtcnkryln.kotlin_mvvm.model.AllFlightsModel
import com.mrtcnkryln.kotlin_mvvm.ui.viewmodel.FlightsViewModel

class FlightsActivity : AppCompatActivity() {

    companion object {
        fun newInstance() = FlightsActivity()
    }

    private lateinit var flightsViewModel: FlightsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flights)
        updateUI() //observe the view model
    }

    private fun updateUI() {
        flightsViewModel = ViewModelProvider(this).get(FlightsViewModel::class.java)
        flightsViewModel.getFlights()
        flightsViewModel.resultLiveData.observe(this, Observer { setFlights(it)  })
    }

    private fun setFlights(allFlightsModel: AllFlightsModel) {
        //set all flights to view
    }
}