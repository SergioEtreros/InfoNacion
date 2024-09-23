package com.minato.countries.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.minato.countries.database.entities.Borders

@Dao
interface BordersDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertBorders(borders: List<Borders>)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertBorder(border: Borders)
}