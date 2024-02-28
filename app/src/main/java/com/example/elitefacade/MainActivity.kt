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
import com.example.elitefacade.ui.screen.BottomNavigationEmployee.ScreenNavBarEmployee

import com.example.elitefacade.ui.screen.BottomNavigtionClient.ScreenNavBarClient
import com.example.elitefacade.ui.screen.SingIn.ScreenTabLayout
import com.example.elitefacade.ui.screen.SplashScreen.SplashScreen
import com.example.elitefacade.presentation.theme.EliteFacadeTheme
import com.example.elitefacade.ui.navgraphs.MainNavGraph

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
                    MainNavGraph()
                    /*val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "SplashScreen") {
                        composable("SplashScreen"){
                            SplashScreen(navController = navController)
                        }

                        composable("ScreenSingIn") {
                            ScreenTabLayout(navController = navController)
                        }
                        composable("ScreenNavBar") {
                            ScreenNavBarClient(navController)
                        }
                       composable("ScreenNavBarEmployee") {
                           ScreenNavBarEmployee()
                        }

                    }*/
                    //   AppContainer(windowSizeClass = calculateWindowSizeClass(activity = this))
                }
            }
        }
    }
}

