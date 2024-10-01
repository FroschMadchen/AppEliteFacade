package com.example.elitefacade.ui.screen.BottomNavigationEmployee.ViewingProject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.elitefacade.R
import com.example.elitefacade.presentation.theme.EliteFacadeTheme

@Composable
fun ViewingProjectView() {
    // Создание вертикального скролла
    DropdownMenuExample()



}

@Composable
fun DropdownMenuView1() {
    // Внешний контейнер Box с шириной экрана
    val scrollState = rememberScrollState()
    Box(modifier = Modifier.fillMaxWidth().padding(top=35.dp)) {
        // Column для вертикального расположения элементов внутри скролла
        Column(modifier = Modifier.verticalScroll(scrollState)) {


            Text(
                text = "Статистика проектов",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(10.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = "Менеджер Василенко Валерия ",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .padding(10.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            // Добавление изображения
            Image(
                painter = painterResource(id = R.drawable.graf_1), // замените your_image на ваш идентификатор ресурса
                contentDescription = "analytic",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp) // Задайте высоту по вашему усмотрению
            )
            Text(
                text = "Аналитика общей суммы проектов",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Image(
                painter = painterResource(id = R.drawable.graf_2), // замените your_image на ваш идентификатор ресурса
                contentDescription = "analytic",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp) // Задайте высоту по вашему усмотрению
            )
            Text(
                text = "Уровни доступа ",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Image(
                painter = painterResource(id = R.drawable.graf_3), // замените your_image на ваш идентификатор ресурса
                contentDescription = "analytic",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp) // Задайте высоту по вашему усмотрению
            )
            // Пример добавления других элементов


            // Вы можете добавлять больше элементов, как вам нужно
        }
    }
}

@Composable
fun DropdownMenuView2() {

    // Внешний контейнер Box с шириной экрана
    val scrollState = rememberScrollState()
    Box(modifier = Modifier.fillMaxWidth().padding(top=35.dp)) {
        // Column для вертикального расположения элементов внутри скролла
        Column(modifier = Modifier.verticalScroll(scrollState)) {


            Text(
                text = "Статистика проектов",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(10.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = "Менеджер Баварских Олег К.",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .padding(10.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            // Добавление изображения
            Image(
                painter = painterResource(id = R.drawable.graf_1_2), // замените your_image на ваш идентификатор ресурса
                contentDescription = "analytic",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp) // Задайте высоту по вашему усмотрению
            )
            Text(
                text = "Аналитика общей суммы проектов",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Image(
                painter = painterResource(id = R.drawable.graf_bav_2), // замените your_image на ваш идентификатор ресурса
                contentDescription = "analytic",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp) // Задайте высоту по вашему усмотрению
            )
            Text(
                text = "Уровни доступа ",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Image(
                painter = painterResource(id = R.drawable.graf_3), // замените your_image на ваш идентификатор ресурса
                contentDescription = "analytic",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp) // Задайте высоту по вашему усмотрению
            )
            // Пример добавления других элементов


            // Вы можете добавлять больше элементов, как вам нужно
        }
    }
}

@Composable
fun DropdownMenuView3() {
    // Внешний контейнер Box с шириной экрана
    val scrollState = rememberScrollState()
    Box(modifier = Modifier.fillMaxWidth().padding(top=35.dp)) {
        // Column для вертикального расположения элементов внутри скролла
        Column(modifier = Modifier.verticalScroll(scrollState)) {


            Text(
                text = "Статистика проектов",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(10.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = "Менеджер Кан Мария Е. ",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .padding(10.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            // Добавление изображения
            Image(
                painter = painterResource(id = R.drawable.graf_kan_1), // замените your_image на ваш идентификатор ресурса
                contentDescription = "analytic",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp) // Задайте высоту по вашему усмотрению
            )
            Text(
                text = "Аналитика общей суммы проектов",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Image(
                painter = painterResource(id = R.drawable.graf_kan_2), // замените your_image на ваш идентификатор ресурса
                contentDescription = "analytic",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp) // Задайте высоту по вашему усмотрению
            )
            Text(
                text = "Уровни доступа ",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Image(
                painter = painterResource(id = R.drawable.graf_3), // замените your_image на ваш идентификатор ресурса
                contentDescription = "analytic",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp) // Задайте высоту по вашему усмотрению
            )
            // Пример добавления других элементов


            // Вы можете добавлять больше элементов, как вам нужно
        }
    }
}

@Composable
fun DropdownMenuExample() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Выберите менеджера") }
    val options = listOf("Василенко Валерия Б.", "Баварских Олег К.", "Кан Мария Е.")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Button(
            onClick = { expanded = true },
           modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = selectedOption)
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Arrow Icon"
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                // .width(IntrinsicSize.Max)
              //.align(Alignment.TopCenter)
                .background(Color.White)

        ) {
            options.forEach { option ->
                DropdownMenuItem(onClick = {
                    selectedOption = option
                    expanded = false
                }) {
                    Text(text = option)
                }
            }
        }

        // Вывод содержимого экрана в зависимости от выбранного элемента
        when (selectedOption) {
            "Василенко Валерия Б." -> {
                DropdownMenuView1()
            }
            // Ваш код для отображения содержимого для опции "Василенко Валерия Б."

            "Баварских Олег К." -> {
                DropdownMenuView2()
                // Ваш код для отображения содержимого для опции "Баварских Олег К."
            }

            "Кан Мария Е." -> {
                DropdownMenuView3()
                // Ваш код для отображения содержимого для опции "Кан Мария Е."
            }

            else -> {
                DropdownMenuView1()
                // Ваш код по умолчанию или обработка других опций
            }
        }
    }
}
    @Preview
    @Composable
    fun ViewingProjectViewScreen() {
        EliteFacadeTheme {
            ViewingProjectView()
        }
    }

