package com.belajar.pekanbaruapps.screen.mainberita

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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.components.SecondarytopBar
import com.belajar.pekanbaruapps.components.TopBar
import com.belajar.pekanbaruapps.screen.berita.screen.BeritaScreen
import com.belajar.pekanbaruapps.screen.berita.viewmodel.BeritaViewModel
import com.belajar.pekanbaruapps.screen.hoaks.screen.HoakScreen
import com.belajar.pekanbaruapps.screen.hoaks.viewmodel.HoaksViewModel
import com.belajar.pekanbaruapps.screen.pendidikan.sd.screen.SDScreen
import com.belajar.pekanbaruapps.screen.pendidikan.sd.viewmodel.SDViewModel
import com.belajar.pekanbaruapps.screen.pendidikan.smp.screen.SMPScreen
import com.belajar.pekanbaruapps.screen.pendidikan.smp.viewmodel.SMPViewModel
import com.belajar.pekanbaruapps.screen.pendidikandetail.sd.viewmodel.SDDetailViewModel
import com.belajar.pekanbaruapps.screen.pendidikandetail.smp.viewmodel.SMPDetailViewModel
import com.belajar.pekanbaruapps.widgets.BottomBar
import com.belajar.pekanbaruapps.widgets.berita.BeritaBottomSheet
import com.belajar.pekanbaruapps.widgets.hotelscreen.SearchFilterBar
import com.belajar.pekanbaruapps.widgets.pendidikan.PendidikanBottomSheetContent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun MainBerita(
    navController: NavController,
    vm: BeritaViewModel,
    hoaksVm: HoaksViewModel
) {
    val search = remember {
        mutableStateOf("")
    }

    val pagerState = rememberPagerState()
    val searchList = mutableListOf<String>()

    val keyboardController = LocalSoftwareKeyboardController.current
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )

    val coroutineScope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            BeritaBottomSheet(coroutineScope, bottomSheetState, search, searchList) {

                searchList.forEach {
                    search.value = "${search.value} $it"

                }

            }
        }) {
        Scaffold(
            topBar = {
                SecondarytopBar(
                    title = "Berita"
                ) {

                }
            },
            bottomBar = {
                BottomBar(currentIndex = 1, navController = navController)
            }
        ) {
            Column(Modifier.padding(it)) {
                SearchFilterBar(
                    search = search,
                    keyboardController = keyboardController,
                    placeHolder = "Cari berita"
                ) {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                TapRow(pagerState = pagerState)
                HorizontalPager(count = 2, state = pagerState) { page ->
                    when (page) {
                        0 -> {
                            if (pagerState.currentPage != 0) {
                                search.value = ""
                            }
                            vm.getAllBerita(search.value)
                            val uiState = vm.uiState.collectAsState().value
                            BeritaScreen(uiState = uiState, navController = navController)
                        }
                        1 -> {
                            if (pagerState.currentPage != 1) {
                                search.value = ""
                            }
                            hoaksVm.getAllHoaks(search.value)
                            val uiState = hoaksVm.uiState.collectAsState().value
                            HoakScreen(uiState = uiState, navController = navController)
                        }
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TapRow(
    pagerState: PagerState
) {
    val coroutine = rememberCoroutineScope()
    val listTitle = listOf(
        "Pemko",
        "Hoaks"
    )
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colors.onSurface,
        contentColor = MaterialTheme.colors.primary
    ) {
        listTitle.forEachIndexed { index, item ->
            Tab(selected = pagerState.currentPage == index,
                onClick = {
                    coroutine.launch {
                        pagerState.scrollToPage(index)
                    }
                },
                text = {
                    Text(
                        text = item,
                        style = MaterialTheme.typography.body1,
                        fontSize = 16.sp,
                        color = MaterialTheme.colors.surface
                    )
                })
        }
    }
}