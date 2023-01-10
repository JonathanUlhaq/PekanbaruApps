package com.belajar.pekanbaruapps.screen.magazine.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.components.SecondarytopBar
import com.belajar.pekanbaruapps.model.MagazineModel
import com.belajar.pekanbaruapps.screen.berita.screen.BeritaScreen
import com.belajar.pekanbaruapps.screen.berita.viewmodel.BeritaViewModel
import com.belajar.pekanbaruapps.screen.hoaks.screen.HoakScreen
import com.belajar.pekanbaruapps.screen.hoaks.viewmodel.HoaksViewModel
import com.belajar.pekanbaruapps.screen.magazine.viewmodel.MagazineViewModel
import com.belajar.pekanbaruapps.screen.mainberita.TapRow
import com.belajar.pekanbaruapps.widgets.BottomBar
import com.belajar.pekanbaruapps.widgets.berita.BeritaBottomSheet
import com.belajar.pekanbaruapps.widgets.hotelscreen.SearchFilterBar
import com.belajar.pekanbaruapps.widgets.restaurantscreen.FilterItemRestaurant
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun MagazineScreen(
    navController: NavController,
    vm: MagazineViewModel
) {
    val search = remember {
        mutableStateOf("")
    }

    vm.getMagazine(search.value)
    val uiState = vm.uiState.collectAsState().value



    val keyboardController = LocalSoftwareKeyboardController.current


    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            SecondarytopBar(
                title = "E-Magazine"
            ) {

            }
        },
        bottomBar = {
            BottomBar(currentIndex = 3, navController = navController)
        }
    ) {
        Column(Modifier.padding(it)) {
            SearchFilterBar(
                search = search,
                keyboardController = keyboardController,
                placeHolder = "Cari e-magazine ...",
                filterItem = false,
                modifier = Modifier
                    .fillMaxWidth()
            ) {

            }

            val listYear = listOf(
                "Semua",
                "2022",
                "2021",
                "2020",
                "2019"
            )
            Spacer(modifier = Modifier.height(8.dp))
            ItemRow(list = listYear, onClick = {
                when(it) {
                    "Semua" -> search.value = ""
                    else -> search.value = it
                }

            } )
            Spacer(modifier = Modifier.height(16.dp))
            LazyVerticalGrid(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp),
                columns = GridCells.Fixed(3),
                content = {
                    items(uiState) {
                        ItemList(model = it)
                    }
                })


        }
    }
}

@Composable
fun ItemRow(list:List<String>,onClick:(String) -> Unit) {
    val selected = remember {
        mutableStateOf(0)
    }

    LazyRow(
        modifier = Modifier.padding(start = 24.dp),
        content = {
        itemsIndexed(list) { index, s ->
            val colorSurface by animateColorAsState(targetValue = if (index == selected.value) MaterialTheme.colors.onSurface else MaterialTheme.colors.secondary)
            val color by animateColorAsState(targetValue = if (index == selected.value) MaterialTheme.colors.primaryVariant else MaterialTheme.colors.onSecondary)
            Surface(
                shape = RoundedCornerShape(50.dp),
                color = color,
                modifier = Modifier
                    .clickable {
                        selected.value = index
                        onClick.invoke(s)
                    }
                    .padding(end = 16.dp)

            ) {
                Text(
                    text = s,
                    style = MaterialTheme.typography.body1,
                    color = colorSurface,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
                )
            }
        }
    })
}

@Composable
fun ItemList(model: MagazineModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(bottom = 12.dp, end = 16.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .height(100.dp)
                .width(104.dp)

        ) {
            Image(
                painter = painterResource(id = model.image!!),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = model.name,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.surface,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}