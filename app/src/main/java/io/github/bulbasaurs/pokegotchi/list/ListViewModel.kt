package io.github.bulbasaurs.pokegotchi.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.bulbasaurs.pokegotchi.VenueRepository
import io.github.bulbasaurs.pokegotchi.database.data.VenueEntity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val venueRepository : VenueRepository
): ViewModel() {

    val venues: LiveData<List<VenueEntity>> = MutableLiveData()

    fun load() {
        viewModelScope.launch {
            venueRepository.getVenues("coffee").collect {
                val mutableList = mutableListOf<VenueEntity>()
                mutableList.add(it)
                (venues as MutableLiveData).postValue(mutableList)
            }
        }
    }
}