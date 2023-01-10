package com.belajar.pekanbaruapps.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import com.belajar.pekanbaruapps.R
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.belajar.pekanbaruapps.components.ButtonTraveloka
import com.belajar.pekanbaruapps.components.SearchField
import com.belajar.pekanbaruapps.navigation.AppRoute

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(
    navController: NavController
) {
    val id = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }
val keyboard =LocalSoftwareKeyboardController.current
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .wrapContentHeight(CenterVertically)
        .wrapContentWidth(CenterHorizontally)) {
        Column(
            modifier = Modifier

                .padding(start = 24.dp, end = 24.dp)
        ) {
            Text(text = " Login akun \n anda",
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
            ButtonTraveloka("Masuk",modifier = Modifier.padding(0.dp)) {
                navController.navigate(AppRoute.Home.route)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(CenterHorizontally)) {
                Text(text = "Lupa password ?",
                    style = MaterialTheme.typography.body1,
                    fontSize = 12.sp,
                    color = MaterialTheme.colors.primary,
                    textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(CenterHorizontally)
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
                    .wrapContentWidth(CenterHorizontally)
            ) {
                Image(painter = painterResource(id = R.drawable.logo_google),
                    contentDescription = null)

                Spacer(modifier = Modifier.height(16.dp))
                
                Row {
                    Text(text = "Belum punya akun ? ",
                        color = MaterialTheme.colors.secondary,
                        style = MaterialTheme.typography.body1,
                        fontSize = 12.sp)

                    Text(text = "Sign Up ",
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.body1,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .clickable {
                                navController.navigate(AppRoute.Signup.route)
                            })
                }
            }

        }
    }

}