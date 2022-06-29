package com.main.isteaproject.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.main.isteaproject.navigation.AppScreens

@Composable
fun DetailScreen(navController: NavController, text: String?, title: String?){
    Scaffold(topBar = {
        TopAppBar() {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow Back",
                modifier = Modifier.clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Detail")
        }
    }) {
        DetailBodyContent(navController, text, title)
    }
}

@Composable
fun DetailBodyContent(navController: NavController, texto: String?, title: String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "I'm Detail")
        texto?.let {
            Text(it)
        }
        title?.let {
            Text(it)
        }
        Button(onClick = {
            navController.navigate(route = AppScreens.MainScreen.route)
        }) {
            Text(text = "Go Back")
        }
    }
}
