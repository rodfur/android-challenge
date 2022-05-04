package androidchallenge.data

import androidchallenge.data.response.WeatherDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("https://api.openweathermap.org/data/2.5/weather")
    fun getWeather(
        @Query("lat") lat: Int,
        @Query("lon") lon: Int,
        @Query("appid") sort: String
    ): Call<WeatherDetails>
}