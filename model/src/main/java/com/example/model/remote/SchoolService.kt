package com.example.model.remote

import com.example.model.data.SchoolListDTO
import com.example.model.data.SchoolListSATDTO
import retrofit2.http.GET

interface SchoolService {
    @GET(ENDPOINT_SCHOOL)
    suspend fun getAllSchools(): List<SchoolListDTO>
    @GET(ENDPOINT_SAT)
    suspend fun getAllSat(): List<SchoolListSATDTO>
}