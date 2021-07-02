package io.github.bulbasaurs.pokegotchi.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import io.github.bulbasaurs.pokegotchi.database.data.VenueEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VenueDao {
    @Query("SELECT * FROM venue_table")
    fun getVenues(): Flow<List<VenueEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVenue(venue: VenueEntity)

    @Update
    suspend fun updateVenue(venue: VenueEntity)

    @Delete
    suspend fun deleteVenue(venue: VenueEntity)
}