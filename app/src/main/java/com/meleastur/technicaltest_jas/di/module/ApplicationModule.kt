package com.meleastur.technicaltest_jas.di.module

import android.app.Application
import com.meleastur.technicaltest_jas.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return app
    }
}