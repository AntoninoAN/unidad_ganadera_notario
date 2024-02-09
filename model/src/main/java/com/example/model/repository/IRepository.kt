package com.example.model.repository

import com.example.model.data.SchoolListDTO
import com.example.model.data.SchoolListSATDTO
import com.example.model.data.SchoolSat

interface IRepository {
    suspend fun getAllSchoolsFromRemote(): List<SchoolListDTO>
    suspend fun getAllSchoolsSatFromRemote(): List<SchoolListSATDTO>
    suspend fun getAllSchoolsWithSat(): List<SchoolSat>
    suspend fun insertSchoolsWithSat(schoolWithSat: SchoolSat)
    suspend fun getSchoolByDBN(schoolID: String): List<SchoolSat>
}