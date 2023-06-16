package com.example.tanitama.di

import android.app.Application
import com.example.tanitama.data.retrofit.WeatherApi
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

//@Module
//@InstallIn(ViewModelComponent::class)
//abstract class AppModule {
//    @Binds
//    @ViewModelScoped
//    abstract fun provideRepository(tanitamaRepositoryImpl: TanitamaRepositoryImpl): TanitamaRepository
//}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl("https://capstone-ngetes.de.r.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }
}