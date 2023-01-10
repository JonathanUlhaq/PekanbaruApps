package com.belajar.pekanbaruapps.screen.hotel

import android.graphics.fonts.FontStyle
import android.util.Log
import android.widget.Space
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.components.SearchField
import com.belajar.pekanbaruapps.components.TopBar
import com.belajar.pekanbaruapps.model.HotelModel
import com.belajar.pekanbaruapps.navigation.AppRoute
import com.belajar.pekanbaruapps.screen.detailhotel.viewmodel.DetailHotelViewModel
import com.belajar.pekanbaruapps.screen.hotel.viewmodel.HotelViewModel
import com.belajar.pekanbaruapps.widgets.hotelscreen.BottomSheetContent
import com.belajar.pekanbaruapps.widgets.hotelscreen.ListHotel
import com.belajar.pekanbaruapps.widgets.hotelscreen.SearchFilterBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun HotelScreen(
    navController: NavController,
    vm: HotelViewModel,
    detailVm:DetailHotelViewModel
) {
    val search = remember {
        mutableStateOf("")
    }

    val index = remember {
        mutableStateOf(0)
    }

    detailVm.deleteList()

    vm.getHotel(search.value)
    val uiState = vm.uiState.collectAsState().value

    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )

    val coroutineScope = rememberCoroutineScope()


    val keyboardController = LocalSoftwareKeyboardController.current

    ModalBottomSheetLayout(
        sheetContent = {
            BottomSheetContent(
                selected = {
                    index.value = it
                    search.value = it.toString()
                    if (it == 0) {
                        search.value = ""
                    }
                    coroutineScope.launch {
                        bottomSheetState.hide()
                    }
                },
                index = index.value
            ) {
                coroutineScope.launch {
                    bottomSheetState.hide()
                }
            }
        },
        sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    isHome = false,
                    navController = navController,
                    title = "Hotel Pekanbaru"
                ) {

                }
            }
        ) { space ->
            Column(Modifier.padding(space)) {
                SearchFilterBar(search, keyboardController) {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                ListHotel(uiState) {
                    navController.navigate(AppRoute.DetailHotel.route + "/${it}")
                }
            }
        }
    }
}


