package androidchallenge.presentation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidchallenge.R
import androidchallenge.data.City
import kotlinx.android.synthetic.main.city.view.*


class CitiesAdapter(
    private val cities: List<City>,
    val onItemClickListener: ((city: City) -> Unit)
) : RecyclerView.Adapter<CitiesAdapter.CityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): CityViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.city, parent, false)
        return CityViewHolder(
            itemView,
            onItemClickListener
        )
    }

    override fun getItemCount() = cities.count()

    override fun onBindViewHolder(viewHolder: CityViewHolder, position: Int) {
        viewHolder.bindView(cities[position])
    }

    class CityViewHolder(
            itemView: View,
            private val onItemClickListener: ((city: City) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindView(city: City) {
            itemView.cityName.text = city.name

            itemView.setOnClickListener {
                onItemClickListener.invoke(city)
            }
        }
    }
}