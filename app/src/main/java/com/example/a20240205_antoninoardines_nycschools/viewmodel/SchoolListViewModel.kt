package com.example.a20240205_antoninoardines_nycschools.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.FetchSchoolWithSatListUseCase
import com.example.domain.data.DomainSchoolSat
import com.example.domain.data.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolListViewModel @Inject constructor(private val fetchListUseCase: FetchSchoolWithSatListUseCase): ViewModel() {

    private val _schoolListState = MutableLiveData<UIState<List<DomainSchoolSat>>>()
    val schoolListState: LiveData<UIState<List<DomainSchoolSat>>>
        get() = _schoolListState

    init {
        viewModelScope.launch {
            fetchListUseCase()
                .catch {
                    // I keep this to track a so called
                    // DiagnosticCoroutineContextException...
                    it.printStackTrace()
                    _schoolListState.value = UIState.failure(it.message ?: "Unknown")
                }
                .collect {
                 _schoolListState.value = it
            }
        }
    }
}