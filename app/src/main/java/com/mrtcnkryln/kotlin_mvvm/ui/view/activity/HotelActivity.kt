package com.mrtcnkryln.kotlin_mvvm.ui.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.mrtcnkryln.kotlin_mvvm.R
import com.mrtcnkryln.kotlin_mvvm.model.HotelModel
import com.mrtcnkryln.kotlin_mvvm.ui.viewmodel.HotelViewModel
import kotlinx.android.synthetic.main.activity_main.*
import technolifestyle.com.imageslider.FlipperView

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

    private fun updateUI() {

        hotelViewModel = ViewModelProvider(this).get(HotelViewModel::class.java)
        hotelViewModel.getHotel()
        hotelViewModel.resultLiveData.observe(this, Observer { setHotel(it)  })
        findAvailableFlights?.setOnClickListener {
            onFindAvailableFlights()
        }
    }

    private fun setHotel(hotelModel: HotelModel) {
        //binding hotel model to view
        hotelModel.images?.let { setBanner(it) }
        hotelModel.facilities?.let{setFacilities(it) }
        hotelName?.text = hotelModel.name
        hotelLocation?.text = hotelModel.hotel_location
        hotelDescription?.text = hotelModel.description
        ratingBar?.rating = hotelModel.rating?.toFloat()!!
    }


    private fun setBanner(images : ArrayList<String>){
        val flipperViewList: ArrayList<FlipperView> = ArrayList()
        images.forEach{ url ->
            val view = FlipperView(baseContext)
            view.setImage(url) { flipperImageView, image ->
                Glide.with(this).load(image).into(flipperImageView)
                }
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setDescriptionBackgroundAlpha(0f)
            flipperViewList.add(view)
        }
        bannerLayout.addFlipperViewList(flipperViewList = flipperViewList)
        bannerLayout.showCircleIndicator()
        bannerLayout.startAutoCycle()
    }

    private fun setFacilities(facility : ArrayList<String>){
        hotelFacilites.removeAllViews()
        facility.forEach { f ->
            val facilityView: View = LayoutInflater.from(this)
                .inflate(R.layout.row_item_facility, hotelFacilites, false)
            val hotelFacility =
                facilityView.findViewById(R.id.hotelFacility) as TextView
            hotelFacility.text = f
            hotelFacilites.addView(facilityView)
        }
    }

    private fun onFindAvailableFlights (){
        //find available flights on new page
        startActivity(Intent(this, FlightsActivity::class.java))
    }

}
