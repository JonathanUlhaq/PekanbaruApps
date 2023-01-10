package com.belajar.pekanbaruapps.components

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun DotIndicator(
    totalDots: Int,
    currentPage: Int
) {
    LazyRow(content = {
        items(totalDots) { index ->
            val sizee by animateIntAsState(
                targetValue = if (index == currentPage) 30 else 8
            )

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .height(5.dp)
                    .width(sizee.dp)
                    .background(MaterialTheme.colors.onSurface)
            )
            Spacer(modifier = Modifier.width(6.dp))

        }
    })
}