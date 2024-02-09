package com.example.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.model.data.SchoolSat

@Dao
interface SchoolDAO {
    @Query(value = "SELECT * FROM schools_sat")
    suspend fun getAllSchoolsWithSat(): List<SchoolSat>

    @Insert(entity = SchoolSat::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSchoolsWithSat(newSchoolWithSat: SchoolSat)

    @Query(value = "SELECT * FROM schools_sat WHERE schoolID LIKE :schoolDBN")
    suspend fun getSchoolByDBN(schoolDBN: String): List<SchoolSat>
}