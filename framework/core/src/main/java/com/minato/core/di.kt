package com.minato.core

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object FrameworkCoreModule {

   @Provides
   @Singleton
   fun provideDB(app: Application) =
      Room.databaseBuilder(app, CountryDb::class.java, "Countries").build()

   @Provides
   fun providesCountrydao(db: CountryDb) = db.countryDao()

   @Provides
   fun provideCountryService() = CountryClient()
}