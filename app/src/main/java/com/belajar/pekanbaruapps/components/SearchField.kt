package com.belajar.pekanbaruapps.components

import android.hardware.lights.Light
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belajar.pekanbaruapps.R

@Composable
fun SearchField(
    value: String,
    placeholderText: String,
    onValueChange: (String) -> Unit,
    backgroundColor:Color = MaterialTheme.colors.onSecondary,
    borderColor:Color = MaterialTheme.colors.onSecondary,
    modifier: Modifier = Modifier,
    forSearch:Boolean = true,
    keyType:KeyboardType = KeyboardType.Text,
    visualTransformation:VisualTransformation = VisualTransformation.None,
    onKeyboardAction: () -> Unit
) {
    OutlinedTextField(
        value = value,
        visualTransformation = visualTransformation ,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(12.dp),
        leadingIcon = {
           if (forSearch) {
               Icon(
                   painter = painterResource(id = R.drawable.search),
                   contentDescription = null
               )
           }
        },
        placeholder = {
            Text(text = placeholderText)
        },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            leadingIconColor = MaterialTheme.colors.surface,
            backgroundColor = backgroundColor ,
            unfocusedBorderColor = borderColor,
            focusedBorderColor = borderColor,
            placeholderColor = MaterialTheme.colors.secondary
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done, keyboardType = keyType),
        keyboardActions = KeyboardActions {
            onKeyboardAction.invoke()
        },
        textStyle = TextStyle.Default.copy(
            fontSize = 14.sp
        ),
        modifier = modifier

    )
}