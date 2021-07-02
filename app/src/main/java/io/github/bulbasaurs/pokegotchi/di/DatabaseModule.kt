package io.github.bulbasaurs.pokegotchi.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.bulbasaurs.pokegotchi.database.VenueDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesVenueDatabase(
        app: Application,
        callBack: VenueDatabase.CallBack
    ): VenueDatabase {
        return Room.databaseBuilder(app, VenueDatabase::class.java, "venue_database")
            .fallbackToDestructiveMigration()
            .addCallback(callBack)
            .build()
    }

    @Provides
    fun providesVenueDao(database: VenueDatabase) = database.venueDao()
}