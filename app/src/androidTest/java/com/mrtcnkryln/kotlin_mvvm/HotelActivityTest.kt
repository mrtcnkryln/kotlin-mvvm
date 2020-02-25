package com.mrtcnkryln.kotlin_mvvm

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.mrtcnkryln.kotlin_mvvm.ui.view.activity.HotelActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class HotelActivityTest {

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule(HotelActivity::class.java)

    @Test
    fun onScrollSlider() {
        onView(withId(R.id.bannerLayout)).perform(ViewActions.swipeRight())
    }

    @Test
    fun onOpenFlights() {
        onView(withId(R.id.findAvailableFlights)).perform(click())
    }



}