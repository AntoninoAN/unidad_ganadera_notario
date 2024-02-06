package com.example.model.repository

import com.example.model.data.SchoolListDTO
import com.example.model.data.SchoolListSATDTO
import com.example.model.data.SchoolSat
import com.example.model.exceptions.SchoolLocalExceptions
import com.example.model.exceptions.SchoolRemoteExceptions
import com.example.model.local.SchoolDAO
import com.example.model.remote.SchoolService
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: SchoolService,
    private val dao: SchoolDAO
) : IRepository {
    override suspend fun getAllSchoolsFromRemote(): List<SchoolListDTO> {
        try {
            return service.getAllSchools().ifEmpty { throw SchoolRemoteExceptions(Exception("Empty body")) }
        } catch (ex: Exception) {
            throw SchoolRemoteExceptions(ex)
        }
    }

    override suspend fun getAllSchoolsSatFromRemote(): List<SchoolListSATDTO> {
        try {
            return service.getAllSat().ifEmpty { throw SchoolRemoteExceptions(Exception("Empty body")) }
        } catch (ex: Exception) {
            throw SchoolRemoteExceptions(ex)
        }
    }

    override suspend fun getAllSchoolsWithSat(): List<SchoolSat> {
        try {
            return dao.getAllSchoolsWithSat().ifEmpty { throw SchoolLocalExceptions(Exception("No results")) }
        } catch (ex: Exception) {
            throw SchoolLocalExceptions(ex)
        }
    }

    override suspend fun insertSchoolsWithSat(schoolWithSat: SchoolSat) {
        try {
            dao.insertAllSchoolsWithSat(schoolWithSat)
        } catch (ex: Exception) {
            throw SchoolLocalExceptions(ex)
        }
    }

}