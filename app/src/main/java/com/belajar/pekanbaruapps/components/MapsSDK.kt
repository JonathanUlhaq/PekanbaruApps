package com.belajar.pekanbaruapps.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


@Composable
fun MapsSDK(
    lat:Double,
    long:Double,
    hotelName: String
) {

    if (lat != 0.0) {

        val positions = LatLng(lat, long)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(positions, 30f)
        }

        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = positions),
                title = hotelName
            )
        }
    }

}