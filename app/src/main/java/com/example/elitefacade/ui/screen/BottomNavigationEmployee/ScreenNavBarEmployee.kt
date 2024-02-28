package com.example.elitefacade.ui.screen.BottomNavigationEmployee

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.elitefacade.R
import com.example.elitefacade.ui.model.BottomNavItemEmployee
import com.example.elitefacade.presentation.theme.backgroundBtn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenNavBarEmployee(navController:NavController) {
    val navControllerBarEmployee = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                colors= TopAppBarDefaults.topAppBarColors(
                    containerColor= Color.Transparent
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
        },
        bottomBar = { BottomBarEmployee(navControllerBarEmployee) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            BottomNavGraphEmployee(navController = navControllerBarEmployee)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBarEmployee(navControllerBarEmployee: NavController) {
    BottomNavigation(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(20.dp)),
        backgroundColor = Color.White
    ) {
        val navBackStackEntry by navControllerBarEmployee.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }

        BottomNavItemEmployee.allItems.forEach { item ->

            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navControllerBarEmployee.navigate(item.route) {
                        popUpTo(navControllerBarEmployee.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Box(
                        Modifier
                            .padding(2.dp)
                            .fillMaxWidth()

                    ) {
                        BadgedBox(
                            modifier = Modifier
                                .padding(top = 14.dp, bottom = 2.dp)
                                .align(Alignment.Center),

                            badge = {
                                if (item.badgeCount != null) {
                                    Badge {
                                        Text(text = item.badgeCount.toString())
                                    }

                                }
                            }) {
                            Icon(
                                painter = painterResource(id = item.iconResId),
                                contentDescription = null,
                                modifier = Modifier.size(25.dp),
                                tint = if(currentRoute == item.route){
                                    MaterialTheme.colorScheme.onPrimary
                                }else{
                                    Color.LightGray
                                }


                            )
                        }
                    }

                },
                label = {
                    Text(
                        item.label,
                        style = (MaterialTheme.typography.labelSmall),
                        color =  if(currentRoute == item.route){
                            MaterialTheme.colorScheme.onPrimary
                        }else{
                            Color.LightGray
                        },
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                },
                unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                selectedContentColor = backgroundBtn


            )
        }
    }
}
