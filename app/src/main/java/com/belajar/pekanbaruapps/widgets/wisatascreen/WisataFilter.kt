package com.belajar.pekanbaruapps.widgets.wisatascreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.belajar.pekanbaruapps.widgets.restaurantscreen.FilterItemRestaurant


@Composable
fun WisataFilter(
    selected: MutableState<String>,
    search: MutableState<String>
) {
    //                    First Row
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        FilterItemRestaurant(
            name = "Semua",
            onClick = {
                selected.value = "Semua"
                search.value = ""
            },
            color = when (selected.value) {
                "Semua" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Semua" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
        Spacer(modifier = Modifier.width(6.dp))

        FilterItemRestaurant(
            name = "Pertanian",
            onClick = {
                selected.value = "Pertanian"
                search.value = "Pertanian"
            },
            color = when (selected.value) {
                "Pertanian" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Pertanian" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
        Spacer(modifier = Modifier.width(6.dp))

        FilterItemRestaurant(
            name = "Pendidikan",
            onClick = {
                selected.value = "Pendidikan"
                search.value = "Pendidikan"
            },
            color = when (selected.value) {
                "Pendidikan" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Pendidikan" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
        Spacer(modifier = Modifier.width(6.dp))

    }

//                    Second Row
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        FilterItemRestaurant(
            name = "Buatan",
            onClick = {
                selected.value = "Buatan"
                search.value = "Buatan"
            },
            color = when (selected.value) {
                "Buatan" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Buatan" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
        Spacer(modifier = Modifier.width(6.dp))

        FilterItemRestaurant(
            name = "Religi",
            onClick = {
                selected.value = "Religi"
                search.value = "Religi"
            },
            color = when (selected.value) {
                "Religi" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Religi" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
        Spacer(modifier = Modifier.width(6.dp))

        FilterItemRestaurant(
            name = "Budaya",
            onClick = {
                selected.value = "Budaya"
                search.value = "Budaya"
            },
            color = when (selected.value) {
                "Budaya" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Budaya" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
        Spacer(modifier = Modifier.width(6.dp))

    }

    //                    Last Row
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        FilterItemRestaurant(
            name = "Kuliner",
            onClick = {
                selected.value = "Kuliner"
                search.value = "Kuliner"
            },
            color = when (selected.value) {
                "Kuliner" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Kuliner" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
        Spacer(modifier = Modifier.width(6.dp))

        FilterItemRestaurant(
            name = "Sejarah",
            onClick = {
                selected.value = "Sejarah"
                search.value = "Sejarah"
            },
            color = when (selected.value) {
                "Sejarah" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Sejarah" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
    }



}