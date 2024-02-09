package com.example.domain

import com.example.domain.data.UIState
import com.example.model.exceptions.SchoolExceptions
import com.example.model.repository.IRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailedSchoolWithSatUseCase @Inject constructor(private val repository: IRepository) {

    operator fun invoke(schoolID: String): Flow<UIState> {
        return flow {
            emit(UIState.Loading)
            repository.getSchoolByDBN(schoolID).also { emit(UIState.Success(it)) }
        }.catch {
            // Having exceptions passed from Model
            assert(it is SchoolExceptions)
            emit(UIState.Failure(it.message ?: "Uknwon"))
        }
    }
}