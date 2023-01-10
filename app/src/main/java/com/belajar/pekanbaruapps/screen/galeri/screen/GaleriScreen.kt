package com.belajar.pekanbaruapps.screen.galeri.screen

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
import com.belajar.pekanbaruapps.model.GaleriModel
import com.belajar.pekanbaruapps.model.SDModel
import com.belajar.pekanbaruapps.navigation.AppRoute
import com.belajar.pekanbaruapps.screen.galeri.viewmodel.GaleriViewModel
import com.belajar.pekanbaruapps.screen.pengumuman.screen.ItemListPengumuman
import com.belajar.pekanbaruapps.screen.pengumuman.viewmodel.PengumumanViewModel
import com.belajar.pekanbaruapps.widgets.BottomBar
import com.belajar.pekanbaruapps.widgets.hotelscreen.SearchFilterBar

@Composable
fun GaleriScreen(uiState: List<GaleriModel>, navController: NavController) {
    LazyColumn(content = {
        items(uiState) {
            ItemListPengumuman(image = it.image!!,
                judul = it.name ,
                date = it.date!! ,
                view = it.view!! ) {
    navController.navigate(AppRoute.DetailGaleri.route + "/${it.name}")
            }

        }
    })
}