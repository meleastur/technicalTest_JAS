package com.meleastur.technicaltest_jas.ui.main

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.meleastur.technicaltest_jas.R
import com.meleastur.technicaltest_jas.di.component.DaggerMainActivityComponent
import com.meleastur.technicaltest_jas.di.module.MainActivityModule
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EActivity

@EActivity(R.layout.activity_main)
class MainActivity : AppCompatActivity() {

    @AfterViews
    protected fun afterViews() {
        injectDependency()
    }

    private fun injectDependency() {
        val activityComponent = DaggerMainActivityComponent.builder()
            .mainActivityModule(MainActivityModule(this))
            .build()

        activityComponent.inject(this)
    }
}