package androidchallenge.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherDetails(
    @Json(name = "weather")
    val weather: List<Weather>,
    @Json(name = "main")
    val main: Main
)

data class Weather(
    @Json(name = "description")
    val description : String
)

data class Main(
    @Json(name = "description")
    val temp : String
)



