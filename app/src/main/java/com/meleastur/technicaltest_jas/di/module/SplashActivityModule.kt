package com.meleastur.technicaltest_jas.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }
}