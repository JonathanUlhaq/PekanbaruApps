package com.belajar.pekanbaruapps.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonTraveloka(
    text:String = "Lihat di Traveloka",
    modifier: Modifier = Modifier,
    onCLick:() -> Unit ={}
) {
    Button(
        onClick = { onCLick.invoke() },
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, bottom = 12.dp, top = 12.dp),
        shape = RoundedCornerShape(100.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onSurface
        )
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
        )
    }
}