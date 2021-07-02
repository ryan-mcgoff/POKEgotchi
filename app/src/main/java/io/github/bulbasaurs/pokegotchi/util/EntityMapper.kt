package io.github.bulbasaurs.pokegotchi.util

interface EntityMapper<Entity, DomainModel> {

    fun fromEntity(entity: Entity): DomainModel

    fun fromDomainModel(model: DomainModel): Entity
}