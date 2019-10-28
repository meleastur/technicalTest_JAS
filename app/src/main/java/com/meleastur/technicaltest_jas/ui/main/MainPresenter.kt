package com.meleastur.technicaltest_jas.ui.main
import com.meleastur.technicaltest_jas.model.SearchImage
import io.reactivex.disposables.CompositeDisposable

class MainPresenter: MainContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainContract.View

    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showSearchImagesFragment()
    }

    override fun showDetailImageFragment(searchImage: SearchImage) {
        view.showDetailImageFragment(searchImage)
    }
}