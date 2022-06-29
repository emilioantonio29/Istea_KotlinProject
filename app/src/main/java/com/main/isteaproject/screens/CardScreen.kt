package com.main.isteaproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.main.isteaproject.R
import com.main.isteaproject.navigation.AppScreens

@Composable
fun CardScreen(navController: NavController){
    Scaffold(
        topBar = {
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
        CardBodyContent(
            navController = navController,
            title = stringResource(R.string.first_title),
            description = stringResource(R.string.first_description),
            backgroundColor = Color(0xFF001e26),
            modifier = Modifier.padding(bottom = 0.dp)
        )
    }
}

@Composable
fun CardBodyContent(
    navController: NavController,
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .background(backgroundColor)
            .padding(0.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row() {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val imagePainter = painterResource(R.drawable.android_logo)
                Box(
                    modifier = Modifier.size(150.dp),
                    Alignment.Center
                ){
                    Image(
                        painter = imagePainter,
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        alignment = Alignment.Center
                    )
                }
                Text(
                    text = "Emilio Martinez",
                    color = Color.White,
                    fontSize = 30.sp
                    //modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Android Developer Extraordinaire",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF3ddc84)
                )
            }

        }
    }
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .padding(bottom = 40.dp, start = 60.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ){
        Row(
            Modifier.padding(top = 10.dp),
            Arrangement.Center
        ) {
            Icon(
                Icons.Outlined.Call,
                contentDescription = "phoneIcon",
                tint = Color(0xFF3ddc84)
            )
            Text(
                modifier = Modifier.padding(start = 30.dp),
                text = "+541199995555",
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Row(
            Modifier.padding(top = 10.dp)
        ) {
            Icon(
                Icons.Outlined.Share,
                contentDescription = "shareSocialMediaIcon",
                tint = Color(0xFF3ddc84)
            )
            Text(
                modifier = Modifier.padding(start = 30.dp),
                text = "@EmiDeveloper29",
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Row(
            Modifier.padding(top = 10.dp)
        ) {
            Icon(
                Icons.Outlined.Email,
                contentDescription = "mailIcon",
                tint = Color(0xFF3ddc84)
            )
            Text(
                modifier = Modifier.padding(start = 30.dp),
                text = "EmilioTest@test.com",
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}