package com.main.isteaproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.main.isteaproject.screens.CardScreen
import com.main.isteaproject.screens.DetailScreen
import com.main.isteaproject.screens.MainScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MainScreen.route){
        composable(route = AppScreens.MainScreen.route){
            MainScreen(navController)
        }
        composable(route = AppScreens.DetailScreen.route + "?text={text}&title={title}&img={img}",
            arguments = listOf(
                navArgument("text"){ type = NavType.StringType },
                navArgument("title"){ type = NavType.StringType },
                navArgument("img"){ type = NavType.StringType }
            )
        )
        {
            DetailScreen(navController, it.arguments?.getString("text"), it.arguments?.getString("title"), it.arguments?.getString("img"))
        }
        composable(route = AppScreens.CardScreen.route){
            CardScreen(navController)
        }
    }
}