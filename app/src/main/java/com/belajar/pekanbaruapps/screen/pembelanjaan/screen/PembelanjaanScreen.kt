package com.belajar.pekanbaruapps.screen.pembelanjaan.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.components.TopBar
import com.belajar.pekanbaruapps.screen.detailperbelanjaan.viewmodel.DetailPerbelanjaanViewModel
import com.belajar.pekanbaruapps.screen.pembelanjaan.viewmodel.PembelanjaanViewModel
import com.belajar.pekanbaruapps.widgets.hotelscreen.SearchFilterBar
import com.belajar.pekanbaruapps.widgets.pembelanjaanscreen.ListBelanja
import com.belajar.pekanbaruapps.widgets.restaurantscreen.RestaurantBottomSheetContent
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun PembelanjanScreen(
    navController: NavController,
    vm: PembelanjaanViewModel,
    detailVm:DetailPerbelanjaanViewModel
) {
    val search = remember {
        mutableStateOf("")
    }

    detailVm.deleteLatLong()

    vm.getAllBelanja(search.value)
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
                    title = "Pusat Perbelanjaan"
                ) {

                }
            }
        ) {
            Column(Modifier.padding(it)) {
                SearchFilterBar(
                    search = search,
                    keyboardController = keyboardController,
                    placeHolder = "Pusat Perbelanjaan",
                    filterItem = false,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                ListBelanja(uiState, navController)
            }
        }
    }
}
