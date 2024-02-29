package com.example.elitefacade.ui.screen.Registration

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.elitefacade.R
import com.example.elitefacade.ui.screen.BottomNavigationEmployee.ScreenNavBarEmployee
import com.example.elitefacade.ui.screen.Screen
import com.mukeshsolanki.OTP_VIEW_TYPE_BORDER
import com.mukeshsolanki.OtpView


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationGetCodeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            ),
            title = { },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_back),
                        contentDescription = "Back", Modifier.size(30.dp)
                    )
                }
            }
        )
    }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            RegistrationGetCode(navController = navController)
        }

    }
}
@Composable
fun RegistrationGetCode(navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var otpValue by remember { mutableStateOf("") }

        Text(
            text = stringResource(id = R.string.Confirmation),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(20.dp),
            textAlign = TextAlign.Center
        )

        OtpView(
            otpText = otpValue,
            charBackground=Color.White,
            onOtpTextChange = {
                otpValue = it
                Log.d("Actual Value", otpValue)
            },
            type = OTP_VIEW_TYPE_BORDER,
            containerSize = 55.dp,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            charColor = MaterialTheme.colorScheme.onPrimary
        )

        Text(
            text = "Запросить код повторно через ...",
            Modifier.padding(20.dp),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Button(
            onClick = { navController.navigate(Screen.NavBarEmployee.route) },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier
                .padding(top = 5.dp, end = 10.dp, start = 10.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                stringResource(id = R.string.complete),
                style = (MaterialTheme.typography.bodyLarge),
                color = Color.White
            )
        }


    }

}

