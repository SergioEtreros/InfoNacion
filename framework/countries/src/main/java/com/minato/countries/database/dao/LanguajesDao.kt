package com.minato.countries.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.minato.countries.database.entities.Languages

@Dao
interface LanguajesDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertlanguages(languages: List<Languages>)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertlanguage(language: Languages)
}