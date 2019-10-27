package com.meleastur.technicaltest_jas.ui.splash

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.meleastur.technicaltest_jas.R
import com.meleastur.technicaltest_jas.di.component.DaggerSplashActivityComponent
import com.meleastur.technicaltest_jas.di.module.SplashActivityModule
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EActivity

@EActivity(R.layout.activity_splash)
class SplashActivity: Activity() {

    @AfterViews
    protected fun afterViews() {
        injectDependency()

        navigateMain()
    }

    private fun injectDependency() {
        val activityComponent = DaggerSplashActivityComponent.builder()
                .splashActivityModule(SplashActivityModule(this))
                .build()

        activityComponent.inject(this)
    }


    private fun navigateMain() {
       // MainActivity_.intent(this).start()
        this.finish()
    }
}