package io.github.bulbasaurs.pokegotchi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // Supervisorjob, if another child fails, keep the scope running
    @ApplicationCoroutineScope
    @Provides
    @Singleton
    fun providesApplicationScope() = CoroutineScope(SupervisorJob())

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class ApplicationCoroutineScope
}