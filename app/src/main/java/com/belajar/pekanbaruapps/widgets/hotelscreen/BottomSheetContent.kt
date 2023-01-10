package com.belajar.pekanbaruapps.widgets.hotelscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheetContent(
    selected: (Int) -> Unit,
    index: Int,
    close: () -> Unit

) {


    Surface(
        modifier = Modifier.height(300.dp),
        color = MaterialTheme.colors.onSurface,
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1F))
                Text(
                    text = "Filter",
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.weight(1F))
                IconButton(onClick = { close.invoke() }) {
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
                text = "Bintang Hotel",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.surface
            )
            Spacer(modifier = Modifier.width(24.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier
                        .height(44.dp)
                        .clickable {
                            selected.invoke(0)
                        },
                    shape = RoundedCornerShape(50.dp),
                    color = when (index) {
                        0 -> MaterialTheme.colors.primaryVariant
                        else -> MaterialTheme.colors.onSecondary
                    }
                ) {
                    Text(
                        text = "Semua",
                        style = MaterialTheme.typography.h3,
                        color = when (index) {
                            0 -> MaterialTheme.colors.onSurface
                            else -> MaterialTheme.colors.secondary
                        },
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.width(15.dp))

                StarRatting(selected, index, 5)
            }

            Spacer(modifier = Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                StarRatting(selected, index, 4)
                StarRatting(selected, index, 3)
                StarRatting(selected, index, 2)
            }

            Spacer(modifier = Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                StarRatting(selected, index, 1)
            }
        }
    }
}
