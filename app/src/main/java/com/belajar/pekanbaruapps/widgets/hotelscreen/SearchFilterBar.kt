package com.belajar.pekanbaruapps.widgets.hotelscreen

import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.components.SearchField


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchFilterBar(
    search: MutableState<String> = mutableStateOf(""),
    keyboardController: SoftwareKeyboardController?,
    placeHolder:String = "Cari Hotel",
    filterItem:Boolean = true,
    modifier:Modifier = Modifier,
    mudif:Modifier = Modifier.padding(start = 24.dp, end = 24.dp),
    icon:Int = R.drawable.menu,
    shape:androidx.compose.ui.graphics.Shape = RoundedCornerShape(12.dp),
    colors:androidx.compose.ui.graphics.Color = MaterialTheme.colors.onSecondary,
    iconColor:androidx.compose.ui.graphics.Color = MaterialTheme.colors.surface,
    filter: () -> Unit
) {
    Row(
        modifier = mudif
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        val backgroundColor by animateColorAsState(
            targetValue = if (search.value.isEmpty()) MaterialTheme.colors.onSecondary else MaterialTheme.colors.primary.copy(
                0.2F
            )
        )
        val borderColor by animateColorAsState(targetValue = if (search.value.isEmpty()) MaterialTheme.colors.onSecondary else MaterialTheme.colors.primary)

        SearchField(
            value = search.value,
            placeholderText = placeHolder,
            onValueChange = { search.value = it },
            backgroundColor = backgroundColor,
            borderColor = borderColor,
            modifier = modifier
                .width(250.dp)
        ) {
            keyboardController?.hide()
        }
        if (filterItem) {
            Spacer(modifier = Modifier.width(7.dp))
            IconButton(onClick = { filter.invoke() }) {
                Surface(
                    shape = shape,
                    modifier = Modifier
                        .size(58.dp),
                    color = colors
                ) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier
                            .padding(20.5.dp)
                    )
                }
            }
        }
    }
}