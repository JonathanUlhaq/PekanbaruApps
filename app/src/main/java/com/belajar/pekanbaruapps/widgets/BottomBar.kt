package com.belajar.pekanbaruapps.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.navigation.AppRoute


@Composable
fun BottomBar(
    currentIndex: Int,
    navController: NavController
) {

    val navIcon = listOf(
        R.drawable.navbar_home,
        R.drawable.berita,
        R.drawable.pengumuman,
        R.drawable.magazine,
        R.drawable.galery
    )

    val navLabel = listOf(
        R.string.label,
        R.string.berita,
        R.string.pengumuman,
        R.string.magazine,
        R.string.galeri
    )
    LazyRow(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 12.dp, bottom = 12.dp),
        content = {
            itemsIndexed(navIcon) { index, item ->
                val itemColor by animateColorAsState(targetValue = if (index == currentIndex) MaterialTheme.colors.primary else MaterialTheme.colors.secondary)
                val surfaceColor by animateColorAsState(
                    targetValue = if (index == currentIndex) MaterialTheme.colors.primary.copy(
                        0.3F
                    ) else MaterialTheme.colors.onSurface
                )

               IconButton(onClick = {
                   when(index) {
                       0 -> navController.navigate(AppRoute.Home.route)
                       1 -> navController.navigate(AppRoute.Berita.route)
                       2 -> navController.navigate(AppRoute.Pengumuman.route)
                       3 -> navController.navigate(AppRoute.Magazine.route)
                       4 -> navController.navigate(AppRoute.Galeri.route)
                   }
               }) {
                   Column(
                       verticalArrangement = Arrangement.Center,
                       horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                       Surface(
                           shape = CircleShape,
                           color = surfaceColor,
                           modifier = Modifier
                               .width(64.dp)
                               .height(32.dp)
                       ) {
                           Icon(
                               painter = painterResource(id = item),
                               contentDescription = null,
                               tint = itemColor,
                               modifier = Modifier
                                   .padding(start = 22.5.dp, end = 22.5.dp, top = 6.dp, bottom = 6.dp)
                           )
                       }

                       Spacer(modifier = Modifier.height(4.dp))

                       Text(
                           text = stringResource(id = navLabel[index]),
                           style = MaterialTheme.typography.h3,
                           fontSize = 10.sp,
                           color = itemColor,
                           textAlign = TextAlign.Center
                       )
                   }
               }

            }
        })

}