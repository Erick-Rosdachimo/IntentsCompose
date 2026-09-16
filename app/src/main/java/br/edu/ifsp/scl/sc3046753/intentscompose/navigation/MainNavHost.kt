package br.edu.ifsp.scl.sc3046753.intentscompose.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.edu.ifsp.scl.sc3046753.intentscompose.ui.composable.AddWordScreen
import br.edu.ifsp.scl.sc3046753.intentscompose.ui.composable.HomeScreen

private const val WORD_ADDED = "word_added"
@Composable
fun MainNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route) { backStackEntry ->

            val wordAdded =
                backStackEntry.savedStateHandle.get<String>(WORD_ADDED) ?: ""

            HomeScreen(
                wordAdded = wordAdded
            ) { currentString ->
                navHostController.navigate(
                    "${Screen.AddWordScreen.route}/${Uri.encode(currentString)}"
                )
            }
        }

        composable(
            route = "${Screen.AddWordScreen.route}/{currentString}",
            arguments = listOf(
                navArgument("currentString") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            AddWordScreen(
                currentString = backStackEntry.arguments?.getString("currentString") ?: "",
                onConcatenateClick = { word ->
                    navHostController.previousBackStackEntry
                        ?.savedStateHandle?.set(WORD_ADDED, word)

                    navHostController.popBackStack()
                }
            )
        }
    }
}