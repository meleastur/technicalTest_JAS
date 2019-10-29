package com.meleastur.technicaltest_jas.di.module

import android.app.Activity
import com.meleastur.technicaltest_jas.ui.main.MainActivity
import com.meleastur.technicaltest_jas.ui.main.MainContract
import com.meleastur.technicaltest_jas.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private var activity: Activity) {

    @Provides
    fun provideMainActivity(): MainActivity {
        return activity as MainActivity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }
}