package com.minato.countries.detail

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.minato.common.Detail
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
class DetailViewmodelComponent {

   @Provides
   @ViewModelScoped
   @Named("countryName")
   fun provideCountryNamed(savedStateHandle: SavedStateHandle): String =
      savedStateHandle.toRoute<Detail>().countryName
}