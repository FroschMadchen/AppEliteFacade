package com.example.elitefacade.ui.screen.Login


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.elitefacade.R
import com.example.elitefacade.ui.screen.Login.pagertab.pagerTabIndicatorOffset
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun ScreenTabLayout(
    onNavigateInBarClientScreen:() -> Unit = {},
    onNavigationInBarEmployeeScreen:() -> Unit = {}
) {
    val tabList =
        listOf(stringResource(id = R.string.client), stringResource(id = R.string.employee))
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(top = 50.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 3.dp, end = 5.dp)
                .clip(RoundedCornerShape(5.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")
            Text(
                text = stringResource(id = R.string.info_name),
                style = (MaterialTheme.typography.titleLarge),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 10.dp),
                color = MaterialTheme.colorScheme.onSecondary
            )

            TabRow(
                selectedTabIndex =  pagerState.currentPage,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    )

                },
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = Color.Transparent
            ) {
                tabList.forEachIndexed { index, title ->
                    Tab(
                        selected = index == pagerState.currentPage, // false
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                               // onPageSelected(index)
                            }
                        },
                        text = {
                            Text(text = title)
                        })
                }
            }
            HorizontalPager(
                count = tabList.size,
                state = pagerState
            ) { index ->
               when (index) {
                    0 -> ViewSingInClient(onNavigateInBarClientScreen)
                    1 -> ViewSignInEmployee(onNavigationInBarEmployeeScreen)
                    else -> ViewSingInClient(onNavigateInBarClientScreen)
                }
            }
        }
    }
}


