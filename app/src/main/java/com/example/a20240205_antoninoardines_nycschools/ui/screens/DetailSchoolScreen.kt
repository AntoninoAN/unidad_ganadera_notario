package com.example.a20240205_antoninoardines_nycschools.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a20240205_antoninoardines_nycschools.viewmodel.SchoolDetailsViewModel
import com.example.domain.data.DomainSchoolSat
import com.example.domain.data.UIState

@Composable
fun DetailSchoolScreen(schoolID: String) {
    val detailedSchoolVM: SchoolDetailsViewModel = viewModel()
    detailedSchoolVM.schoolIDState.value = schoolID
    detailedSchoolVM.detailSchoolState.observeAsState().value?.let {
        when (val state = it) {
            is UIState.Success<List<DomainSchoolSat>> -> { DetailSchool(state.data.first())}
            is UIState.Failure -> { SchoolFailureController(state.reason)}
            is UIState.Loading -> { SchoolLoadingController(state.loading)}
        }
    }
}

@Composable
fun DetailSchool(data: DomainSchoolSat) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(modifier = Modifier.padding(8.dp)) {
            Column {
                Row {
                    Text(text = data.schoolID)
                    Text(text = data.schoolName)
                }
                Row {
                    Text(text = data.phoneNumber)
                    Text(text = data.schoolEmail)
                }
                Row {
                    Column {
                        Text(text = data.satTestTakers)
                        Text(text = data.satMath)
                    }
                    Column {
                        Text(text = data.satCriticalReading)
                        Text(text = data.satWriting)
                    }
                }
                Text(text = data.overview)
            }
        }
    }
}

@Preview
@Composable
fun PrevDetailSchool() {
    MainAppComposable {
        DetailSchool(data = schoolSatGenerator().first())
    }
}