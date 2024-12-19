package com.example.deliveryservice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun Profile() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            painter = painterResource(R.drawable.profile_circle),
            contentDescription = "profile",
            tint = Color(0xFF0279FC)
        )

        Text(text = "Profile", color = Color.Black)
    }
}