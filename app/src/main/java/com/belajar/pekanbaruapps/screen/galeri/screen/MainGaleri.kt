package com.belajar.pekanbaruapps.screen.galeri.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.components.TopBar
import com.belajar.pekanbaruapps.screen.galeri.viewmodel.GaleriViewModel
import com.belajar.pekanbaruapps.screen.pendidikan.sd.screen.SDScreen
import com.belajar.pekanbaruapps.screen.pendidikan.sd.viewmodel.SDViewModel
import com.belajar.pekanbaruapps.screen.pendidikan.smp.screen.SMPScreen
import com.belajar.pekanbaruapps.screen.pendidikan.smp.viewmodel.SMPViewModel
import com.belajar.pekanbaruapps.screen.pendidikandetail.sd.viewmodel.SDDetailViewModel
import com.belajar.pekanbaruapps.screen.pendidikandetail.smp.viewmodel.SMPDetailViewModel
import com.belajar.pekanbaruapps.widgets.BottomBar
import com.belajar.pekanbaruapps.widgets.hotelscreen.SearchFilterBar
import com.belajar.pekanbaruapps.widgets.pendidikan.PendidikanBottomSheetContent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun MainGaleri(
    navController: NavController,
    vm: GaleriViewModel,
) {
    val search = remember {
        mutableStateOf("")
    }

    vm.getGaleri(search.value)
    val uiState = vm.uiState.collectAsState().value
    val pagerState = rememberPagerState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )

    val coroutineScope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            PendidikanBottomSheetContent(coroutineScope, bottomSheetState, search)
        }) {
        Scaffold(
            topBar = {
                TopBar(
                    isHome = false,
                    navController = navController,
                    title = "Info Pendidikan"
                ) {

                }
            },
            bottomBar = {
                BottomBar(currentIndex = 4, navController = navController)
            }
        ) {
            Column(Modifier.padding(it)) {
                SearchFilterBar(
                    search = search,
                    keyboardController = keyboardController,
                    placeHolder = "Cari foto dan video",
                    filterItem = false,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                TapRow(pagerState = pagerState)
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalPager(count = 2, state = pagerState) { page ->
                    when(page) {
                        0 -> {
                            if (pagerState.currentPage != 0) {
                                search.value = ""
                            }

                            GaleriScreen(uiState = uiState , navController = navController )
                        }
                        1 -> {
                            if (pagerState.currentPage != 1) {
                                search.value = ""
                            }
                            GaleriScreen(uiState = uiState , navController = navController )
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
        "Gambar",
        "Video"
    )
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colors.onSurface,
        contentColor = MaterialTheme.colors.primary) {
        listTitle.forEachIndexed { index, item ->
            Tab(selected = pagerState.currentPage == index,
                onClick = { coroutine.launch {
                    pagerState.scrollToPage(index)
                } },
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