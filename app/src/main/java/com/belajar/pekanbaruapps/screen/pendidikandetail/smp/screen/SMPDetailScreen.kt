package com.belajar.pekanbaruapps.screen.pendidikandetail.smp.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.components.ButtonTraveloka
import com.belajar.pekanbaruapps.components.MapsSDK
import com.belajar.pekanbaruapps.components.TopBar
import com.belajar.pekanbaruapps.components.ViewPager
import com.belajar.pekanbaruapps.screen.pendidikandetail.smp.viewmodel.SMPDetailViewModel
import com.belajar.pekanbaruapps.screen.wisatadetail.viewmodel.WisataDetailViewModel
import com.belajar.pekanbaruapps.widgets.ViewPagerItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SMPDetailScreen(
    navController: NavController,
    vm: SMPDetailViewModel,
    restaurantName: String
) {

    vm.getSMPByName(restaurantName)
    val uiState = vm.uiState.collectAsState().value
    val state = rememberPagerState()
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopBar(
                isHome = false,
                navController = navController,
                title = "Info Pendidikan"
            ) {

            }
        },
        floatingActionButton = {

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

                Spacer(modifier = Modifier.height(24.dp))
                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = MaterialTheme.colors.primaryVariant.copy(0.2F)
                ) {
                    Text(text = "${uiState.type}",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier
                            .padding(8.dp,4.dp,8.dp,4.dp),
                        fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                    Text(
                        text = uiState.name,
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.surface,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .width(260.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = MaterialTheme.colors.primaryVariant.copy(0.2F)
                    ) {
                        Text(text = "${uiState.akreditasi}",
                            style = MaterialTheme.typography.h1,
                            color = MaterialTheme.colors.primaryVariant,
                            modifier = Modifier
                                .padding(21.dp,12.dp,21.dp,12.dp),
                            fontSize = 24.sp)
                    }
                }
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
                        text = uiState.address!!,
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.secondary,
                        fontSize = 12.sp
                    )

                }

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.phone),
                        contentDescription = null,
                        tint = MaterialTheme.colors.primaryVariant
                    )
                    Spacer(modifier = Modifier.width(8.5.dp))
                    Text(
                        text = uiState.phone!!,
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.secondary,
                        fontSize = 12.sp
                    )

                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(

                ) {
                    MapsSDK(
                        lat = uiState.lat!!,
                        long = uiState.long!!,
                        hotelName = uiState.name
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Deskripsi",
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.surface,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    if (uiState.about!!.isNotEmpty()) {
                        Text(
                            text = uiState.about!!,
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