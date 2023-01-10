package com.belajar.pekanbaruapps.widgets.berita

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.belajar.pekanbaruapps.widgets.restaurantscreen.FilterItemRestaurant

@Composable
fun BeritaFilter(
    selected: MutableState<String>,
    search: MutableState<String>,
    searchList: MutableList<String>,
    onClick: () -> Unit
) {


    Column {
        //                    First Row
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            FilterItemRestaurant(
                name = "Semua",
                onClick = {
                    selected.value = "Semua"
                    onClick.invoke()
                    searchList.add("Semua")
                },
                color =
                if (searchList.contains("Semua")) {
                    MaterialTheme.colors.onSurface
                } else {
                    MaterialTheme.colors.secondary
                },
                colorSurface = if (searchList.contains("Semua")) {
                    MaterialTheme.colors.primaryVariant
                } else {
                    MaterialTheme.colors.onSecondary
                }

            )
            Spacer(modifier = Modifier.width(6.dp))

            FilterItemRestaurant(
                name = "Covid",
                onClick = {
                    selected.value = "Covid"
                    onClick.invoke()
                    searchList.add("Covid")
                },
                color =
                if (searchList.contains("Covid")) {
                    MaterialTheme.colors.onSurface
                } else {
                    MaterialTheme.colors.secondary
                },
                colorSurface = if (searchList.contains("Covid")) {
                    MaterialTheme.colors.primaryVariant
                } else {
                    MaterialTheme.colors.onSecondary
                }

            )
            Spacer(modifier = Modifier.width(6.dp))

            FilterItemRestaurant(
                name = "Informasi",
                onClick = {
                    selected.value = "Informasi"
                    onClick.invoke()
                    searchList.add("Informasi")
                },
                color =
                if (searchList.contains("Informasi")) {
                    MaterialTheme.colors.onSurface
                } else {
                    MaterialTheme.colors.secondary
                },
                colorSurface = if (searchList.contains("Informasi")) {
                    MaterialTheme.colors.primaryVariant
                } else {
                    MaterialTheme.colors.onSecondary
                }

            )

        }
    }

}