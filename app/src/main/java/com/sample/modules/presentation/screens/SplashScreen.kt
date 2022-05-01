package com.sample.modules.presentation.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import com.sample.modules.presentation.components.SplashScreenComponent
import com.sample.navigation.RoutConstants

@Composable
fun SplashScreen(navController: NavHostController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        navController.navigate(
            RoutConstants.FEATURE_A,
            NavOptions.Builder().setPopUpTo(RoutConstants.SPLASH, true).build()
        )
    }
    SplashScreenComponent()
}
