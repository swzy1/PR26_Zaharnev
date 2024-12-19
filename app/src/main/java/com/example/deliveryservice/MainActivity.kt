package com.example.deliveryservice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.deliveryservice.ui.theme.DeliveryServiceTheme
import androidx.navigation.compose.*
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            Scaffold(
                bottomBar = {
                    val currentRoute = currentRoute(navController)
                    if (currentRoute != "screen_1") {
                        BottomNavigationBar(navController = navController)
                    }
                }
            ) { innerPadding ->
                NavHost(navController = navController, startDestination = "screen_1", modifier = Modifier.padding(innerPadding)) {
                    composable("screen_1") {
                        LaunchScreen {
                            navController.navigate("Home") {
                                popUpTo("screen_1") { inclusive = true }
                            }
                        }
                    }
                    composable("Home") { Home(navController) }
                    composable("Wallet") { Wallet(navController) }
                    composable("Track") { Track(navController) }
                    composable("Profile") { Profile() }
                    composable("Chats") { Chats(navController) }
                    composable("PackageInfo") { PackageInfo(navController) }
                    composable("PaymentMethod") { PaymentMethod(navController) }
                    composable("DeliverySuc") { DeliverySuc(navController)}
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        NavRow.NavItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {

                    navController.navigate(navItem.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = navItem.iconResId),
                        contentDescription = navItem.label,
                        modifier = Modifier.size(30.dp),
                        tint = if (currentRoute == navItem.route) Color(0xFF0C81FC) else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = navItem.label,
                        color = if (currentRoute == navItem.route) Color(0xFF0C81FC) else Color.Gray
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}

@Composable
fun LaunchScreen(onTimeout: () -> Unit) {
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(3000)
        isLoading = false
        onTimeout()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.frame),
            contentDescription = "logo",
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val currentBackStackEntry = navController.currentBackStackEntryAsState().value
    return currentBackStackEntry?.destination?.route
}