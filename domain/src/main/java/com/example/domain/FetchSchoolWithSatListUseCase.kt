package com.example.domain

import com.example.domain.common.mapToDomainSchoolSat
import com.example.domain.common.schoolWithSatAggregate
import com.example.domain.data.DomainSchoolSat
import com.example.domain.data.UIState
import com.example.model.data.SchoolListDTO
import com.example.model.data.SchoolListSATDTO
import com.example.model.exceptions.SchoolExceptions
import com.example.model.repository.IRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.yield
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
    operator fun invoke(): Flow<UIState<List<DomainSchoolSat>>> {
        return flow {
            emit(UIState.loading(true))
            val schoolsFromRemote = mutableListOf<SchoolListDTO>()
            val schoolsSatFromRemote = mutableListOf<SchoolListSATDTO>()
            coroutineScope {
                async {
                    repository.getAllSchoolsFromRemote()
                }.await().also { schoolsFromRemote.addAll(it) }
                async {
                    repository.getAllSchoolsSatFromRemote()
                }.await().also { schoolsSatFromRemote.addAll(it) }
            }
            yield()
            // find schools that exists in sat list
            schoolsFromRemote.forEach { schools ->
                schoolsSatFromRemote.forEach { sat ->
                    if (schools.schoolID == sat.schoolID)
                        schools.schoolWithSatAggregate(sat).also {
                            // insert into SchoolDB
                            repository.insertSchoolsWithSat(it)
                        }
                }
            }
            emit(UIState.loading(false))
            emit(UIState.success(
                repository.getAllSchoolsWithSat().map { it.mapToDomainSchoolSat() }
            ))
        }.catch {
            // Having exceptions passed from Model
            assert(it is SchoolExceptions)
            emit(
                UIState.failure(
                    it.message ?: "Unknown"
                )
            )
        }
    }
}