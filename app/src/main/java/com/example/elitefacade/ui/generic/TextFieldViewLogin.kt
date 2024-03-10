package com.example.elitefacade.ui.generic

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldView(hint: String, onTextChanged: (String) -> Unit, errorStatus: Boolean) {
    var textValue by remember { mutableStateOf("") }

    TextField(

        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .border(
                width = 5.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        MaterialTheme.colorScheme.onBackground,
                        MaterialTheme.colorScheme.onSurface
                    )
                ),
                shape = RoundedCornerShape(15.dp),
            ),
        value = textValue,
        onValueChange = {
            textValue = it
            onTextChanged(it)
        },
        placeholder = {
            Text(
                text = hint,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        textStyle = (MaterialTheme.typography.titleSmall),
        shape = RoundedCornerShape(15.dp),

        colors = TextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onPrimary,
            cursorColor = Color.Blue, // Настроить цвет курсора
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Red,
            disabledContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        )
    )

    if (!errorStatus) {
        Text(
            text = "Поле должно иметь не менее 6 символов",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(2.dp)
        )
    }
}