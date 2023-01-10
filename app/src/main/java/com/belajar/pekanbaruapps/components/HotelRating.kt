package com.belajar.pekanbaruapps.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.belajar.pekanbaruapps.R


@Composable
fun HotelRatting(rating: String) {
    Row {
        for (i in 0..rating.toInt()) {
            Icon(
                painter = painterResource(id = R.drawable.star),
                contentDescription = null,
                tint = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(end = 6.dp)
            )
        }
    }
}