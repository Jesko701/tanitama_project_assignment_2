package com.example.tanitama.di

import com.example.tanitama.data.repository.WeatherRepository
import com.example.tanitama.data.repository.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
////abstract class RepositoryModule {
//object RepositoryModule {
//    fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository {
//        return weatherRepositoryImpl
//    }
//    fun bindTanitamaRepository(tanitamaRepositoryImpl: TanitamaRepositoryImpl): TanitamaRepository {
//        return tanitamaRepositoryImpl
//    }
//}

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository
}