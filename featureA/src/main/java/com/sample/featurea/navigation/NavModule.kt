package com.sample.featurea.navigation

import androidx.navigation.compose.composable
import com.sample.featurea.presentation.screens.FeatureAScreen
import com.sample.navigation.NavComposableModule
import com.sample.navigation.RoutConstants

val screenFeatureAModule = NavComposableModule { graph, navController ->
    graph.composable(RoutConstants.FEATURE_A){
        FeatureAScreen(navController)
    }
}