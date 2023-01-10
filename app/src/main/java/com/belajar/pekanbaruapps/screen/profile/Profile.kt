package com.belajar.pekanbaruapps.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.components.TopBar
import com.belajar.pekanbaruapps.navigation.AppRoute

@Composable
fun ProfileScreen (
    navController: NavController
) {

    Scaffold(
        topBar = {
            TopBar(isHome = false, navController = navController, iconSave = false, title = "Profile" )
        }
    ) {
        Column(
            Modifier
                .padding(it)
                .padding(start = 24.dp, end = 24.dp)) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(CenterHorizontally)
            ) {
                Image(painter = painterResource(id = R.drawable.photo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp))
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Tiara Lorenza",
                    style = MaterialTheme.typography.h3,
                    fontSize = 20.sp)
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "tiaralorenza@gmail.com",
                    style = MaterialTheme.typography.body1,
                    fontSize = 12.sp)
            }

            Column {
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = "Edit Profile")
                    IconButton(onClick = { navController.navigate(AppRoute.EditProfile.route) }) {
                        Icon(painter = painterResource(id = R.drawable.right_row),
                            contentDescription = null,
                            tint = MaterialTheme.colors.surface)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = "Bantuan")
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.right_row),
                            contentDescription = null,
                            tint = MaterialTheme.colors.surface)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = "Tentang Aplikasi")
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.right_row),
                            contentDescription = null,
                            tint = MaterialTheme.colors.surface)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.logout),
                            contentDescription = null,
                            tint = MaterialTheme.colors.secondaryVariant)
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "Log Out",
                        color = MaterialTheme.colors.secondaryVariant)
                }
            }
        }
    }
}