package com.meleastur.technicaltest_jas.di.component

import com.meleastur.technicaltest_jas.di.module.MainActivityModule
import com.meleastur.technicaltest_jas.di.module.SplashActivityModule
import com.meleastur.technicaltest_jas.ui.main.MainActivity
import com.meleastur.technicaltest_jas.ui.splash.SplashActivity
import dagger.Component

@Component(modules = [SplashActivityModule::class])
interface SplashActivityComponent {

    fun inject(splashActivity: SplashActivity)

}