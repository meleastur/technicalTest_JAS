package com.meleastur.technicaltest_jas.di.component

import com.meleastur.technicaltest_jas.di.module.MainActivityModule
import com.meleastur.technicaltest_jas.ui.main.MainActivity
import dagger.Component

@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

}