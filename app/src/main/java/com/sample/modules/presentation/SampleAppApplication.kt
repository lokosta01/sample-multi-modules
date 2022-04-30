package com.sample.modules.presentation

import android.app.Application
import com.sample.featurea.navigation.screenFeatureAModule
import com.sample.featureb.screenFeatureBModule
import com.sample.modules.navigation.screenSplashModule
import com.sample.navigation.multiNavModule
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SampleAppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        multiNavModule(screenSplashModule, screenFeatureAModule, screenFeatureBModule)
    }
}