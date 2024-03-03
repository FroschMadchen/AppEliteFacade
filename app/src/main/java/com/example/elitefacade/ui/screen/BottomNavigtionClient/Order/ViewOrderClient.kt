package com.example.elitefacade.ui.screen.BottomNavigtionClient.Order


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.elitefacade.R
import com.example.elitefacade.presentation.theme.backgroundBtn323


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderClientPrevView(navController: NavController) {
    Box(Modifier.background(MaterialTheme.colorScheme.background)) {
        OrderTitle(navController)
    }
}

@Composable
fun OrderTitle(navController: NavController) {

    Column(
        Modifier
            .padding(end = 16.dp, start = 16.dp)
            .background(Color.Transparent)
    ) {

        Text(
            text = stringResource(id = R.string.hello_name_client),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(bottom = 10.dp, end = 10.dp),
            color = MaterialTheme.colorScheme.onSecondary
        )


        /*Text(
            text = stringResource(id = R.string.order_info_client),
          style=MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
            color = backgroundBtn323
        )*/

        ExpandableDeliveryInfo()

        Spacer(modifier = Modifier.padding(5.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)

        ) {
            item {
                Box(
                    Modifier.background(
                        shape = RoundedCornerShape(15.dp),
                        color = Color.White
                    )
                ) {
                    Column(Modifier.padding(5.dp)) {
                        Row {
                            Text(
                                text = "Доставка",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(
                                    top = 10.dp,
                                    bottom = 10.dp,
                                    start = 10.dp
                                ),
                                color = backgroundBtn323
                            )

                            Text(
                                text = " В ПУТИ ",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier
                                    .padding(10.dp, top = 10.dp, bottom = 10.dp)
                                    .background(
                                        shape = RoundedCornerShape(15.dp),
                                        color = MaterialTheme.colorScheme.onSecondary
                                    ),
                                color = Color.White
                            )
                        }

                        Column (Modifier.padding(bottom=5.dp)){

                            BoxInfoDelivery(
                                image = R.drawable.icon_calendar,
                                text1 = "Заказ приедет",
                                text2 = "До 10 февраля"
                            )
                            BoxInfoDelivery(
                                image = R.drawable.icon_placeholder,
                                text1 = "Чувашия Чуваашская Республика",
                                text2 = " с. Красноармейское, ул. Победы, д.23"
                            )
                        }
                    }
                }

            }



            itemsIndexed(
                listOf(
                    StatusOrderState(status = "Изготовление товара", data = " 28 января 2024 в 21:30"),
                    StatusOrderState(status="Упаковка товара",data= " 29 января 2024 в 11:30"),
                    StatusOrderState(status="Передано в доставку", data=" 29 января 2024 в 14:50"),
                    StatusOrderState(status="Едет к вам", data=" 29 января 2024 в 17:30"),
                    StatusOrderState(status="Прибыл", data="Ожидается")
                )
            ) { _, item ->
                val image = if (item.data == "Ожидается") {
                    R.drawable.icon_circle
                } else {
                    R.drawable.icon_check_mark
                }
                val color = if (item.data == "Ожидается") {
                    Color.White
                } else {
                    MaterialTheme.colorScheme.surface
                }
                BoxInfoStatus(image, item, color)
            }


        }


    }
}

@Composable
fun BoxInfoStatus(image: Int, item: StatusOrderState, color: Color) {
    Spacer(modifier = Modifier.padding(5.dp))
    Box(
        modifier = Modifier
            .background(color = color, shape = RoundedCornerShape(15.dp))
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val romulFontFamily = FontFamily(Font(R.font.sf_pro_display_regular))
            Image(
                painter = painterResource(image), contentDescription = "",
                Modifier
                    .align(Alignment.CenterVertically)
                    .size(35.dp)
                    .padding(start = 10.dp)
            )
            Column(Modifier.padding(start = 10.dp)) {
                Text(
                    text = item.status,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = item.data,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }

}

@Composable
fun BoxInfoDelivery(image: Int, text1: String, text2: String) {
    Row(modifier = Modifier.padding(top = 5.dp, end = 5.dp, start = 10.dp)) {

        Image(
            painter = painterResource(image), contentDescription = "",
            Modifier
                .align(Alignment.CenterVertically)
                .size(35.dp)
                .padding(start = 10.dp)
        )
        Column(Modifier.padding(start = 10.dp)) {
            Text(
                text = text1,
                style = MaterialTheme.typography.labelSmall,
                color = backgroundBtn323
            )
            Text(
                text = text2,
                style = MaterialTheme.typography.labelMedium,
                color = backgroundBtn323
            )
        }
    }
}

