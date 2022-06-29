package com.main.isteaproject.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.main.isteaproject.navigation.AppScreens

@Composable
fun MainScreen(navController: NavController){
    Scaffold(
        topBar = {
        TopAppBar() {
            Text(text = "Istea Project")
        }
    },
        bottomBar = {
            BottomAppBar { 
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        Arrangement.SpaceEvenly,
                        Alignment.CenterVertically
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Icon(
                                Icons.Outlined.List,
                                contentDescription = "ProductList",
                                tint = Color(0xFF3ddc84)
                            )
                            Text(
                                text = "Products",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Icon(
                                Icons.Outlined.ShoppingCart,
                                contentDescription = "ShoppingCart",
                                tint = Color(0xFF3ddc84)
                            )
                            Text(
                                text = "Cart",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                        Column(
                            modifier = Modifier.clickable {
                                navController.navigate(AppScreens.CardScreen.route)
                            },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            Icon(
                                Icons.Outlined.Email,
                                contentDescription = "phoneIcon",
                                tint = Color(0xFF3ddc84)
                            )
                            Text(
                                text = "Card",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }

    ) {
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
