package com.example.domain

import com.example.domain.common.mapToDomainSchoolSat
import com.example.domain.data.DomainSchoolSat
import com.example.domain.data.UIState
import com.example.model.exceptions.SchoolExceptions
import com.example.model.repository.IRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailedSchoolWithSatUseCase @Inject constructor(private val repository: IRepository) {

    operator fun invoke(schoolID: String): Flow<UIState<List<DomainSchoolSat>>> {
        return flow {
            emit(UIState.loading(true))
            repository.getSchoolByDBN(schoolID).also { schoolSat ->
                emit(UIState.loading(false))
                emit(
                    UIState.success(
                        schoolSat.map { it.mapToDomainSchoolSat() }
                    )
                )
            }
        }.catch {
            // Having exceptions passed from Model
            assert(it is SchoolExceptions)
            emit(UIState.failure(it.message ?: "Unknown"))
        }
    }
}