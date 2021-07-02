package io.github.bulbasaurs.pokegotchi.network

import io.github.bulbasaurs.pokegotchi.database.data.VenueEntity
import io.github.bulbasaurs.pokegotchi.network.models.VenueDomainModel
import io.github.bulbasaurs.pokegotchi.network.models.VenueResponse
import io.github.bulbasaurs.pokegotchi.util.EntityMapper

class NetworkMapper : EntityMapper<VenueEntity, VenueDomainModel> {
    override fun fromEntity(entity: VenueEntity): VenueDomainModel {
        return VenueDomainModel(
            response = VenueResponse(
                headerLocation = entity.headerLocation
            )
        )
    }

    override fun fromDomainModel(model: VenueDomainModel): VenueEntity {
        return VenueEntity(
            headerLocation = model.response.headerLocation
        )
    }
}

