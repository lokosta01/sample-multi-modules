package com.sample.featureb

import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sample.navigation.NavComposableModule
import com.sample.navigation.RoutConstants

private const val MESSAGE_ARG_KEY = "MESSAGE"

val screenFeatureBModule = NavComposableModule { graph, navController ->
    graph.composable(
        route = "${RoutConstants.FEATURE_B}/{$MESSAGE_ARG_KEY}",
        arguments = listOf(navArgument(MESSAGE_ARG_KEY) { type = NavType.StringType })
    ) { backStackEntry ->
        val message = checkNotNull(backStackEntry.arguments?.getString(MESSAGE_ARG_KEY))
        FeatureBScreen(message)
    }
}
