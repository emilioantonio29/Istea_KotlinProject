package com.main.isteaproject.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.main.isteaproject.navigation.AppScreens

@Composable
fun MainScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar() {
            Text(text = "Istea Project")
        }
    }) {
        MainBodyContent(navController)
    }
}

@Composable
fun MainBodyContent(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Soy MAIN")
        Button(onClick = {
            //navController.navigate(route = AppScreens.DetailScreen.route + "/Hola Soy el Main" + "/title")
            navController.navigate(AppScreens.DetailScreen.route+"?text=imMAIN&title=title")
        }) {
            Text(text = "Detail")
        }
    }
}
