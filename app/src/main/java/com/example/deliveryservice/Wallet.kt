package com.example.deliveryservice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Wallet(navController: NavController) {
    val cardList = listOf(
        Card3("-N3,000.000", "Delivery fee", "July 7, 2022", Color.Red),
        Card3("N2,000.00", "Lalalalala","July 4, 2022", Color.Green),
        Card3("-N3,000.00","Third Delivery","July 1, 2022", Color.Red),
        Card3("N1,000.00","Another One","June 27, 2022", Color.Green),
        Card3("N2,500.00","Experts Are The Best","June 23, 2022", Color.Green),
        Card3("-N3,000.00","Delivery fee","June 17, 2022", Color.Red),
        Card3("-N3,000.00","Delivery fee","July 7, 2022", Color.Red),
        Card3("-N3,000.00","Delivery fee","July 7, 2022", Color.Red),
        Card3("-N3,000.00","Delivery fee","July 7, 2022", Color.Red)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                TopAppBar(
                    title = {
                        Text(
                            text = "Wallet",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    modifier = Modifier.shadow(4.dp)
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp)
                        .background(color = MaterialTheme.colorScheme.background),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.p1),
                        contentDescription = "Card Image",
                        modifier = Modifier
                            .width(90.dp)
                            .height(80.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            text = "Hello Ken",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.DarkGray
                        )
                        Text(
                            text = buildAnnotatedString {


                                withStyle(style = SpanStyle(color = Color.Gray)) {
                                    append("Current balance: ")
                                }

                                withStyle(style = SpanStyle(color = Color(0xFF0279FC))) {
                                    append("N10,712:00")
                                }
                            },
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        )

                    }
                    Image(
                        painter = painterResource(R.drawable.eye_slash),
                        contentDescription = "Card Image",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .padding(start = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.padding(16.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(color = MaterialTheme.colorScheme.background)
                        .padding(start = 16.dp, end = 16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = MaterialTheme.shapes.medium
                    ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Top Up",
                            color = Color.DarkGray,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.padding(10.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, end = 10.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .background(Color.Blue, shape = CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.vector__3_),
                                        contentDescription = "Image 1",
                                        modifier = Modifier.size(30.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Bank",
                                    fontSize = 14.sp,
                                    color = Color.DarkGray
                                    )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .background(Color.Blue, shape = CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.vector__4_),
                                        contentDescription = "Image 2",
                                        modifier = Modifier.size(30.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Transfer",
                                    fontSize = 14.sp,
                                    color = Color.DarkGray
                                    )
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .background(Color.Blue, shape = CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(

                                        painter = painterResource(R.drawable.vector__5_),
                                        contentDescription = "Image 3",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .clickable {
                                                navController.navigate("PaymentMethod")

                                            }
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Card",
                                    fontSize = 14.sp,
                                    color = Color.DarkGray
                                    )
                            }
                        }
                    }

                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Transaction History",
                    color = Color.DarkGray,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

            }
            items(cardList) { cardData ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .background(color = MaterialTheme.colorScheme.background)
                        .padding(start = 16.dp, end = 16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = MaterialTheme.shapes.medium
                    ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp, start = 15.dp, end = 15.dp)
                            .background(color = MaterialTheme.colorScheme.background),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 16.dp)
                                .background(color = MaterialTheme.colorScheme.background)
                        ) {
                            Text(
                                text = cardData.trans,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = cardData.backgroundColor
                            )
                            Text(
                                text = cardData.description,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Color.DarkGray
                            )
                        }
                        Text(
                            text = cardData.time,
                            fontSize =   16.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}