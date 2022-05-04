package androidchallenge.presentation

import android.content.Context
import android.content.Intent
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import androidchallenge.R
import androidchallenge.data.City
import kotlinx.android.synthetic.main.weather.*
import kotlinx.android.synthetic.main.include_toolbar.*

class WeatherActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather)

        val title = intent.getStringExtra(EXTRA_CITYNAME)
        val lat = intent.getIntExtra(EXTRA_LAT, 0)
        val lon = intent.getIntExtra(EXTRA_LON, 0)

        setupToolbar(toolbarMain, true)

        val viewModel: WeatherViewModel = ViewModelProviders.of(this).get(
            WeatherViewModel::class.java
        )

        viewModel.getWeather(lat, lon)

        viewModel.responseSuccessful.observe(this, Observer {
            progressBar.visibility = View.GONE
            if (it == true) {
                cityName.text = title
                weatherDesc.text = viewModel.weatherData.weather[0].description
                temp.text = viewModel.weatherData.main.temp + "k"
            } else {
                errorText.visibility = View.VISIBLE
            }
        })
    }

    companion object {
        private const val EXTRA_CITYNAME = "CITYNAME"
        private const val EXTRA_LAT = "LAT"
        private const val EXTRA_LON = "LON"

        fun getStartIntent(context: Context, city: City): Intent {
            return Intent(context, WeatherActivity::class.java).apply {
                with(city) {
                    putExtra(EXTRA_CITYNAME, name)
                    putExtra(EXTRA_LAT, lat)
                    putExtra(EXTRA_LON, lon)
                }
            }
        }
    }
}
