package com.meleastur.technicaltest_jas.ui.detail_image

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.meleastur.technicaltest_jas.R
import com.meleastur.technicaltest_jas.di.component.DaggerDetailImageFragmentComponent
import com.meleastur.technicaltest_jas.di.module.DetailImageFragmentModule
import com.meleastur.technicaltest_jas.model.SearchImage
import org.androidannotations.annotations.EFragment
import javax.inject.Inject

@EFragment(R.layout.fragment_detail_image)
open class DetailImageFragment : Fragment(), DetailImageContract.View {

    @Inject
    lateinit var presenter: DetailImageContract.Presenter

    // ==============================
    // region Views
    // ==============================

    // endregion

    // ==============================
    // region vars
    // ==============================

    // endregion

    // ==============================
    // region Fragment
    // ==============================

    fun newInstance(): DetailImageFragment {
        return DetailImageFragment_
            .builder()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectDependency()

        presenter.attach(this)
        presenter.subscribe()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    // endregion

    // ==============================
    // region SearchImagesContract.View
    // ==============================
    override fun shareImageSuccess(searchImage: ArrayList<SearchImage>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // endregion

    // ==============================
    // region Dagger
    // ==============================
    private fun injectDependency() {
        val listComponent = DaggerDetailImageFragmentComponent.builder()
            .detailImageFragmentModule(DetailImageFragmentModule())
            .build()

        listComponent.inject(this)
    }
    // endregion
}