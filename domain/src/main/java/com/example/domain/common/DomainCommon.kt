package com.example.domain.common

import com.example.domain.data.DomainSchoolSat
import com.example.model.data.SchoolListDTO
import com.example.model.data.SchoolListSATDTO
import com.example.model.data.SchoolSat

internal fun SchoolListDTO.schoolWithSatAggregate(
    schoolSatDTO:SchoolListSATDTO
): SchoolSat {
    return SchoolSat(
        schoolID,
        schoolName,
        schoolSatDTO.satTestTakers,
        schoolSatDTO.satCriticalReading,
        schoolSatDTO.satMath,
        schoolSatDTO.satWriting,
        overview,
        phoneNumber,
        website,
        schoolEmail
    )
}

internal fun SchoolSat.mapToDomainSchoolSat(): DomainSchoolSat {
    return DomainSchoolSat(
        schoolID = this.schoolID,
        schoolName = schoolName,
        satTestTakers = satTestTakers,
        satCriticalReading = satCriticalReading,
        satMath = satMath,
        satWriting = satWriting,
        overview = overview,
        phoneNumber = phoneNumber,
        website = website,
        schoolEmail = schoolEmail
    )
}