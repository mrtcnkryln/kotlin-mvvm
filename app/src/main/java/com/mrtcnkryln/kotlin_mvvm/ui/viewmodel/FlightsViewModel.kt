package com.mrtcnkryln.kotlin_mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.mrtcnkryln.kotlin_mvvm.model.AllFlightsModel
import com.mrtcnkryln.kotlin_mvvm.network.ApiInterface
import com.mrtcnkryln.kotlin_mvvm.ui.viewmodel.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FlightsViewModel : BaseViewModel() {
    var apiInterface : ApiInterface? = null
    @Inject set
    private  val compositeDisposable = CompositeDisposable()
    var resultLiveData : MutableLiveData<AllFlightsModel> = MutableLiveData()

    fun getFlights() {
        apiInterface?.flights()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnSubscribe {

            }
            ?.subscribe(
                { result ->
                    resultLiveData.value = result
                },
                {
                    // set state
                }
            )?.let { compositeDisposable.add(it) }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}