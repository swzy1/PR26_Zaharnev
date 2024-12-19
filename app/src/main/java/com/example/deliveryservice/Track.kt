package com.example.deliveryservice

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

@Composable
fun Track(navController: NavController) {
    val mapView = rememberMapViewWithLifecycle()
    var googleMap by remember { mutableStateOf<GoogleMap?>(null) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Box(modifier = Modifier
            .weight(0.35f)
            .fillMaxSize()) {
            AndroidView(
                factory = { mapView },
                modifier = Modifier.fillMaxSize(),
                update = { mapView ->
                    mapView.getMapAsync(OnMapReadyCallback { map ->
                        googleMap = map
                        val startPoint = LatLng(55.0084, 82.9357)
                        val endPoint = LatLng(55.0284, 82.9457)

                        googleMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(startPoint, 12f))
                        googleMap?.addPolyline(
                            PolylineOptions()
                                .add(startPoint, endPoint)
                                .color(android.graphics.Color.BLUE)
                                .width(8f)
                        )
                        val startBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.pin)
                        val scaledStartBitmap = Bitmap.createScaledBitmap(startBitmap, 100, 100, false)
                        googleMap?.addMarker(
                            MarkerOptions().position(startPoint).icon(
                                BitmapDescriptorFactory.fromBitmap(scaledStartBitmap)))

                        val endBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.pin)
                        val scaledEndBitmap = Bitmap.createScaledBitmap(endBitmap, 100, 100, false)
                        googleMap?.addMarker(
                            MarkerOptions().position(endPoint).icon(
                                BitmapDescriptorFactory.fromBitmap(scaledEndBitmap)))
                    })
                }
            )
        }
        Column(
            modifier = Modifier
                .weight(0.65f)
                .fillMaxSize()
                .padding(10.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Tracking Number")

            Text(
                text = "R-7458-4567-4434-5854",
                color = Color.Blue
            )

            Text(text = "Package Status")

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                StatusItem("Courier requested", "July 7 2022 08:00am")
                StatusItem("Package ready for delivery", "July 7 2022 08:30am")
                StatusItem("Package in transit", "July 7 2022 10:30am")
                StatusItem("Package delivered", "July 7 2022 03:30am")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("PackageInfo")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text(text = "View Package Info", color = Color.White)
            }
        }
    }
}

@Composable
fun StatusItem(status: String, date: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = Color.Blue
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = status)
            Text(text = date,
                color = Color(0xFFE85021)
            )
        }
    }
}

@Composable
fun rememberMapViewWithLifecycle(): MapView {
    val context = LocalContext.current
    val mapView = remember { MapView(context) }
    DisposableEffect(mapView) {
        mapView.onCreate(Bundle())
        mapView.onResume()
        onDispose {
            mapView.onPause()
            mapView.onDestroy()
        }
    }
    return mapView
}