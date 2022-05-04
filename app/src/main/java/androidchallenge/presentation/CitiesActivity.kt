package androidchallenge.presentation

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import androidchallenge.R
import kotlinx.android.synthetic.main.cities.*
import kotlinx.android.synthetic.main.include_toolbar.*

class CitiesActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cities)
        setupToolbar(toolbarMain)

        val viewModel: CitiesViewModel = ViewModelProviders.of(this)
            .get(CitiesViewModel::class.java)

        with(citiesRecycler) {
            val linearLayoutManager = LinearLayoutManager(
                this@CitiesActivity,
                RecyclerView.VERTICAL,
                false
            )
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            adapter =
                CitiesAdapter(viewModel.getCities()) {
                    val intent = WeatherActivity.getStartIntent(this@CitiesActivity, it)
                    this@CitiesActivity.startActivity(intent)
                }
        }
    }
}


