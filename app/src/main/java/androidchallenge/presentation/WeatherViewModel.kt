package androidchallenge.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import androidchallenge.data.WeatherAPI
import androidchallenge.data.response.WeatherDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel : ViewModel() {

    val appID = "183a67470719210fe8dc59d507adc602"
    val responseSuccessful: MutableLiveData<Boolean> = MutableLiveData()
    lateinit var weatherData: WeatherDetails

    fun getWeather(lat: Int, lon: Int) {
        WeatherAPI.SERVICE.getWeather(lat, lon, appID).enqueue(object : Callback<WeatherDetails> {
            override fun onResponse(
                call: Call<WeatherDetails>,
                details: Response<WeatherDetails>
            ) {
                if (details.isSuccessful) {

                    details.body()?.let {
                        weatherData = it
                        responseSuccessful.postValue(true)
                    }
                } else {
                    responseSuccessful.postValue(false)
                }
            }

            override fun onFailure(call: Call<WeatherDetails>, t: Throwable) {
                responseSuccessful.postValue(false)
            }
        })
    }
}