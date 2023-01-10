package com.belajar.pekanbaruapps.screen.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.components.ButtonTraveloka
import com.belajar.pekanbaruapps.components.SearchField
import com.belajar.pekanbaruapps.navigation.AppRoute

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUp(
    navController: NavController
) {
    val id = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }
    val keyboard = LocalSoftwareKeyboardController.current
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .wrapContentHeight(Alignment.CenterVertically)
        .wrapContentWidth(Alignment.CenterHorizontally)) {
        Column(
            modifier = Modifier

                .padding(start = 24.dp, end = 24.dp)
        ) {
            Text(text = " Buat akun \n baru",
                style = MaterialTheme.typography.h3,
                fontSize = 24.sp,
                color = MaterialTheme.colors.surface)

            Spacer(modifier = Modifier.height(24.dp))

            SearchField(value = id.value, placeholderText = "Email",
                onValueChange ={id.value = it}, forSearch = false,
                modifier = Modifier
                    .fillMaxWidth()) {
                keyboard?.hide()
            }
            Spacer(modifier = Modifier.height(12.dp))
            SearchField(value = password.value, placeholderText = "Password",
                onValueChange ={password.value = it}, forSearch = false,
                visualTransformation = PasswordVisualTransformation(),
                keyType = KeyboardType.Password,
                modifier = Modifier
                    .fillMaxWidth()) {
                keyboard?.hide()
            }
            Spacer(modifier = Modifier.height(12.dp))
            ButtonTraveloka("Daftar",modifier = Modifier.padding(0.dp)) {
                navController.navigate(AppRoute.Login.route)
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                Box(modifier = Modifier
                    .width(50.dp)
                    .height(1.dp)
                    .background(MaterialTheme.colors.secondary))
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "Atau lanjutkan dengan",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.secondary)
                Spacer(modifier = Modifier.width(12.dp))
                Box(modifier = Modifier
                    .width(50.dp)
                    .height(1.dp)
                    .background(MaterialTheme.colors.secondary))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                Image(painter = painterResource(id = R.drawable.logo_google),
                    contentDescription = null)

                Spacer(modifier = Modifier.height(16.dp))

                Row {
                    Text(text = "Sudah punya akun ? ",
                        color = MaterialTheme.colors.secondary,
                        style = MaterialTheme.typography.body1,
                        fontSize = 12.sp)

                    Text(text = "log in ",
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.body1,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .clickable {
                                navController.navigate(AppRoute.Login.route)
                            })
                }
            }

        }
    }

}