package com.minato.map

import android.app.Application
import com.minato.map.data.GoogleMapsDataSource
import com.minato.map.data.OpenStreetMapDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object FrameworkMapModule {

   @Provides
   fun provideGoogleDataSource(app: Application) = GoogleDataSource(app)

   @Provides
   fun provideOpenStreetDataSource(app: Application) = OpenStreetDataSource(app)
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class FrameworkMapBindsModule {

   @Binds
   abstract fun bindGoogleDataSource(googleDataSource: GoogleDataSource): GoogleMapsDataSource

   @Binds
   abstract fun bindOpenStreetDataSource(openStreetDataSource: OpenStreetDataSource): OpenStreetMapDataSource
}