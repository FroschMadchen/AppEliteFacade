package com.example.elitefacade.ui.screen.BottomNavigationEmployee.Profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.elitefacade.R
import com.example.elitefacade.presentation.theme.LightGreyBackground
import com.example.elitefacade.ui.screen.AppSession
import com.example.elitefacade.ui.screen.Screen


@Composable
fun ProfileView(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(LightGreyBackground)
    ) {
        Column(Modifier.padding(top = 110.dp)) {
            InfoCard(nameUser = "Евгений Румынников")

            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 16.dp, end = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(15.dp),
                onClick = { navController.navigate(Screen.Registration.route) }) {
                Text(
                    text = "Регистрация нового сотрудника",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }

    }

}

@Composable
fun InfoCard(nameUser: String) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(end = 10.dp, start = 10.dp, top = 6.dp, bottom = 6.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {

                    Text(
                        text = AppSession.userNameSession,
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = AppSession.jobTitleSession,
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.labelMedium
                    )

                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.chat_22),
                        contentDescription = ""
                    )
                }

            }
            Box(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color.Gray)
            ) {}
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = stringResource(id = R.string.profile_view_email),   color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleMedium)
                    Text(text = AppSession.emailSession,   color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.labelMedium)

                }


                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.chat_22),
                        contentDescription = ""
                    )
                }

            }

            Box(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color.Gray)
            ) {}
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = stringResource(id = R.string.profile_view_edit_password),
                    style=MaterialTheme.typography.titleMedium,
                    color=MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.chat_22),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

