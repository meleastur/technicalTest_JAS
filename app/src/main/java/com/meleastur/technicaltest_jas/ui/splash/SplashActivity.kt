package com.meleastur.technicaltest_jas.ui.splash

import androidx.appcompat.app.AppCompatActivity
import com.meleastur.technicaltest_jas.R
import com.meleastur.technicaltest_jas.di.component.DaggerSplashActivityComponent
import com.meleastur.technicaltest_jas.di.module.SplashActivityModule
import com.meleastur.technicaltest_jas.ui.main.MainActivity_
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EActivity
import java.util.*
import kotlin.concurrent.schedule

@EActivity(R.layout.activity_splash)
open class SplashActivity : AppCompatActivity() {

    // ==============================
    // region Activity
    // ==============================

    @AfterViews
    protected fun afterViews() {
        injectDependency()

        Timer("navigateMain", false).schedule(1500) {
            navigateMain()
        }
    }

    // endregion

    // ==============================
    // region Dagger
    // ==============================

    private fun injectDependency() {
        val activityComponent = DaggerSplashActivityComponent.builder()
            .splashActivityModule(SplashActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    // endregion

    // ==============================
    // region Navigation
    // ==============================

    private fun navigateMain() {
        MainActivity_.intent(this).start()
        this.finish()
    }

    // endregion
}