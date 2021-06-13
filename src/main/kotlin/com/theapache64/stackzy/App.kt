package com.theapache64.stackzy

import com.theapache64.cyclone.core.Application
import com.theapache64.stackzy.data.local.AppArgs
import com.theapache64.stackzy.ui.feature.MainActivity
import com.toxicbakery.logging.Arbor
import com.toxicbakery.logging.Seedling


class App(
    appArgs: AppArgs
) : Application() {

    companion object {
        // GLOBAL CONFIGS
        const val CUSTOM_TOOLBAR = false // TODO: Implement a custom toolbar
        lateinit var appArgs: AppArgs
    }

    init {
        App.appArgs = appArgs
    }

    override fun onCreate() {
        super.onCreate()
        Arbor.sow(Seedling())

        val splashIntent = MainActivity.getStartIntent()
        startActivity(splashIntent)
    }
}

/**
 * The magic begins here
 */
fun main() {
    // Parsing application arguments

    //TODO: This should be read from properties file generated by build-process/gradle
    val appArgs = AppArgs(
        appName = "Stackzy",
        version = "v1.0.5",
        versionCode = 20210613
    )

    // Passing args
    App(appArgs).onCreate()
}