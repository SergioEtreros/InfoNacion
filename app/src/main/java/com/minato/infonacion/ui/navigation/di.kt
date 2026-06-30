package com.minato.infonacion.ui.navigation

import com.minato.core.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

   @Provides
   @Singleton
   @Named("restcountries_api")
   fun provideApiKey() = BuildConfig.RESTCOUNTRIES_API
}