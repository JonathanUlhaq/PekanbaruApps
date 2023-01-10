package com.belajar.pekanbaruapps.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belajar.pekanbaruapps.R

@Composable
fun SecondarytopBar(
    title:String,
    draftSave:() -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 15.dp, bottom = 24.dp),
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.surface
            )
        },
        actions = {
            IconButton(onClick = {
                draftSave.invoke()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.draft_save),
                    contentDescription = null,
                    tint = MaterialTheme.colors.surface
                )
            }
        },
        backgroundColor = MaterialTheme.colors.onSurface,
        elevation = 0.dp
    )
}