package com.belajar.pekanbaruapps.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.belajar.pekanbaruapps.widgets.ViewPagerItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState


@Composable
@OptIn(ExperimentalPagerApi::class)
fun ViewPager(state: PagerState,count:Int,onboarding:Boolean = false,height:Int = 175,item:@Composable ()(Int) -> Unit) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp),
        color = Color.Transparent
    ) {
        Box {
            HorizontalPager(count = count, state = state) {
                item.invoke(it)
            }
            Box(
                modifier = Modifier
                    .height(height.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .wrapContentHeight(Alignment.Bottom)
            ) {
                if (!onboarding) {
                    DotIndicator(totalDots = count, currentPage = state.currentPage)
                } else {
                    DotIndicatorCustom(totalDots = count, currentPage = state.currentPage )
                }
            }
        }
    }
}

@Composable
fun DotIndicatorCustom(
    totalDots: Int,
    currentPage: Int
) {
    LazyRow(content = {
        items(totalDots) { index ->
            val color by animateColorAsState(targetValue =
            if (index == currentPage) MaterialTheme.colors.primaryVariant else MaterialTheme.colors.primaryVariant.copy(0.2F))
            val sizee by animateIntAsState(
                targetValue = if (index == currentPage) 30 else 8
            )

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .height(8.dp)
                    .width(sizee.dp)
                    .background(color)
            )
            Spacer(modifier = Modifier.width(6.dp))

        }
    })
}