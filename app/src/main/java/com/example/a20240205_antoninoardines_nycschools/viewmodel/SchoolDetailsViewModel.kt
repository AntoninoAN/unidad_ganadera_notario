package com.example.a20240205_antoninoardines_nycschools.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.domain.DetailedSchoolWithSatUseCase
import com.example.domain.data.DomainSchoolSat
import com.example.domain.data.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SchoolDetailsViewModel @Inject constructor(private val detailedUseCase: DetailedSchoolWithSatUseCase): ViewModel() {

    val schoolIDState: MutableState<String> = mutableStateOf("")

    val detailSchoolState: LiveData<UIState<List<DomainSchoolSat>>>
        get() = detailedUseCase(schoolIDState.value).asLiveData()
}