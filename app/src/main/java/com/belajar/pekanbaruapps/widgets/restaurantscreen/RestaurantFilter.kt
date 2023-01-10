package com.belajar.pekanbaruapps.widgets.restaurantscreen

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


@Composable
fun RestaurantFilter(
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
            name = "Senapelan",
            onClick = {
                selected.value = "Senapelan"
                search.value = "Senapelan"
            },
            color = when (selected.value) {
                "Senapelan" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Senapelan" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
        Spacer(modifier = Modifier.width(6.dp))

        FilterItemRestaurant(
            name = "Bukit Raya",
            onClick = {
                selected.value = "Bukit Raya"
                search.value = "Bukit Raya"
            },
            color = when (selected.value) {
                "Bukit Raya" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Bukit Raya" -> MaterialTheme.colors.primaryVariant
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
            name = "Marpoyan Damai",
            onClick = {
                selected.value = "Marpoyan Damai"
                search.value = "Marpoyan Damai"
            },
            color = when (selected.value) {
                "Marpoyan Damai" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Marpoyan Damai" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
        Spacer(modifier = Modifier.width(6.dp))

        FilterItemRestaurant(
            name = "Pekanbaru Kota",
            onClick = {
                selected.value = "Pekanbaru Kota"
                search.value = "Pekanbaru Kota"
            },
            color = when (selected.value) {
                "Pekanbaru Kota" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Pekanbaru Kota" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
        Spacer(modifier = Modifier.width(6.dp))

    }

//                    Third Row

    Spacer(modifier = Modifier.height(16.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        FilterItemRestaurant(
            name = "Payung Sekaki",
            onClick = {
                selected.value = "Payung Sekaki"
                search.value = "Payung Sekaki"
            },
            color = when (selected.value) {
                "Payung Sekaki" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Payung Sekaki" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
        Spacer(modifier = Modifier.width(6.dp))

        FilterItemRestaurant(
            name = "Lima Puluh",
            onClick = {
                selected.value = "Lima Puluh"
                search.value = "Lima Puluh"
            },
            color = when (selected.value) {
                "Lima Puluh" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Lima Puluh" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
        Spacer(modifier = Modifier.width(6.dp))

        FilterItemRestaurant(
            name = "Sail",
            onClick = {
                selected.value = "Sail"
                search.value = "Sail"
            },
            color = when (selected.value) {
                "Sail" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Sail" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )

    }

//                    Fourth Row

    Spacer(modifier = Modifier.height(16.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        FilterItemRestaurant(
            name = "Suka Jadi",
            onClick = {
                selected.value = "Suka Jadi"
                search.value = "Suka Jadi"
            },
            color = when (selected.value) {
                "Suka Jadi" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Suka Jadi" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
        Spacer(modifier = Modifier.width(6.dp))

        FilterItemRestaurant(
            name = "Tampan",
            onClick = {
                selected.value = "Tampan"
                search.value = "Tampan"
            },
            color = when (selected.value) {
                "Tampan" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Tampan" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )
        Spacer(modifier = Modifier.width(6.dp))

        FilterItemRestaurant(
            name = "Rumbai",
            onClick = {
                selected.value = "Rumbai"
                search.value = "Rumbai"
            },
            color = when (selected.value) {
                "Rumbai" -> MaterialTheme.colors.onSurface
                else -> MaterialTheme.colors.secondary
            },
            colorSurface = when (selected.value) {
                "Rumbai" -> MaterialTheme.colors.primaryVariant
                else -> MaterialTheme.colors.onSecondary
            }
        )

    }

//                    Last Row
    Spacer(modifier = Modifier.height(16.dp))
    FilterItemRestaurant(
        name = "Tenayan Raya",
        onClick = {
            selected.value = "Tenayan Raya"
            search.value = "Tenayan Raya"
        },
        color = when (selected.value) {
            "Tenayan Raya" -> MaterialTheme.colors.onSurface
            else -> MaterialTheme.colors.secondary
        },
        colorSurface = when (selected.value) {
            "Tenayan Raya" -> MaterialTheme.colors.primaryVariant
            else -> MaterialTheme.colors.onSecondary
        }
    )
}