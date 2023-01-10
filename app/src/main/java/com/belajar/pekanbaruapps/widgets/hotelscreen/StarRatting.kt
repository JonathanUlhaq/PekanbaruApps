package com.belajar.pekanbaruapps.widgets.hotelscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.belajar.pekanbaruapps.R


@Composable
fun StarRatting(selected: (Int) -> Unit, index: Int, indexPosition: Int) {
    Surface(
        modifier = Modifier
            .height(44.dp)
            .clickable {
                selected.invoke(indexPosition)
            },
        shape = RoundedCornerShape(50.dp),
        color = when (index) {
            indexPosition -> MaterialTheme.colors.primaryVariant
            else -> MaterialTheme.colors.onSecondary
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 19.dp, end = 19.dp, top = 13.dp, bottom = 13.dp)
        ) {
            for (i in 0..indexPosition - 1) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 8.15.dp),
                    tint = when (index) {
                        indexPosition -> MaterialTheme.colors.onSurface
                        else -> MaterialTheme.colors.secondary
                    }
                )
            }
        }
    }
}