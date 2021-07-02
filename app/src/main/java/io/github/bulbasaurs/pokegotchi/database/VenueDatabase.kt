package io.github.bulbasaurs.pokegotchi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import io.github.bulbasaurs.pokegotchi.di.AppModule
import io.github.bulbasaurs.pokegotchi.database.data.VenueEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [VenueEntity::class], version = 1)
abstract class VenueDatabase : RoomDatabase() {

    abstract fun venueDao(): VenueDao

    class CallBack @Inject constructor(
        private val venueDao: Provider<VenueDao>,
        @AppModule.ApplicationCoroutineScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            applicationScope.launch {
                venueDao.get().insertVenue(VenueEntity(headerLocation = ""))
            }
        }
    }
}