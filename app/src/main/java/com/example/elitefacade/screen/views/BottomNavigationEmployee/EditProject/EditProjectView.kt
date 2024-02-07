package com.example.elitefacade.screen.views.BottomNavigationEmployee.EditProject

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elitefacade.R

@Composable
fun EditProjectView() {
    Box() {
        Text(
            text = stringResource(id = R.string.hello_name_client),
            fontSize = 28.sp,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp, end = 10.dp),
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}