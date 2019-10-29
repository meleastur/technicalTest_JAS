package com.meleastur.technicaltest_jas.di.component

import com.meleastur.technicaltest_jas.App
import dagger.Component

@Component
interface ApplicationComponent {

    fun inject(application: App)

}