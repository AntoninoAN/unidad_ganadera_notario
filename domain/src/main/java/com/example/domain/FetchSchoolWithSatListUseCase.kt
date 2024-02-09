package com.example.domain

import com.example.domain.common.schoolWithSatAggregate
import com.example.domain.data.UIState
import com.example.model.exceptions.SchoolExceptions
import com.example.model.repository.IRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchSchoolWithSatListUseCase @Inject constructor(
    private val repository: IRepository
) {

    /**
     * In order to create a Single source of truth.
     * Fetch data from SchoolsList and Schools Sat
     * Aggregate to have a List of SchoolsWithSat
     * Insert data into RoomDB and fetch from RoomDB
     */
    operator fun invoke(): Flow<UIState> {
        return flow {
            emit(UIState.Loading)
            val schoolsFromRemote = repository.getAllSchoolsFromRemote()
            val schoolsSatFromRemote = repository.getAllSchoolsSatFromRemote()

            schoolsFromRemote.zip(schoolsSatFromRemote) { schools, schoolsSat ->
                schools.schoolWithSatAggregate(schoolsSat)
            }.forEach {
                repository.insertSchoolsWithSat(it)
            }.run {
                emit(
                    UIState.Success(
                        repository.getAllSchoolsWithSat()
                    )
                )
            }
        }.catch {
            // Having exceptions passed from Model
            assert(it is SchoolExceptions)
            emit(UIState.Failure(it.message ?: "Uknwon"))
        }
    }
}