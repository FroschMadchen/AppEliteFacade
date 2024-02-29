package com.example.elitefacade.ui.screen.BottomNavigtionClient.Order

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elitefacade.R
import com.example.elitefacade.presentation.theme.backgroundBtn323

class OrderList {
}

enum class ViewStatus {
    OPEN, CLOSED
}

@Composable
fun ExpandableDeliveryInfo() {
    val romulFontFamily1 = FontFamily(Font(R.font.sf_pro_display_medium))
    var ItemStatus by remember { mutableStateOf(ViewStatus.CLOSED) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(15.dp),
                color = Color.White
            )
    ) {
        Column() {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        ItemStatus =
                            if (ItemStatus == ViewStatus.OPEN) ViewStatus.CLOSED else ViewStatus.OPEN
                    }
                    .padding(16.dp)
            ) {
                Text(
                    "Перечень ваших закзов",
                    fontFamily = romulFontFamily1, fontSize = 22.sp, color = backgroundBtn323
                )  //style = MaterialTheme.typography.subtitle1
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    if (ItemStatus == ViewStatus.OPEN) painterResource(R.drawable.icon_sign_to) else painterResource(
                        R.drawable.icon_sign_to
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterVertically)
                        .rotate(if (ItemStatus == ViewStatus.OPEN) 0f else 180f)
                )
            }

            if (ItemStatus == ViewStatus.OPEN) {
                // Здесь вы можете добавить информацию о доставке
                // Например, использовать LazyColumn для истории доставок
                LazyColumn {
                    itemsIndexed(
                        listOf(
                            OrderState(
                                R.drawable.image_1,
                                "Перегородочные бетонные блоки СКЦ 2Р-9 600 шт",
                                "390х90х188 мм"
                            ), //Перегородочные пазогребневые бетонные блоки серии СКЦ 2Р-9 размером 390х90х188 мм
                            OrderState(
                                R.drawable.image_2,
                                "Классическая ковка, ГУВ  24 шт",
                                "1000х50 мм"
                            ),

                            )
                    )


                    {  index,item ->
                        ItemColum(item, index )
                    }

                    item {
                        Column(Modifier.padding(start = 10.dp, end = 10.dp)) {
                            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                                Text(
                                    "Доставка ",
                                    style = (MaterialTheme.typography.titleMedium),
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                                Text(
                                    "Бесплатно",
                                    style = (MaterialTheme.typography.titleMedium),
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                            Row(Modifier.fillMaxWidth().padding(bottom=10.dp), Arrangement.SpaceBetween) {
                                Text(
                                    "Всего ",
                                    fontFamily = romulFontFamily1,
                                    fontSize = 22.sp,
                                    color = backgroundBtn323
                                )
                                Text(
                                    "23 404 р",
                                    fontFamily = romulFontFamily1,
                                    fontSize = 22.sp,
                                    color = backgroundBtn323
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DeliveryItem(index: Int) {
    // Здесь создайте макет для каждого элемента истории доставки
    // Например, используйте Row, Column и другие компоненты Compose
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(Color.Gray)
            .clickable { /* Обработка нажатия на элемент */ }
    ) {
        BasicText("Доставка #$index")
        // Другие элементы и данные истории доставки
    }
}

@Preview(showBackground = true)
@Composable
fun ExpandableDeliveryInfoPreview() {

    ExpandableDeliveryInfo()

}

@Composable
fun ItemColum(order: OrderState, index:Int) {
    val romulFontFamily = FontFamily(Font(R.font.sf_pro_display_regular))
    val romulFontFamily1 = FontFamily(Font(R.font.sf_pro_display_medium))
    val quantity:Int = index+1
    Column (Modifier.padding(start=10.dp,end=10.dp)){

        Text(
            text = "Заказ номер $quantity ",
            fontFamily = romulFontFamily, fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 5.dp, start = 5.dp, end = 5.dp),
            color = backgroundBtn323
        )


        Row(
            modifier = Modifier
                .padding(start=10.dp,end=10.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Transparent)
        )
        {
            Image(
                painter = painterResource(id = order.image),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(5.dp)
                    .size(100.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Column {
                Text(
                    text = order.title,
                    fontFamily = romulFontFamily, fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 5.dp, start = 5.dp, end = 5.dp),
                    color = backgroundBtn323
                )
                Text(
                    text = order.size,
                    fontFamily = romulFontFamily1, fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 5.dp, start = 5.dp, end = 5.dp),
                    color = backgroundBtn323
                )
            }
        }
    }
}