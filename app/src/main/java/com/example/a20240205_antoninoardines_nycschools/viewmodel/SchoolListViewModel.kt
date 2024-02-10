package com.example.a20240205_antoninoardines_nycschools.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.FetchSchoolWithSatListUseCase
import com.example.domain.data.DomainSchoolSat
import com.example.domain.data.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SchoolListViewModel @Inject constructor(private val fetchListUseCase: FetchSchoolWithSatListUseCase): ViewModel() {

    private val _schoolListState = MutableLiveData<UIState<List<DomainSchoolSat>>>()
    val schoolListState: LiveData<UIState<List<DomainSchoolSat>>>
        get() = _schoolListState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            fetchListUseCase().collect {
                withContext(Dispatchers.Main) { _schoolListState.value = it }
            }
        }
    }
}