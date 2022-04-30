package com.sample.modules.navigation

import androidx.navigation.compose.composable
import com.sample.modules.presentation.screens.SplashScreen
import com.sample.navigation.NavComposableModule
import com.sample.navigation.RoutConstants

val screenSplashModule = NavComposableModule { graph, navController ->
    graph.composable(RoutConstants.SPLASH){
        SplashScreen(navController)
    }
}