package com.mrtcnkryln.kotlin_mvvm.ui.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mrtcnkryln.kotlin_mvvm.R
import com.mrtcnkryln.kotlin_mvvm.model.AllFlightsModel
import com.mrtcnkryln.kotlin_mvvm.ui.view.adapter.FlightAdapter
import com.mrtcnkryln.kotlin_mvvm.ui.viewmodel.FlightsViewModel
import kotlinx.android.synthetic.main.activity_flights.*

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
        setupToolBar()
        setupAdapter()
        flightsViewModel = ViewModelProvider(this).get(FlightsViewModel::class.java)
        flightsViewModel.getFlights()
        flightsViewModel.resultLiveData.observe(this, Observer { setFlights(it)  })
    }

    private fun setupToolBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    private fun setupAdapter() {

    }

    private fun setFlights(allFlightsModel: AllFlightsModel) {
        //set all flights to view
        recylerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recylerView.adapter = FlightAdapter(allFlightsModel.flights!!)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}