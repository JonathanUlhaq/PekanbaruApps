package com.belajar.pekanbaruapps.screen.restaurant.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.components.TopBar
import com.belajar.pekanbaruapps.screen.detailrestaurant.viewmodel.DetailRestaurantViewModel
import com.belajar.pekanbaruapps.screen.restaurant.viewmodel.RestaurantViewModel
import com.belajar.pekanbaruapps.widgets.hotelscreen.SearchFilterBar
import com.belajar.pekanbaruapps.widgets.restaurantscreen.ListRestaurant
import com.belajar.pekanbaruapps.widgets.restaurantscreen.RestaurantBottomSheetContent
import kotlinx.coroutines.launch


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun RestaurantScreen(
    navController: NavController,
    vm: RestaurantViewModel,
    detailVm: DetailRestaurantViewModel
) {
    val search = remember {
        mutableStateOf("")
    }



    vm.getAllRestaurant(search.value)
    val uiState = vm.uiState.collectAsState().value

    val keyboardController = LocalSoftwareKeyboardController.current
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )

    val coroutineScope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            RestaurantBottomSheetContent(coroutineScope, bottomSheetState, search)
        }) {
        Scaffold(
            topBar = {
                TopBar(
                    isHome = false,
                    navController = navController,
                    title = "Restoran Pekanbaru"
                ) {

                }
            }
        ) {
            Column(Modifier.padding(it)) {
                SearchFilterBar(
                    search = search,
                    keyboardController = keyboardController,
                    placeHolder = "Cari Restoram"
                ) {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                ListRestaurant(uiState, navController)
            }
        }
    }
}


