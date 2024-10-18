package com.minato.infonacion.di

import android.app.Application
import androidx.room.Room
import com.minato.core.CountryDb
import com.minato.core.FrameworkExtrasModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import javax.inject.Named
import javax.inject.Singleton

@Module
@TestInstallIn(
   components = [SingletonComponent::class],
   replaces = [FrameworkExtrasModule::class]
)
object TestAppModule {

   @Provides
   @Singleton
   fun provideDatabase(app: Application): CountryDb {
      val db = Room.inMemoryDatabaseBuilder(app, CountryDb::class.java)
         .setTransactionExecutor(Dispatchers.Main.asExecutor())
         .allowMainThreadQueries()
         .build()

      return db
   }

   @Provides
   @Singleton
   @Named("base_url")
   fun provideBaseUrl() = "http://localhost:8080"
}