package io.github.bulbasaurs.pokegotchi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import io.github.bulbasaurs.pokegotchi.PokegotchiApplication

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


}