package com.example.deliveryservice

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun DeliverySuc(navController: NavController) {
    val feedback = remember { mutableStateOf("") }
    var selectedRating by remember { mutableStateOf(0) }
    var progress by remember { mutableStateOf(0.0f) }
    var isTimerRunning by remember { mutableStateOf(false) }
    val animatedDownloadProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    LaunchedEffect(isTimerRunning) {
        if (isTimerRunning) {
            while (progress < 1.2f) {
                delay(1000L)
                progress += 0.4f
            }
            isTimerRunning = false
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if(progress < 1f) {
            CircularProgressIndicator(
                progress = animatedDownloadProgress,
                color = Color.Blue,
                strokeWidth = 8.dp,
                modifier = Modifier.size(100.dp)
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.good_tick),
                contentDescription = "complete",
                modifier = Modifier.size(100.dp)
            )
        }

        Spacer(modifier = Modifier.height(60.dp))

        if (progress < 1.2f) {
        } else {
            Text(
                text = "Delivery Successful",
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Your Item has been delivered successfully",
                color = Color.DarkGray,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(45.dp))

        Text(
            text = "Rate Rider",
            color = Color.Blue,
            textAlign = TextAlign.Center
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(5) { index ->
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Star",
                    tint = if (index < selectedRating) Color.Yellow else Color.Gray,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(4.dp)
                        .clickable {
                            selectedRating = index + 1
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Card(
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Send,
                    contentDescription = "Feedback Icon",
                    tint = Color.Blue,
                    modifier = Modifier.size(24.dp)
                        .clickable {
                            isTimerRunning = true
                            progress = 0.0f
                        }
                )

                Spacer(modifier = Modifier.width(8.dp))

                TextField(
                    value = feedback.value,
                    onValueChange = {feedback.value = it},
                    placeholder = {Text("Add feedback")},
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(55.dp))

        Button(
            onClick = {
                isTimerRunning = true
                progress = 0.0f
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,

                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth().height(50.dp).padding(horizontal = 16.dp)
        ) {
            Text(text = "Done")
        }
    }
}