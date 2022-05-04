package androidchallenge.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object WeatherAPI {

    private fun initRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val SERVICE: WeatherService = initRetrofit()
        .create(WeatherService::class.java)
}