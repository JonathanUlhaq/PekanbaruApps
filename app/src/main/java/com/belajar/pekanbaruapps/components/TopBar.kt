package com.belajar.pekanbaruapps.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import com.belajar.pekanbaruapps.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.navigation.AppRoute

@Composable
fun TopBar(
    isHome: Boolean,
    navController: NavController,
    title: String = "",
    iconSave:Boolean = true,
    back:() -> Unit = {},
    draftSave: () -> Unit = {}
) {
    if (isHome) {
        Surface(
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, top = 15.dp, bottom = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = " Pekanbaru",
                        style = MaterialTheme.typography.h2,
                        fontSize = 20.sp,
                        color = MaterialTheme.colors.surface
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = " Dalam Gangguan",
                        style = MaterialTheme.typography.h2,
                        fontSize = 20.sp,
                        color = MaterialTheme.colors.surface
                    )
                }
                IconButton(onClick = { navController.navigate(AppRoute.Profile.route) }) {
                    Surface(
                        shape = CircleShape,
                        color = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.photo),
                            contentDescription = "Account",
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    } else {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = {
                    back.invoke()
                    navController.popBackStack()
                     }) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                        tint = MaterialTheme.colors.surface
                    )
                }
            },
            title = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.surface
                )
            },
            actions = {
               if (iconSave) {
                   IconButton(onClick = {
                       draftSave.invoke()
                   }) {
                       Icon(
                           painter = painterResource(id = R.drawable.draft_save),
                           contentDescription = null,
                           tint = MaterialTheme.colors.surface
                       )
                   }
               }
            },
            backgroundColor = MaterialTheme.colors.onSurface,
            elevation = 0.dp
        )
    }
}