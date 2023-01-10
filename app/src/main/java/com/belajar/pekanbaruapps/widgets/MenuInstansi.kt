package com.belajar.pekanbaruapps.widgets

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.navigation.AppRoute

@Composable
fun ListMenu(
    navController: NavController,
    state:LazyGridState
) {

    val context = LocalContext.current

    val instansiName = listOf(
        R.string.profil_kota,
        R.string.layanan_publik,
        R.string.perizinan,
        R.string.layanan,
        R.string.hukum,
        R.string.data,
        R.string.statistik,
        R.string.pekanbaru,
        R.string.restoran,
        R.string.pariwisata,
        R.string.belanja,
        R.string.info_pasar,
        R.string.info_pendidikan,
        R.string.kerja_pelatihan,
        R.string.kesehatan
    )

    val instansiImage = listOf(
        R.drawable.home,
        R.drawable.costumer_consultant,
        R.drawable.credit_card,
        R.drawable.employee,
        R.drawable.law,
        R.drawable.server_data_repository,
        R.drawable.analytics,
        R.drawable.hotel,
        R.drawable.dish,
        R.drawable.park,
        R.drawable.store,
        R.drawable.mobile_analytcis,
        R.drawable.sekolah,
        R.drawable.kerja_pelatihan,
        R.drawable.fasilitas_kesehatan
    )

    LazyVerticalGrid(
        state = state,
        columns = GridCells.Fixed(4),
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp),
        content = {
            itemsIndexed(instansiName) { index, item ->
                ItemMenu(name = item, image = instansiImage[index]) {
                    when(index) {
                        7 -> navController.navigate(AppRoute.HotelPekanbaru.route)
                        8 -> navController.navigate(AppRoute.Restaurant.route)
                        9 -> navController.navigate(AppRoute.Wisata.route)
                        10 -> navController.navigate(AppRoute.Pembelanjaan.route)
                        12 -> navController.navigate(AppRoute.Pendidikan.route)
                        14 -> navController.navigate(AppRoute.Kesehatan.route)
                    }
                }
            }
        })
}

@Composable
fun ItemMenu(
    name: Int,
    image: Int,
    toMenu:() -> Unit
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(end = 8.dp, bottom = 20.dp, top = 20.dp)
            .clickable { toMenu.invoke() }
    ) {

        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colors.onSecondary,
            modifier = Modifier
                .size(80.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .padding(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(id = name),
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.surface,
            fontSize = 10.sp,
            textAlign = TextAlign.Center
        )
    }
}