package com.minato.countries.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Country(
   @PrimaryKey
   val name: String
)