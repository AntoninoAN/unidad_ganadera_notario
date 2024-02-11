package com.example.a20240205_antoninoardines_nycschools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.a20240205_antoninoardines_nycschools.common.Navigation
import com.example.a20240205_antoninoardines_nycschools.ui.screens.DetailSchoolScreen
import com.example.a20240205_antoninoardines_nycschools.ui.screens.MainAppComposable
import com.example.a20240205_antoninoardines_nycschools.ui.screens.SchoolListScreen
import com.example.a20240205_antoninoardines_nycschools.viewmodel.SchoolDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainAppComposable {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Navigation.SCHOOL_HOME_NAV
                ) {
                    composable(route = Navigation.SCHOOL_HOME_NAV) {
                        SchoolListScreen { schoolID ->
                            navController.navigate("${Navigation.SCHOOL_DETAIL_NAV}/$schoolID")
                        }
                    }
                    composable(route = Navigation.SCHOOL_DETAIL_PATH,
                        arguments = listOf(
                            navArgument(Navigation.SCHOOL_DETAIL_ARG) {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        DetailSchoolScreen(
                            schoolID = it.arguments?.getString(Navigation.SCHOOL_DETAIL_ARG) ?: throw Exception("Incorrect School ID"),
                            hiltViewModel<SchoolDetailsViewModel>()
                        )
                    }
                }
            }
        }
    }
}