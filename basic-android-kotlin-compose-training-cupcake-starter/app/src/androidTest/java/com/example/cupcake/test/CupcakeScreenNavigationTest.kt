//package com.example.cupcake.test
//import androidx.compose.ui.test.junit4.createAndroidComposeRule
//import org.junit.Rule
//import androidx.activity.ComponentActivity
//import androidx.compose.ui.platform.LocalContext
//import androidx.navigation.NavController
//import androidx.navigation.compose.ComposeNavigator
//import androidx.navigation.testing.TestNavHostController
//import org.junit.Before
//
//class CupcakeScreenNavigationTest {
//    @get:Rule
//    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
//    private lateinit var navController: TestNavHostController
//
//    @Before
//    fun setupCupcakeNavHost() {
//        composeTestRule.setContent {
//            navController = TestNavHostController(LocalContext.current).apply {
//                navigatorProvider.addNavigator(ComposeNavigator())
//            }
//            CupcakeApp(navController = navController)
//        }
//    }
//}