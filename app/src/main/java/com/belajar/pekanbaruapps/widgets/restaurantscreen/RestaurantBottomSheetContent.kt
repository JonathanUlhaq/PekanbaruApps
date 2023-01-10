package com.belajar.pekanbaruapps.widgets.restaurantscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RestaurantBottomSheetContent(
    coroutineScope: CoroutineScope,
    bottomSheetState: ModalBottomSheetState,
    search: MutableState<String>
) {
    val selected = remember {
        mutableStateOf("Semua")
    }


    Surface(
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        color = MaterialTheme.colors.onSurface,
        modifier = Modifier

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 24.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1F))
                Text(
                    text = "Filter",
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.weight(1F))
                IconButton(onClick = {
                    coroutineScope.launch {
                        bottomSheetState.hide()
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = MaterialTheme.colors.surface,
                        modifier = Modifier
                            .size(14.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Kecamatan",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.surface
            )
            Spacer(modifier = Modifier.height(16.dp))
            RestaurantFilter(selected, search)

        }
    }
}