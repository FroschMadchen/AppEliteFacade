package com.example.elitefacade.screen.views.SingIn.pagertab


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.elitefacade.R
import com.example.elitefacade.screen.views.SingIn.ViewSignInEmployee
import com.example.elitefacade.screen.views.SingIn.ViewSingInClient
import com.example.elitefacade.ui.theme.backgroundBtn323
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(navController: NavController) {
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
                modifier = Modifier.padding(start=16.dp,end=16.dp,top=10.dp),
                color = MaterialTheme.colorScheme.onSecondary
            )
         /*   Text(
                text = stringResource(id = R.string.info_company),
                style = (MaterialTheme.typography.titleSmall),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .align(Alignment.CenterHorizontally),
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )*/

            TabRow(
                selectedTabIndex = tabIndex,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                        //color = MaterialTheme.colorScheme.onPrimary
                    )

                },
                contentColor = backgroundBtn323,//MaterialTheme.colorScheme.onPrimary,
                containerColor = Color.Transparent
            ) {
                tabList.forEachIndexed { index, s ->
                    Tab(
                        selected = false,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = {
                            Text(text = s)
                        })
                }
            }
            HorizontalPager(
                count = tabList.size,
                state = pagerState,
                // modifier = Modifier.weight(1.0f)
            ) { index ->
                val list = when (index) {
                    0 -> ViewSingInClient(navController)
                    1 -> ViewSignInEmployee()
                    else -> ViewSingInClient(navController)
                }
                // MainList(list, currentDays)
            }
        }
    }

}

