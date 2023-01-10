package com.belajar.pekanbaruapps.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.components.SearchField
import com.belajar.pekanbaruapps.components.TopBar
import com.belajar.pekanbaruapps.navigation.AppRoute
import com.belajar.pekanbaruapps.widgets.BottomBar
import com.belajar.pekanbaruapps.widgets.HeaderHome
import com.belajar.pekanbaruapps.widgets.ListMenu

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(
    navController: NavController
) {

    val search = remember {
        mutableStateOf("")
    }

    val state = rememberLazyGridState()
    val percent = (state.firstVisibleItemIndex / (15 - state.layoutInfo.visibleItemsInfo.size).toFloat()) * 100
    val keyboardController = LocalSoftwareKeyboardController.current

    val percentage = remember {
        mutableStateOf(0F)
    }

    percentage.value = percent

    Scaffold(
        topBar = {
            Surface(
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, top = 15.dp, bottom = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SearchField(
                        value = search.value,
                        placeholderText = stringResource(id = R.string.search_home),
                        onValueChange = { search.value = it },
                        modifier = Modifier.width(250.dp)
                    ) {
                        keyboardController?.hide()
                    }

                    IconButton(onClick = { navController.navigate(AppRoute.Profile.route) }) {
                        Surface(
                            shape = CircleShape,
                            color = Color.White,
                            modifier = Modifier
                                .size(40.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.photo),
                                contentDescription = "Account",
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
            }
        },
        bottomBar = {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.onSurface,
                elevation = 16.dp
            ) {
                BottomBar(currentIndex = 0,navController)
            }
        }
    ) {
        Column(
            Modifier
                .padding(it)
        ) {
            HeaderHome(search, keyboardController,percentage.value)
            Spacer(modifier = Modifier.height(24.dp))
            ListMenu(navController,state)
        }
    }
}








