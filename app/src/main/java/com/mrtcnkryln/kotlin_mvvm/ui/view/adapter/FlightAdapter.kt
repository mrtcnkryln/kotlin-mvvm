package com.mrtcnkryln.kotlin_mvvm.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrtcnkryln.kotlin_mvvm.R
import com.mrtcnkryln.kotlin_mvvm.model.FlightModel
import com.mrtcnkryln.kotlin_mvvm.util.AppConstants
import com.mrtcnkryln.kotlin_mvvm.util.DateManager
import com.mrtcnkryln.kotlin_mvvm.util.MoneyUtil
import kotlinx.android.synthetic.main.row_item_flight.view.*

class FlightAdapter(val flights : MutableList<FlightModel>) : RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_item_flight,parent,false)
        return FlightViewHolder(v)

    }

    override fun getItemCount(): Int {
        return flights.size
    }


    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val flight = flights[position]
        holder.itemView.airline.text = flight.airline
        holder.itemView.apertureAirport.text = flight.arrival_airport
        holder.itemView.departureAirport.text = flight.departure_airport
        holder.itemView.apertureTime.text = DateManager.getFormattedTime(flight.arrival_date!!, AppConstants.VALID_CLOCK_FORMAT)
        holder.itemView.departureTime.text = DateManager.getFormattedTime(flight.departure_date!!, AppConstants.VALID_CLOCK_FORMAT)
        holder.itemView.flightDate.text = DateManager.getFormattedTime(flight.departure_date!!, AppConstants.VALID_DATE_FORMAT)
        holder.itemView.price.text = MoneyUtil.getFormattedMoney(flight.price.toString())

    }


    class FlightViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}