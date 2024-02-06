package com.example.elitefacade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.elitefacade.screen.views.BottomNavigtionClient.Order.OrderClientPrevView
import com.example.elitefacade.screen.views.BottomNavigtionClient.ScreenNavBar
import com.example.elitefacade.screen.views.SingIn.ScreenTabLayout
import com.example.elitefacade.ui.theme.EliteFacadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //MyAppPreviewNew() OrderClientPrevView()
            /*  val isDarkTheme = isSystemInDarkTheme()
            DisposableEffect(isDarkTheme) {
                  enableEdgeToEdge(
                      statusBarStyle = SystemBarStyle.auto(
                          Color.Transparent,
                          Color.TRANSPARENT
                      ) { isDarkTheme },
                      navigationBarStyle = if (isDarkTheme) {
                          SystemBarStyle.dark(Color.TRANSPARENT)
                      } else {
                          SystemBarStyle.light(
                              Color.TRANSPARENT,
                              Color.TRANSPARENT
                          )
                      }
                  )
                  onDispose { }
              }*/
            EliteFacadeTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "ScreenSingIn") {

                        composable("ScreenSingIn") {
                            ScreenTabLayout(navController = navController)
                        }
                        composable("ScreenNavBar") {
                            ScreenNavBar()
                        }
                       /* composable("OrderClientPrevView") {
                            OrderClientPrevView(navController = navController)
                        }*/

                    }
                    //   AppContainer(windowSizeClass = calculateWindowSizeClass(activity = this))
                }
            }
        }
    }
}

