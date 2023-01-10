package com.belajar.pekanbaruapps.screen.fasilitaskesehatan.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.components.TopBar
import com.belajar.pekanbaruapps.screen.detailkesehatan.viewmodel.DetailKesehatanViewModel
import com.belajar.pekanbaruapps.screen.detailrestaurant.viewmodel.DetailRestaurantViewModel
import com.belajar.pekanbaruapps.screen.fasilitaskesehatan.viewmodel.KesehatanViewModel
import com.belajar.pekanbaruapps.screen.restaurant.viewmodel.RestaurantViewModel
import com.belajar.pekanbaruapps.widgets.fasilitaskesehatan.KesehatanFilter
import com.belajar.pekanbaruapps.widgets.fasilitaskesehatan.ListRumahSakit
import com.belajar.pekanbaruapps.widgets.hotelscreen.SearchFilterBar
import com.belajar.pekanbaruapps.widgets.restaurantscreen.FilterItemRestaurant
import com.belajar.pekanbaruapps.widgets.restaurantscreen.ListRestaurant
import com.belajar.pekanbaruapps.widgets.restaurantscreen.RestaurantBottomSheetContent
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun KesehatanScreen(
    navController: NavController,
    vm: KesehatanViewModel,
    detail:DetailKesehatanViewModel
) {
    val search = remember {
        mutableStateOf("")
    }

    val selected = remember {
        mutableStateOf("")
    }


    detail.deleteLatLong()
    vm.getKesehatan(search.value)
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
                    title = "Fasilitas Kesehatan"
                ) {

                }
            }
        ) {
            Column(Modifier.padding(it)) {
                SearchFilterBar(
                    search = search,
                    keyboardController = keyboardController,
                    placeHolder = "Cari info faskes ...",
                    filterItem = false,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                KesehatanFilter(selected, search)
                Spacer(modifier = Modifier.height(16.dp))
                ListRumahSakit(uiState, navController)
            }
        }
    }
}


