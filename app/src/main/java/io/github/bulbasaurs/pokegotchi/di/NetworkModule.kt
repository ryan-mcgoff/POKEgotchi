package io.github.bulbasaurs.pokegotchi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.bulbasaurs.pokegotchi.network.FourSquareClientInterceptor
import io.github.bulbasaurs.pokegotchi.network.NetworkMapper
import io.github.bulbasaurs.pokegotchi.network.endpoints.VenueEndPoint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideClient() : OkHttpClient {
        val interceptors = listOf(
            HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY)},
            FourSquareClientInterceptor()
        )
        return OkHttpClient.Builder().apply {
            networkInterceptors().addAll(interceptors)
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetroFit(client: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.foursquare.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideVenueEndPoint(retroFit: Retrofit) : VenueEndPoint {
        return retroFit.create(VenueEndPoint::class.java)
    }

    @Singleton
    @Provides
    fun provideNetworkMapper() = NetworkMapper()
}