package com.belajar.pekanbaruapps.screen.pengumuman.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.components.SecondarytopBar
import com.belajar.pekanbaruapps.navigation.AppRoute
import com.belajar.pekanbaruapps.screen.pengumuman.viewmodel.PengumumanViewModel
import com.belajar.pekanbaruapps.widgets.BottomBar
import com.belajar.pekanbaruapps.widgets.hotelscreen.SearchFilterBar
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PengumumanScreen(
    navController: NavController,
    vm: PengumumanViewModel
) {
    val search = remember {
        mutableStateOf("")
    }

    vm.getPengumuman(search.value)
    val uiState = vm.uiState.collectAsState().value


    val keyboardController = LocalSoftwareKeyboardController.current


    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            SecondarytopBar(
                title = "Pengumuman"
            ) {

            }
        },
        bottomBar = {
            BottomBar(currentIndex = 2, navController = navController)
        }
    ) {
        Column(Modifier.padding(it)) {
            SearchFilterBar(
                search = search,
                keyboardController = keyboardController,
                placeHolder = "Cari pengumuman",
                filterItem = false,
                modifier = Modifier
                    .fillMaxWidth()
            ) {

            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(content = {
                items(uiState) { item ->
                    ItemListPengumuman(
                        image = item.image!!,
                        judul = item.name,
                        date = item.date!!,
                        view = item.view!!
                    ) {
                        navController.navigate(AppRoute.PengumumanDetail.route +"/${item.name}")
                    }
                }
            })
        }
    }
}

@Composable
fun ItemListPengumuman(
    image: Int,
    judul: String,
    date: String,
    view: String,
    onCLick:() -> Unit
) {
    Column(
        modifier = Modifier.padding(start = 24.dp, end = 24.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clickable {
                           onCLick.invoke()
                },
            shape = RoundedCornerShape(8.dp),
            elevation = 10.dp
        ) {

            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = judul,
            style = MaterialTheme.typography.body1,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(bottom = 12.dp)
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
                    text = date,
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
                    text = view,
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.secondary,
                    fontSize = 12.sp
                )
            }
        }
    }
}