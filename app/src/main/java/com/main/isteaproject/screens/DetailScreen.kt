package com.main.isteaproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.main.isteaproject.navigation.AppScreens

@Composable
fun DetailScreen(navController: NavController, text: String?, title: String?, img: String?){
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
        DetailBodyContent(navController, text, title, img)
    }
}

@Composable
fun DetailBodyContent(navController: NavController, texto: String?, title: String?, img: String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Detalle")
        Image(
            painter = rememberAsyncImagePainter("$img"),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(150.dp)
                .border(2.dp, Color.Black)
        )
        texto?.let {
            Text(it)
        }
        title?.let {
            Text(it)
        }
        Button(onClick = {
            navController.navigate(route = AppScreens.MainScreen.route)
        }) {
            Text(text = "Agregar al carrito")
        }
    }
}
