package io.github.bulbasaurs.pokegotchi.network.endpoints
import io.github.bulbasaurs.pokegotchi.network.models.VenueDomainModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VenueEndPoint {
    @GET("v2/venues/explore")
    suspend fun getVenue(@Query("query") keyword : String) : Response<VenueDomainModel>
}