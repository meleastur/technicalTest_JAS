package com.meleastur.technicaltest_jas.ui.main

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.meleastur.technicaltest_jas.R
import com.meleastur.technicaltest_jas.di.component.DaggerMainActivityComponent
import com.meleastur.technicaltest_jas.di.module.MainActivityModule
import com.meleastur.technicaltest_jas.ui.search_images.SearchImagesFragment
import com.meleastur.technicaltest_jas.util.Constants.Companion.SEARCH_IMAGES_FRAG
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EActivity
import org.androidannotations.annotations.ViewById
import javax.inject.Inject

@EActivity(R.layout.activity_main)
open class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    // ==============================
    // region Views
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
        presenter.attach(this)
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

    // ==============================
    // region MainContract.View
    // ==============================
    @AfterViews
    override fun showSearchImagesFragment() {
        supportFragmentManager.beginTransaction()
            .disallowAddToBackStack()
            .replace(R.id.frameLayout, SearchImagesFragment().newInstance(), SEARCH_IMAGES_FRAG)
            .commit()
    }

    // endregion

}