package com.example.tanitama.di

import com.example.tanitama.location.DefaultLocationTracker
import com.example.tanitama.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

////@Module
////@InstallIn(SingletonComponent::class)
////abstract class LocationModule {
//object LocationModule {
////    @Binds
////    @Singleton
//    fun bindLocationTracker(defaultLocationTracker: DefaultLocationTracker): LocationTracker {
//        return defaultLocationTracker
//    }
//}

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {
    @Binds
    @Singleton
    abstract fun bindLocationTracker(defaultLocationTracker: DefaultLocationTracker): LocationTracker
}