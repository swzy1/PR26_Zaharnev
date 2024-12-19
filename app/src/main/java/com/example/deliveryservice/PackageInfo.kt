package com.example.deliveryservice

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PackageInfo(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Send a package",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate("Track")
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            modifier = Modifier.shadow(4.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(color = MaterialTheme.colorScheme.background)
            ) {
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Package information",
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Origin details",
                color = Color.Black,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Mbaraugba, Ovom Amaa Asaa, Abia state",
                color = Color.LightGray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "+234 56543 96854",
                color = Color.LightGray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Destination details",
                color = Color.Black,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "19 Ademola Alabi close, lagos ",
                color = Color.LightGray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "+234 70644 80655",
                color = Color.LightGray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Other details",
                color = Color.Black,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth() .padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Package Items",
                        color = Color.LightGray,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "Books and stationary, Garri Ngwa",
                        color = Color(0xFFFF5722),
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Weight of Items",
                        color = Color.LightGray,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "1000kg",
                        color = Color(0xFFFF5722),
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Worth of Items",
                        color = Color.LightGray,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "N50,000",
                        color = Color(0xFFFF5722),
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Tracking Number",
                        color = Color.LightGray,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "R-7458-4567-4434-5854",
                        color = Color(0xFFFF5722),
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )

                }
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Charges",
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Delivery Charges",
                            color = Color.LightGray,
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Text(
                            text = "N2,500.00",
                            color = Color(0xFFFF5722),
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Instant delivery",
                            color = Color.LightGray,
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Text(
                            text = "N300.00",
                            color = Color(0xFFFF5722),
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Tax and Service Charges",
                            color = Color.LightGray,
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Text(
                            text = "N200.00",
                            color = Color(0xFFFF5722),
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Divider(
                        color = Color.Gray,
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Package total",
                            color = Color.LightGray,
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Text(
                            text = "N3000.00",
                            color = Color(0xFFFF5722),
                            fontSize = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Click on delivered for successful delivery and rate rider or report missing item",
                    color = Color.Blue,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        onClick = {  },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Blue
                        ),
                        border = BorderStroke(1.dp, Color.Blue),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Report")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(
                        onClick = {
                            navController.navigate("DeliverySuc")
                        },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Blue,
                            contentColor = Color.White
                        ),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Successful")
                    }
                }
            }
        }
    }
}