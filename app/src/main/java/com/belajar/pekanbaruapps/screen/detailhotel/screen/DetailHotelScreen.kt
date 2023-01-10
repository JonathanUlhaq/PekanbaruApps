package com.belajar.pekanbaruapps.screen.detailhotel

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.components.*
import com.belajar.pekanbaruapps.model.HotelModel
import com.belajar.pekanbaruapps.screen.detailhotel.viewmodel.DetailHotelViewModel
import com.belajar.pekanbaruapps.widgets.ViewPagerItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DetailHotelScreen(
    navController: NavController,
    vm: DetailHotelViewModel,
    hotelName: String
) {

    vm.getHotelbyName(hotelName)
    val uiState = vm.uiState.collectAsState().value
    val state = rememberPagerState()
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopBar(
                isHome = false,
                navController = navController,
                title = "Detail Hotel",
                back = {
                    vm.deleteList()
                }
            ) {

            }
        },
        bottomBar = {
            ButtonTraveloka()
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            ViewPager(state = state, count = 3, height = 220) {
                if (uiState.image != 0) {
                    ViewPagerItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(230.dp),
                        image = uiState.image
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp)
                    .verticalScroll(scrollState)
            ) {
                if (uiState.hotelRating != "") {
                    HotelRatting(rating = uiState.hotelRating!!)
                }
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = uiState.hotelName,
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.surface,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.gps),
                        contentDescription = null,
                        tint = MaterialTheme.colors.primaryVariant
                    )
                    Spacer(modifier = Modifier.width(8.5.dp))
                    Text(
                        text = uiState.hotelAddress!!,
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.secondary,
                        fontSize = 12.sp
                    )

                }

                Column(

                ) {
                    MapsSDK(
                        lat = uiState.lat!!,
                        long = uiState.long!!,
                        hotelName = uiState.hotelName
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Deskripsi",
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.surface,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    if (uiState.aboutHotel!!.isNotEmpty()) {
                        Text(
                            text = uiState.aboutHotel!!,
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.surface,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Justify
                        )
                    }
                }



            }
        }
    }
}


