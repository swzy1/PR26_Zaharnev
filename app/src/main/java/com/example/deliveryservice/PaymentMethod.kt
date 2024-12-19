package com.example.deliveryservice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentMethod(navController: NavController) {
    var selectedOption by remember { mutableStateOf("wallet") }
    var selectedCard by remember { mutableStateOf("**** 3323") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Add Payment method",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate("Wallet")
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
                .background(color = MaterialTheme.colorScheme.background),

            ) {

            PaymentOptionCard(
                title = "Pay with wallet",
                description = "Complete the payment using your e wallet",
                isSelected = selectedOption == "wallet",
                onClick = { selectedOption = "wallet" }
            )

            PaymentOptionCard(
                title = "Credit / debit card",
                description = "Complete the payment using your debit card",
                isSelected = selectedOption == "card",
                onClick = { selectedOption = "card" }
            )

            if (selectedOption == "card") {
                SavedCard(
                    cardNumber = "**** 3323",
                    isSelected = selectedCard == "**** 3323",
                    onClick = { selectedCard = "**** 3323" },
                    onDeleteClick = {  }
                )
                SavedCard(
                    cardNumber = "**** 1547",
                    isSelected = selectedCard == "**** 1547",
                    onClick = { selectedCard = "**** 1547" },
                    onDeleteClick = {  }
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Proceed to pay", color = Color.White)
            }
        }
    }
}