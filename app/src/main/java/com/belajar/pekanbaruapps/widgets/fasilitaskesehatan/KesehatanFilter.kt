package com.belajar.pekanbaruapps.widgets.fasilitaskesehatan

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.belajar.pekanbaruapps.widgets.restaurantscreen.FilterItemRestaurant

@Composable
fun KesehatanFilter(
    selected: MutableState<String>,
    search: MutableState<String>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, bottom = 12.dp, top = 12.dp),
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
            name = "A",
            onClick = {
                selected.value = "A"
                search.value = "A"
            },
            color = when (selected.value) {
                "A" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "A" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )

        Spacer(modifier = Modifier.width(6.dp))

        FilterItemRestaurant(
            name = "B",
            onClick = {
                selected.value = "B"
                search.value = "B"
            },
            color = when (selected.value) {
                "B" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "B" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )

        Spacer(modifier = Modifier.width(6.dp))

        FilterItemRestaurant(
            name = "C",
            onClick = {
                selected.value = "C"
                search.value = "C"
            },
            color = when (selected.value) {
                "C" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "C" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )

        Spacer(modifier = Modifier.width(6.dp))

        FilterItemRestaurant(
            name = "D",
            onClick = {
                selected.value = "D"
                search.value = "D"
            },
            color = when (selected.value) {
                "D" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "D" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )

        Spacer(modifier = Modifier.width(6.dp))
    }
}