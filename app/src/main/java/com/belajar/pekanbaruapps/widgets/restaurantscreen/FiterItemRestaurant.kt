package com.belajar.pekanbaruapps.widgets.restaurantscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun FilterItemRestaurant(
    name: String,
    colorSurface: Color,
    color: Color,
    onClick: (String) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(50.dp),
        color = colorSurface,
        modifier = Modifier
            .clickable {
                onClick.invoke(name)
            }
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.body1,
            color = color,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
        )
    }
}