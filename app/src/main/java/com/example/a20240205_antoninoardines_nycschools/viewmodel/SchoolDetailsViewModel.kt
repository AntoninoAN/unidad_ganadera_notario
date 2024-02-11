package com.example.a20240205_antoninoardines_nycschools.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.DetailedSchoolWithSatUseCase
import com.example.domain.data.DomainSchoolSat
import com.example.domain.data.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class SchoolDetailsViewModel @Inject constructor(private val detailedUseCase: DetailedSchoolWithSatUseCase): ViewModel() {

    val detailSchoolSelection = mutableStateOf("")
    val detailSchoolState: LiveData<UIState<List<DomainSchoolSat>>>
        get() = detailedUseCase(detailSchoolSelection.value).catch {  }.asLiveData()
}