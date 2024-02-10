package com.example.a20240205_antoninoardines_nycschools.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.example.a20240205_antoninoardines_nycschools.ui.theme._20240205AntoninoArdinesNYCSchoolsTheme
import com.example.domain.data.DomainSchoolSat

/**
 * MainApp to be reused in Previews and include Theme implementation
 */
@Composable
fun MainAppComposable(content: @Composable ()-> Unit) {
    _20240205AntoninoArdinesNYCSchoolsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun SchoolLoadingController(isLoading: Boolean) {
    AnimatedVisibility(visible = isLoading) {
        CircularProgressIndicator()
    }
}



@Composable
fun SchoolFailureController(reason: String) {
    Dialog(onDismissRequest = {  }) {
        Text(text = reason)
    }
}

internal fun schoolSatGenerator() = listOf(
    DomainSchoolSat(
        "02M260",
        "Clinton School Writers & Artists, M.S. 260",
        "4",
        "4",
        "4",
        "4",
        "Students who are prepared for college must have an education that encourages them to take risks as they produce and perform. Our college preparatory curriculum develops writers and has built a tight-knit community. Our school develops students who can think analyttically and write creatively. our arts programming builds on our 25 years of experience in visual, perfroming arts and music on a middle school level. We partner with New Audicence an the Whitney Musuem as cultural partners. We are a International Baccalaureate (IB) candidate school that offers opportunities to take college courses at neighboring universities.",
        "212-524-4360",
        "www.theclintonschool.net",
        "admission@theclintonschool.net"
    ),DomainSchoolSat(
        "02M260",
        "Clinton School Writers & Artists, M.S. 260",
        "4",
        "4",
        "4",
        "4",
        "Students who are prepared for college must have an education that encourages them to take risks as they produce and perform. Our college preparatory curriculum develops writers and has built a tight-knit community. Our school develops students who can think analyttically and write creatively. our arts programming builds on our 25 years of experience in visual, perfroming arts and music on a middle school level. We partner with New Audicence an the Whitney Musuem as cultural partners. We are a International Baccalaureate (IB) candidate school that offers opportunities to take college courses at neighboring universities.",
        "212-524-4360",
        "www.theclintonschool.net",
        "admission@theclintonschool.net"
    ),DomainSchoolSat(
        "02M260",
        "Clinton School Writers & Artists, M.S. 260",
        "4",
        "4",
        "4",
        "4",
        "Students who are prepared for college must have an education that encourages them to take risks as they produce and perform. Our college preparatory curriculum develops writers and has built a tight-knit community. Our school develops students who can think analyttically and write creatively. our arts programming builds on our 25 years of experience in visual, perfroming arts and music on a middle school level. We partner with New Audicence an the Whitney Musuem as cultural partners. We are a International Baccalaureate (IB) candidate school that offers opportunities to take college courses at neighboring universities.",
        "212-524-4360",
        "www.theclintonschool.net",
        "admission@theclintonschool.net"
    )
)