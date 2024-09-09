package com.minato.core

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object FrameworkCoreModule {

   @Provides
   fun providesCountrydao(db: CountryDb) = db.countryDao()

   @Provides
   fun provideCountryService(@Named("base_url") baseUrl: String) = CountryClient(baseUrl).instance
}

@Module
@InstallIn(SingletonComponent::class)
internal object FrameworkExtrasModule {

   @Provides
   @Singleton
   fun provideDB(app: Application) =
      Room.databaseBuilder(app, CountryDb::class.java, "Countries").build()

   @Provides
   @Singleton
   @Named("base_url")
   fun provideBaseUrl() = "https://restcountries.com/v3.1/"
}