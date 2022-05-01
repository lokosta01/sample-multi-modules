package com.sample.modules.presentation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sample.navigation.RoutConstants
import com.sample.navigation.loadMultiNavComposables

@Composable
fun MainScreen(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = RoutConstants.SPLASH) {
        loadMultiNavComposables(navHostController)
    }
}

