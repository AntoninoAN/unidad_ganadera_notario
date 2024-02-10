package com.example.a20240205_antoninoardines_nycschools

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a20240205_antoninoardines_nycschools.ui.screens.MainAppComposable
import com.example.a20240205_antoninoardines_nycschools.ui.screens.SchoolListScreen
import com.example.a20240205_antoninoardines_nycschools.ui.theme._20240205AntoninoArdinesNYCSchoolsTheme
import com.example.a20240205_antoninoardines_nycschools.viewmodel.SchoolListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainAppComposable {
                val context = LocalContext.current
                SchoolListScreen {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}