package com.belajar.pekanbaruapps.screen.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.components.ButtonTraveloka
import com.belajar.pekanbaruapps.components.SearchField
import com.belajar.pekanbaruapps.components.TopBar

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EditProfile(navController: NavController) {
    val name = remember {
        mutableStateOf("")
    }

    val email = remember {
        mutableStateOf("")
    }

    val telp = remember {
        mutableStateOf("")
    }

    val tl = remember {
        mutableStateOf("")
    }

    val keyboard = LocalSoftwareKeyboardController.current
    Scaffold(
        topBar = {
            TopBar(
                isHome = false,
                navController = navController,
                iconSave = false,
                title = "Edit Profile"
            )
        }
    ) {
        Column(
            Modifier
                .padding(it)
                .padding(start = 24.dp, end = 24.dp)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                SearchField(
                    modifier = Modifier.fillMaxWidth() ,
                    value = name.value,
                    placeholderText = "Nama",
                    onValueChange = { name.value = it }) {
                    keyboard?.hide()
                }

                Spacer(modifier = Modifier.height(12.dp))
                SearchField(
                    modifier = Modifier.fillMaxWidth() ,
                    value = email.value,
                    placeholderText = "Email",
                    onValueChange = { email.value = it }) {
                    keyboard?.hide()
                }

                Spacer(modifier = Modifier.height(12.dp))
                SearchField(
                    modifier = Modifier.fillMaxWidth() ,
                    value = telp.value,
                    placeholderText = "Nomor telfon",
                    onValueChange = { telp.value = it }) {
                    keyboard?.hide()
                }

                Spacer(modifier = Modifier.height(12.dp))
                SearchField(
                    modifier = Modifier.fillMaxWidth() ,
                    value = tl.value,
                    placeholderText = "Tanggal Lahir",
                    onValueChange = { tl.value = it }) {
                    keyboard?.hide()
                }
                Spacer(modifier = Modifier.weight(1F))
                ButtonTraveloka("Edit") {
                    navController.popBackStack()
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }

    }
}