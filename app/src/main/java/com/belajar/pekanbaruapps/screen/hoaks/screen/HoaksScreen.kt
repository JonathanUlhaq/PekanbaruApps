package com.belajar.pekanbaruapps.screen.hoaks.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.model.BeritaModel
import com.belajar.pekanbaruapps.model.HoaksModel

@Composable
fun HoakScreen(uiState: List<HoaksModel>, navController: NavController) {
    LazyColumn(content = {
        items(uiState) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, bottom = 12.dp, top = 12.dp)
                    .clickable {
//                        navController.navigate(AppRoute.SDDetail.route + "/${it.name}")
                    },
                shape = RoundedCornerShape(12.dp),
                backgroundColor = MaterialTheme.colors.onSurface,
                elevation = 6.dp
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .size(80.dp)
                    ) {
                        Image(
                            painter = painterResource(id = it.image!!),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(

                    ) {

                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.h3,
                            color = MaterialTheme.colors.surface,
                            fontSize = 16.sp,
                            modifier = Modifier.width(230.dp)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.date),
                                    contentDescription = null,
                                    tint = MaterialTheme.colors.primaryVariant
                                )
                                Spacer(modifier = Modifier.width(8.5.dp))
                                Text(
                                    text = it.date!!,
                                    style = MaterialTheme.typography.h3,
                                    color = MaterialTheme.colors.secondary,
                                    fontSize = 12.sp
                                )
                            }
                            Spacer(modifier = Modifier.weight(1F))
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.view),
                                    contentDescription = null,
                                    tint = MaterialTheme.colors.primaryVariant
                                )
                                Spacer(modifier = Modifier.width(8.5.dp))
                                Text(
                                    text = it.view!!,
                                    style = MaterialTheme.typography.h3,
                                    color = MaterialTheme.colors.secondary,
                                    fontSize = 12.sp
                                )
                            }
                        }

                    }

                }
            }
        }
    })
}
