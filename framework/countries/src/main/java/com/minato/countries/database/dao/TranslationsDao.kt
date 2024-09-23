package com.minato.countries.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.minato.countries.database.entities.Translations

@Dao
interface TranslationsDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertTranslation(translation: Translations)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertTranslations(translations: List<Translations>)
}