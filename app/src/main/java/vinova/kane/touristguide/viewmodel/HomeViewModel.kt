package vinova.kane.touristguide.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import vinova.kane.touristguide.model.Place
import vinova.kane.touristguide.net.Client

class HomeViewModel: ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val apiService = Client.getClient()
    val placesResult = MutableLiveData<List<Place>>()

    fun getPlaces(){
        compositeDisposable.add(
            apiService.getPlaces()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    placesResult.value = it
                },{
                    Log.d("HomeViewModel", "Message: ${it.message}")
                })
        )
    }

}