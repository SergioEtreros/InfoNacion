package com.minato.countries

import com.minato.countries.database.CountriesRoomDataSource
import com.minato.countries.network.CountriesServerDataSource
import com.minato.country.data.CountryLocalDataSource
import com.minato.country.data.CountryRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class FrameworkCountryModule {

   @Binds
   abstract fun bindsLocalDataSource(localDataSource: CountriesRoomDataSource): CountryLocalDataSource

   @Binds
   abstract fun bindsRemoteDataSource(remoteDataSource: CountriesServerDataSource): CountryRemoteDataSource

}
