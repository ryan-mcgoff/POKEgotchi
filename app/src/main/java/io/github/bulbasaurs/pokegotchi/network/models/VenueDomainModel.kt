package io.github.bulbasaurs.pokegotchi.network.models

data class VenueResponse(
    val headerLocation: String
)

class VenueDomainModel (
    val response : VenueResponse,
)