package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    fun onDessertClicked(){
        _uiState.update {
            val dessertsSold = it.dessertsSold + 1
            var nextDessertIndex = determineDessertToShow(dessertsSold)
            it.copy(
                revenue = it.revenue + it.currentDessertIndex,
                dessertsSold = dessertsSold,
                currentDessertIndex = nextDessertIndex,
                currentDessertPrice = Datasource.dessertList[nextDessertIndex].price,
                currentDessertImageId = Datasource.dessertList[nextDessertIndex].imageId,
            )
        }
    }

    private fun determineDessertToShow(dessertsSold: Int): Int {
        var dessertIndex = 0
        for (index in Datasource.dessertList.indices) {
            if (dessertsSold >= Datasource.dessertList[dessertIndex].startProductionAmount) {
                dessertIndex = index
            } else {
                break
            }
        }

        return dessertIndex
    }
}