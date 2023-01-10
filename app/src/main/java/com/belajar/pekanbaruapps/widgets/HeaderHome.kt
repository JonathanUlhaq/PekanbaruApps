package com.belajar.pekanbaruapps.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.components.SearchField
import com.belajar.pekanbaruapps.components.ViewPager
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
@OptIn(ExperimentalPagerApi::class, ExperimentalComposeUiApi::class)
fun HeaderHome(
    search: MutableState<String>,
    keyboardController: SoftwareKeyboardController?,
    percentage:Float
) {
    val state = rememberPagerState()
    LaunchedEffect(key1 = state.currentPage) {
        launch {
            delay(3000)
            with(state) {
                val target = if (currentPage < pageCount - 1) currentPage + 1 else 0

                tween<Float>(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing
                )
                animateScrollToPage(page = target)
            }
        }
    }

       Box {
           Column {
               Spacer(modifier = Modifier.height(12.dp))
               ViewPager(state,3) {
                   ViewPagerItem(
                       modifier = Modifier
                           .width(379.dp)
                           .height(180.dp),
                       image = R.drawable.viewpager)
               }

           }

       }



}



@Composable
fun ViewPagerItem(
    modifier: Modifier,
    image: Int?
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    ) {

        Image(
            painter = painterResource(id = image!!),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
        )

    }
}

