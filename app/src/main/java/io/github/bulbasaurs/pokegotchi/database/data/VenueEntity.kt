package io.github.bulbasaurs.pokegotchi.database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "venue_table")
data class VenueEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name="header_location")
    val headerLocation: String
)