package androidchallenge.presentation

import android.arch.lifecycle.ViewModel
import androidchallenge.data.City

class CitiesViewModel : ViewModel() {
    fun getCities() = listOf(
        City("Lisboa", 38, -9),
        City("Madrid", 40, -3),
        City("Paris", 48, 2),
        City("Berlim", 52, 13),
        City("Roma", 41, 12),
        City("Londres", 51, -0),
        City("Dublin", 53, -6),
        City("Praga", 50, 14),
        City("Viena", 48, 16)
    )
}