package com.example.elitefacade.ui.generic

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.elitefacade.R

@Composable
fun ButtonComponent(value:String, onButtonClicked: () -> Unit) {
    Button(
        onClick = {
            onButtonClicked.invoke()

        },
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.onSecondary,
            containerColor = MaterialTheme.colorScheme.onSecondary
        ),
        modifier = Modifier
            .padding(top = 15.dp, end = 10.dp, start = 10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp)

    ) {
        Text(
            stringResource(id = R.string.farther),
            style = (MaterialTheme.typography.bodyLarge),
            color = Color.White
        )
    }
}
