package com.mrtcnkryln.kotlin_mvvm

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.mrtcnkryln.kotlin_mvvm.ui.view.activity.FlightsActivity
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertNotSame
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Condition

@RunWith(AndroidJUnit4::class)
class FlightsActivityTest {



    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule(FlightsActivity::class.java)

    @Test
    fun checkFlights() {
        val recyclerView = mActivityRule.activity.findViewById(R.id.recylerView) as RecyclerView
        //check the flights can checking
         val lock = CountDownLatch(1)
        lock.await(3000,  TimeUnit.MILLISECONDS)
        assertNotNull(recyclerView)
        assertNotNull(recyclerView.adapter)
        assertNotSame(0, recyclerView.adapter!!.itemCount)
    }





}