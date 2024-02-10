package com.example.a20240205_antoninoardines_nycschools.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a20240205_antoninoardines_nycschools.R
import com.example.a20240205_antoninoardines_nycschools.viewmodel.SchoolListViewModel
import com.example.domain.data.DomainSchoolSat
import com.example.domain.data.UIState

@Composable
fun SchoolListScreen(openDetails: (String) -> Unit) {
    val schoolListVM: SchoolListViewModel = viewModel()

    schoolListVM.schoolListState.observeAsState().value?.let {
        when (val state = it) {
            is UIState.Failure -> {
                SchoolFailureController(state.reason)
            }
            is UIState.Loading -> {
                SchoolLoadingController(state.loading)
            }
            is UIState.Success<List<DomainSchoolSat>> -> {
                SchoolList(state.data)
            }
        }
    }
}

@Composable
fun SchoolList(data: List<DomainSchoolSat>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(items = data) {
            SchoolItem(it)
        }
    }
}

@Composable
fun SchoolItem(domainSchoolSat: DomainSchoolSat) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Column {
            Text(
                modifier = Modifier.padding(vertical = 2.dp),
                text = stringResource(id = R.string.school_name, domainSchoolSat.schoolName),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.padding(vertical = 2.dp),
                text = stringResource(id = R.string.school_website, domainSchoolSat.website),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun PrevSchoolItem() {
    MainAppComposable {
        SchoolItem(domainSchoolSat = schoolSatGenerator().first())
    }
}

@Preview
@Composable
fun PrevSchoolList() {
    MainAppComposable {
        SchoolList(schoolSatGenerator())
    }
}