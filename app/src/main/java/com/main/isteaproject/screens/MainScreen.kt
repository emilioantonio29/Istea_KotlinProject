package com.main.isteaproject.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.main.isteaproject.R
import com.main.isteaproject.navigation.AppScreens
import com.main.isteaproject.ui.theme.Purple500
import com.main.isteaproject.viewmodel.SampleViewModel

@Composable
fun MainScreen(navController: NavController){
    Scaffold(
        bottomBar = {
            BottomAppBar() {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
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
                                text = "",
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
                                text = "",
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
                                text = "",
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

/*@Composable
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
}*/

@Composable
fun MainBodyContent(navController: NavController){
    val viewModel: SampleViewModel = viewModel()
    val sampleData = viewModel.sampleDetailFlow.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Purple500)
                .padding(15.dp)
        ) {
            Text(
                text = "Products",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
        }
        /*Button(onClick = {
            //navController.navigate(route = AppScreens.DetailScreen.route + "/Hola Soy el Main" + "/title")
            navController.navigate(AppScreens.DetailScreen.route+"?text=imMAIN&title=title")
        }) {
            Text(text = "Detail")
        }*/

        Column {
            sampleData.value?.let {
                LazyColumn {

                    items(it.data.size) {index ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp, 5.dp, 10.dp, 5.dp),
                            elevation = 5.dp,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable {
                                        navController.navigate(AppScreens.DetailScreen.route+"?text=${it.data[index].descript}&title=${it.data[index].nombre}&img=${it.data[index].imagen}") },
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row() {
                                    MyImage("${it.data[index].imagen}")

                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "${it.data[index].nombre}",
                                            color = Color.Black,
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(20.dp),
                                            textAlign = TextAlign.Left
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MyImage(url: String){
    var test: String = "https://www.laylita.com/recetas/wp-content/uploads/2021/11/Receta-de-los-golfeados-venezolanos-1024x683.jpg"
    Image(
        painter = rememberAsyncImagePainter("$url"),
        contentDescription = null,
        modifier = Modifier
            .clip(CircleShape)
            .size(64.dp)
            .border(2.dp, Color.Black)
    )
}

