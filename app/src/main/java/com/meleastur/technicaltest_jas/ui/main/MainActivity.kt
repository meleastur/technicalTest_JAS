package com.meleastur.technicaltest_jas.ui.main

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.meleastur.technicaltest_jas.R
import com.meleastur.technicaltest_jas.di.component.DaggerMainActivityComponent
import com.meleastur.technicaltest_jas.di.module.MainActivityModule
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EActivity
import org.androidannotations.annotations.ViewById

@EActivity(R.layout.activity_main)
open class MainActivity : AppCompatActivity() {

    // ==============================
    // region ViewByID
    // ==============================

    @ViewById(R.id.toolbar)
    protected lateinit var toolbar: Toolbar

    // endregion

    // ==============================
    // region Activity
    // ==============================

    @AfterViews
    protected fun afterViews() {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        }


        injectDependency()
    }

    // endregion

    // ==============================
    // region Dagger
    // ==============================

    private fun injectDependency() {
        val activityComponent = DaggerMainActivityComponent.builder()
            .mainActivityModule(MainActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    // endregion

}