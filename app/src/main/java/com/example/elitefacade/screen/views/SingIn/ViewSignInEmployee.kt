package com.example.elitefacade.screen.views.SingIn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elitefacade.R
import com.example.elitefacade.ui.theme.backgroundBtn
import com.example.elitefacade.ui.theme.backgroundBtn323


@Preview
@Composable
fun ViewSignInEmployee() {

    val romulFontFamily = FontFamily(Font(R.font.sf_pro_display_regular))
    val romulFontFamily1 = FontFamily(Font(R.font.sf_pro_display_medium))

    Column(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(end = 16.dp, start = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "11111",
            fontFamily = romulFontFamily1,
            fontSize = 28.sp,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
            color = backgroundBtn323
        )
        Text(
            text = "111111",
            fontFamily = romulFontFamily,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
            color = backgroundBtn323
        )
        // SimpleFilledTextFieldSample()
        TextFieldView(stringResource(id = R.string.name))
        TextFieldView(stringResource(id = R.string.password))

        AdditionalFunSingIn()

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = backgroundBtn,
                containerColor = backgroundBtn
            ),
            modifier = Modifier
                .padding(top = 15.dp, end = 10.dp, start = 10.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)

        ) {
            Text(
                stringResource(id = R.string.sign_in),
                fontSize = 25.sp,
                fontFamily = romulFontFamily,
                color = Color.White
            )

        }


    }
}



