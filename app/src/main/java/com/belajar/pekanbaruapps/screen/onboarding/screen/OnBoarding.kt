package com.belajar.pekanbaruapps.screen.onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.components.ButtonTraveloka
import com.belajar.pekanbaruapps.components.ViewPager
import com.belajar.pekanbaruapps.navigation.AppRoute
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoarding(
    navController: NavController
) {
    val pagerState = rememberPagerState()
    val iconList = listOf(
        R.drawable.onboarding_a,
        R.drawable.onboarding_b,
        R.drawable.onboarding_c
    )
    val coroutine = rememberCoroutineScope()
    val title = listOf(
        "Satu Genggaman",
        "Layananan Digital",
        "Informasi Publik"
    )

    val text = listOf(
        "Memudahkan dan memenuhi segala kebutuhan anda dalam satu genggaman.",
        "Akses seluruh kebutuhan layanan publik \n" +
                "secara digital hanya dalam 1 aplikasi",
            "Kebutuhan informasi anda  dapat\n "+
                    "diakses dengan mudah dalam 1 aplikasi."
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(start = 24.dp, end = 24.dp)
    ) {
        ViewPager(state =pagerState , count = iconList.size, height = 550, onboarding = true ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = iconList[it] ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(315.dp))

                Spacer(modifier = Modifier.height(24.dp))

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(CenterHorizontally)) {
                    Text(text = title[it],
                        style = MaterialTheme.typography.h2,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center)
                }

                Spacer(modifier = Modifier.height(16.dp))


                Text(text = text[it],
                    style = MaterialTheme.typography.body1,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center)
            }


        }
        Spacer(modifier = Modifier.height(12.dp))
        ButtonTraveloka(
            if (pagerState.currentPage<2) {
                "Lanjut"
            } else {
                "Masuk"
            }
        ) {
            if (pagerState.currentPage<2) {
                coroutine.launch {
                    pagerState.scrollToPage(pagerState.currentPage + 1)
                }
            } else {
                navController.navigate(AppRoute.Login.route)
            }
        }
    }
}