package com.meleastur.technicaltest_jas.di.component

import com.meleastur.technicaltest_jas.App
import com.meleastur.technicaltest_jas.di.module.ApplicationModule
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: App)

}