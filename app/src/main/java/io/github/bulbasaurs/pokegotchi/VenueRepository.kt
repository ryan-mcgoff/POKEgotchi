package io.github.bulbasaurs.pokegotchi

import io.github.bulbasaurs.pokegotchi.database.VenueDao
import io.github.bulbasaurs.pokegotchi.database.data.VenueEntity
import io.github.bulbasaurs.pokegotchi.network.NetworkMapper
import io.github.bulbasaurs.pokegotchi.network.endpoints.VenueEndPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class VenueRepository @Inject constructor(
    private val venueDao : VenueDao,
    private val venueEndPoint: VenueEndPoint,
    private val networkMapper: NetworkMapper
) {
    suspend fun getVenues(keyword : String) : Flow<VenueEntity> = flow {
        val venueDomainList = venueEndPoint.getVenue(keyword).body()
        emit(networkMapper.fromDomainModel(venueDomainList!!))
        // val venueEntities = venueDomainList!!.map {
        //     val venueEntity = networkMapper.fromDomainModel(it)
        //     // Cache venue entity
        //     venueDao.insertVenue(venueEntity)
        //     // Return venue entity
        //     venueEntity
        // }
        // emit(venueEntities)
    }
}