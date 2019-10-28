package com.meleastur.technicaltest_jas.ui.detail_image

import com.meleastur.technicaltest_jas.api.ApiFlikrServiceInterface
import io.reactivex.disposables.CompositeDisposable

class DetailImagePresenter : DetailImageContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: ApiFlikrServiceInterface = ApiFlikrServiceInterface.create()
    private lateinit var view: DetailImageContract.View

    // ==============================
    // region  DetailImageContract.Presenter
    // ==============================
    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: DetailImageContract.View) {
        this.view = view
    }

    override fun shareImageUrl(url: String) {

    }

    // endregion

    // ==============================
    // region Private functions
    // ==============================

    // endregion

}