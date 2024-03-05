package com.example.elitefacade.ui.generic

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.elitefacade.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldSingUp(
    title: String,
    hint: String,
    icon: Int,
    onTextChanged: (String) -> Unit,
    errorStatus: Boolean = false
) {

    var textValue by rememberSaveable {
        mutableStateOf("")
    }

    Column(Modifier.padding(top = 3.dp, bottom = 3.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(top = 3.dp, bottom = 3.dp)
        )

        Box(
            Modifier
                .border(
                    width = if (textValue.isNotEmpty()) 1.dp else 1.dp,
                    shape = RoundedCornerShape(15.dp),
                    brush = Brush.horizontalGradient(
                        if (errorStatus) {
                            listOf(
                                MaterialTheme.colorScheme.onBackground,
                                MaterialTheme.colorScheme.onSurface
                            )
                        } else {
                            listOf(
                                MaterialTheme.colorScheme.error,
                                MaterialTheme.colorScheme.onError
                            )
                        }

                    )
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            Row(
                Modifier.padding(end = 2.dp, start = 2.dp),
                verticalAlignment = Alignment.CenterVertically,
                ) {
                TextField(

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
                    modifier = Modifier.weight(1f),
                    textStyle = MaterialTheme.typography.titleSmall,
                    singleLine = true,

                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                        focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                        containerColor = Color.Transparent,
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        cursorColor = Color.Gray
                    ),



                    trailingIcon = {

                        Icon(
                            painter = painterResource(icon),
                            contentDescription = "Visibility password",
                            Modifier.size(23.dp)
                        )

                    }
                )
            }
        }

        if(!errorStatus){
            Text(
                text = "Необходимо заполнить поле",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldSingUpPassword(
    title: String,
    hint: String,
    onTextChanged: (String) -> Unit,
    errorStatus: Boolean = false,
    errorStatusIdentity:Boolean = false
) {


    var textValue by rememberSaveable {
        mutableStateOf("")
    }
    var passwordVisibility by rememberSaveable {
        mutableStateOf(false)
    }

    Column(Modifier.padding(top = 3.dp, bottom = 3.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(top = 3.dp, bottom = 3.dp)

        )

        Box(
            Modifier
                .border(
                    width = if (textValue.isNotEmpty()) 1.dp else 1.dp,
                    shape = RoundedCornerShape(15.dp),
                    brush = Brush.horizontalGradient(
                        if (errorStatus) {
                            listOf(
                                MaterialTheme.colorScheme.onBackground,
                                MaterialTheme.colorScheme.onSurface
                            )
                        } else {
                            listOf(
                                MaterialTheme.colorScheme.error,
                                MaterialTheme.colorScheme.onError
                            )
                        }

                    )
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(15.dp)
                )
        ) {

            Row(
                Modifier.padding(end = 2.dp, start = 2.dp),
                verticalAlignment = Alignment.CenterVertically,

                ) {


                TextField(

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
                    modifier = Modifier.weight(1f),
                    textStyle = MaterialTheme.typography.titleSmall,
                    singleLine = true,

                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                        focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                        containerColor = Color.Transparent,
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        cursorColor = Color.Gray
                    ),
                    visualTransformation =
                    if (passwordVisibility) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },

                    trailingIcon = {
                        IconButton(
                            onClick = {
                                passwordVisibility = !passwordVisibility
                            }) {
                            Icon(
                                painter = if (passwordVisibility) {
                                    painterResource(id = R.drawable.icon_sing_up_eye)
                                } else {
                                    painterResource(id = R.drawable.icon_sing_up_hide)
                                },
                                contentDescription = "Visibility password",
                                Modifier.size(20.dp)
                            )

                        }
                    }
                )
            }
        }
        if(!errorStatus){
            Text(
                text = "Больше 6 символов",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(2.dp)
            )
        }
        if(!errorStatusIdentity){
            Text(
                text = "Пароли должны совпадать",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onError,
                modifier =Modifier.padding(2.dp)
                )
        }
    }
}