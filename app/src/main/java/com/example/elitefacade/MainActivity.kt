package com.example.elitefacade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.elitefacade.screen.views.Order.OrderClientPrevView
import com.example.elitefacade.screen.views.SingIn.pagertab.TabLayout
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
                            //TabLayout(navController)
                            TabLayout(navController = navController)
                            // navController.navigate("ScreenOrderClient")
                        }
                        composable("ScreenOrderClient") {
                            OrderClientPrevView()
                        }
                    }

                    //   AppContainer(windowSizeClass = calculateWindowSizeClass(activity = this))
                }
            }


        }
    }
}
