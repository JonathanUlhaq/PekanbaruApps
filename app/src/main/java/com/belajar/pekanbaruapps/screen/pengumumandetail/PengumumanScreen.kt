package com.belajar.pekanbaruapps.screen.pengumumandetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.components.ButtonTraveloka
import com.belajar.pekanbaruapps.screen.pengumuman.viewmodel.PengumumanViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PengumumanDetail(
    navController: NavController,
    vm: PengumumanViewModel,
    pengumuman: String
) {
    vm.getPengumuman(pengumuman)
    val uiState = vm.uiState.collectAsState().value.first()

    Scaffold(
        topBar = {
            SecondDetailTopBar(navController,"Detail Pengumuman")
        }
    ) {
        Column(
            Modifier
                .padding(it)
                .padding(start = 24.dp, end = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = uiState.name,
                style = MaterialTheme.typography.h3,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
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
                Spacer(modifier = Modifier.weight(1F))
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
            Surface(
                shape = RoundedCornerShape(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pengumuman_gambar),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            ButtonTraveloka("Button")
        }
    }
}

@Composable
fun SecondDetailTopBar(navController: NavController,title:String) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null,
                    tint = MaterialTheme.colors.surface
                )
            }
        },
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.surface
            )
        },
        actions = {
            IconButton(onClick = {

            }) {
                Icon(
                    painter = painterResource(id = R.drawable.draft_save),
                    contentDescription = null,
                    tint = MaterialTheme.colors.surface
                )
            }

            IconButton(onClick = {

            }) {
                Icon(
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = null,
                    tint = MaterialTheme.colors.surface
                )
            }
        },
        backgroundColor = MaterialTheme.colors.onSurface,
        elevation = 0.dp
    )
}