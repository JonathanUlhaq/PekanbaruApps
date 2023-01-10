package com.belajar.pekanbaruapps.screen.berita.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
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
import com.belajar.pekanbaruapps.screen.berita.viewmodel.BeritaViewModel
import com.belajar.pekanbaruapps.screen.pendidikandetail.smp.viewmodel.SMPDetailViewModel
import com.belajar.pekanbaruapps.widgets.ViewPagerItem
import com.belajar.pekanbaruapps.widgets.hotelscreen.SearchFilterBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class, ExperimentalComposeUiApi::class)
@Composable
fun DetailBerita(
    navController: NavController,
    vm: BeritaViewModel,
    berita: String
) {

    vm.getAllBerita(berita)
    val uiState = vm.uiState.collectAsState().value.first()
    val state = rememberPagerState()
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopBar(
                isHome = false,
                navController = navController,
                title = "Detail Berita"
            ) {

            }
        },
        bottomBar = {
            ButtonTraveloka(text = "Lihat semua komentar")
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
                Row {
                    uiState.type!!.forEach {
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = MaterialTheme.colors.primaryVariant.copy(0.2F)
                        ) {
                            Text(
                                text = "${it}",
                                style = MaterialTheme.typography.body1,
                                color = MaterialTheme.colors.primaryVariant,
                                modifier = Modifier
                                    .padding(8.dp, 4.dp, 8.dp, 4.dp),
                                fontSize = 12.sp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = uiState.name,
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.surface,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.date),
                            contentDescription = null,
                            tint = MaterialTheme.colors.primaryVariant
                        )
                        Spacer(modifier = Modifier.width(8.5.dp))
                        Text(
                            text = uiState.date!!,
                            style = MaterialTheme.typography.h3,
                            color = MaterialTheme.colors.secondary,
                            fontSize = 12.sp
                        )

                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.view),
                            contentDescription = null,
                            tint = MaterialTheme.colors.primaryVariant
                        )
                        Spacer(modifier = Modifier.width(8.5.dp))
                        Text(
                            text = uiState.view!!,
                            style = MaterialTheme.typography.h3,
                            color = MaterialTheme.colors.secondary,
                            fontSize = 12.sp
                        )

                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(

                ) {

                    if (uiState.desc!!.isNotEmpty()) {
                        Text(
                            text = uiState.desc!!,
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.surface,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Justify
                        )
                    }
                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Komentar",
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.surface
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "2 Komentar",
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.secondaryVariant,
                        fontSize = 12.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    val keyboard = LocalSoftwareKeyboardController.current
                    SearchFilterBar(
                        keyboardController = keyboard,
                        colors = MaterialTheme.colors.primaryVariant,
                        iconColor = MaterialTheme.colors.onSurface,
                        icon = R.drawable.send,
                        shape = CircleShape,
                        mudif = Modifier.padding(0.dp),
                        modifier = Modifier.width(250.dp)
                    ) {

                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.photo),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                                    Row {
                                        Text(text = "Tiara Lorenza",
                                            style = MaterialTheme.typography.h3,
                                            color = MaterialTheme.colors.surface,
                                            fontSize = 14.sp)
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Text(text = "Januari 2, 2023",
                                            style = MaterialTheme.typography.body1,
                                            color = MaterialTheme.colors.secondary,
                                            fontSize = 12.sp)
                                    }
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = "Informasi yang sangat berguna. Masyarakat kota pekanbaru harus tetap waspada menghadapi covid.",
                                style = MaterialTheme.typography.body1,
                                color = MaterialTheme.colors.surface,
                                fontSize = 12.sp)

                        }
                    }
                }


            }
        }
    }
}