package com.example.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SchoolListDTO(
    @Json(name = "dbn")
    val schoolID: String?,
    @Json(name = "school_name")
    val schoolName: String?,
    @Json(name = "overview_paragraph")
    val overview: String?,
    @Json(name = "phone_number")
    val phoneNumber: String?,
    val website: String?,
    @Json(name = "school_email")
    val schoolEmail: String?
)
@JsonClass(generateAdapter = true)
data class SchoolListSATDTO(
    @Json(name = "dbn")
    val schoolID: String?,
    @Json(name = "school_name")
    val schoolName: String?,
    @Json(name = "num_of_sat_test_takers")
    val satTestTakers: String?,
    @Json(name = "sat_critical_reading_avg_score")
    val satCriticalReading: String?,
    @Json(name = "sat_math_avg_score")
    val satMath: String?,
    @Json(name = "sat_writing_avg_score")
    val satWriting: String?
)

@Entity(tableName = "schools_sat")
data class SchoolSat(
    @PrimaryKey(autoGenerate = false)
    val schoolID: String,
    val schoolName: String,
    val satTestTakers: String,
    val satCriticalReading: String,
    val satMath: String,
    val satWriting: String,
    val overview: String,
    val phoneNumber: String,
    val website: String,
    val schoolEmail: String
)