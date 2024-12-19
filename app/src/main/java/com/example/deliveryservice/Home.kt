package com.example.deliveryservice

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun Home(navController: NavController) {
    val showDialog = remember { mutableStateOf(false) }
    val searchQuery = remember { mutableStateOf("") }
    val avatarImageUri = remember { mutableStateOf<Uri?>(null) }
    var selectedButtonIndex by remember { mutableStateOf<Int?>(null) }
    val context = LocalContext.current
    val savedImageUri = getImageUri(context)
    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                avatarImageUri.value = it
                saveImageUri(context, uri)
            }
        }

    val cameraLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicturePreview()) { bitmap ->
        bitmap?.let {
            val uri = saveBitmapToCache(context, it)
            avatarImageUri.value = uri
            if (uri != null) {
                saveImageUri(context, uri)
            }
        }
    }
    val cardList = listOf(
        Card(R.drawable.frame_50),
        Card(R.drawable.frame_51),
        Card(R.drawable.frame_52),
        Card(R.drawable.frame_53)
    )
    val dashboardList = listOf(
        Card2(
            title = "Customer Care",
            description = "Our customer care service line is available from 8-9pm weekdays and 9-5 weekends - tap to call us today",
            image = R.drawable.group__1_
        ),
        Card2(
            title = "Send a package",
            description = "Request for a driver to pick up or deliver your package for you",
            image = R.drawable.vector
        ),
        Card2(
            title = "Fund your wallet",
            description = "To fund your wallet is as easy as ABC, make use of our fast technology and top-up your wallet today",
            image = R.drawable.vector__1_
        ),
        Card2(
            title = "Chats",
            description = "Search for available rider within your area",
            image = R.drawable.vector__2_
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        TextField(
            value = searchQuery.value,
            onValueChange = { searchQuery.value = it },
            placeholder = { Text("Search services", color = Color.White) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E88E5))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp, top = 15.dp, start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = avatarImageUri.value?.let { rememberAsyncImagePainter(it) }
                        ?: painterResource(R.drawable.clarity_avatar_solid),
                    contentDescription = "Avatar Image",
                    modifier = Modifier
                        .width(60.dp)
                        .height(80.dp)
                        .clip(CircleShape)
                        .clickable { showDialog.value = true },
                    contentScale = ContentScale.Crop
                )


                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = "Hello Ken!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Text(
                        text = "We trust you are having a great time",
                        color = Color.LightGray,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp
                    )
                }

                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "notifications",
                    tint = Color.White,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .padding(start = 10.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Special for you",
                color = Color(0xFFF36508),
                fontSize = 18.sp
            )


            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Arrow Icon",
                modifier = Modifier.size(24.dp),
                tint = Color(0xFFF36508),

                )
        }
        Spacer(modifier = Modifier.height(16.dp))


        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(cardList) { card ->
                Card(
                    modifier = Modifier
                        .width(160.dp)
                        .height(70.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFFF36508),
                            shape = MaterialTheme.shapes.medium
                        ),

                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(id = card.imageID),
                            contentDescription = "Card Image",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "What would you like to do",
            color = Color(0xFF1E88E5),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(dashboardList) { index, dashData ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = CardDefaults.cardColors(
                        containerColor = if (selectedButtonIndex == index) Color(0xFF1E88E5) else Color.White
                    ),
                    onClick = {
                        if (dashData.title == "Chats") {
                            navController.navigate("Chats")
                        }
                        selectedButtonIndex = if (selectedButtonIndex == index) null else index

                    },
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Image(
                            painter = painterResource(dashData.image),
                            contentDescription = dashData.title,
                            modifier = Modifier.size(40.dp),
                            colorFilter = if (selectedButtonIndex == index) ColorFilter.tint(Color.White) else null
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = dashData.title,
                            fontWeight = FontWeight.Bold,
                            color = if (selectedButtonIndex == index) Color.White else Color(
                                0xFF1E88E5
                            ),
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = dashData.description,
                            fontSize = 12.sp,
                            color = if (selectedButtonIndex == index) Color.White else Color.Gray
                        )
                    }
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "Выберите действие") },
            text = { Text(text = "Что вы хотите сделать с аватаркой?") },
            confirmButton = {
                Column {
                    TextButton(onClick = {
                        cameraLauncher.launch(null)

                        showDialog.value = false
                    }
                    ) {
                        Text(text = "Сделать фото")
                    }
                    TextButton(onClick = {
                        galleryLauncher.launch("image/*")
                        showDialog.value = false
                    }) {
                        Text(text = "Выбрать из галереи")
                    }


                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog.value = false }) {
                    Text(text = "Закрыть")
                }
            }
        )
    }
}
