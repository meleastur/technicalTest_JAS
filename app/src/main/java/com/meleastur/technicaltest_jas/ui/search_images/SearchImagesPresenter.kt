package com.meleastur.technicaltest_jas.ui.search_images

import android.text.TextUtils
import com.meleastur.technicaltest_jas.api.ApiFlikrServiceInterface
import com.meleastur.technicaltest_jas.model.SearchImage
import com.meleastur.technicaltest_jas.model.flikrapi.photo_info.PhotoInfoResponse
import com.meleastur.technicaltest_jas.model.flikrapi.search_images.ImagesResponse
import com.meleastur.technicaltest_jas.util.Constants.Companion.API_KEY
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchImagesPresenter : SearchImagesContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: ApiFlikrServiceInterface = ApiFlikrServiceInterface.create()
    private lateinit var view: SearchImagesContract.View
    var searchImageList = ArrayList<SearchImage>()

    // ==============================
    // region  SearchImagesContract.Presenter
    // ==============================

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: SearchImagesContract.View) {
        this.view = view
    }

    override fun searchImageByText(text: String) {
        searchImageList.clear()
        var subscribe = api.searchPhotos(API_KEY, text).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ imageResponse: ImagesResponse? ->
                view.hideEmptyData()
                getIdToPhotoInfo(imageResponse!!)
            }, { error ->
                view.showProgress(false)
                view.showEmptyDataError(error.localizedMessage)
                view.showErrorMessage(error.localizedMessage)
            })

        subscriptions.add(subscribe)
    }

    override fun getPhotoInfo(
        photoId: String,
        urlThumbnail: String,
        title: String,
        isFinished: Boolean
    ) {
        var subscribe = api.getPhotoInfo(API_KEY, photoId).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ photoInfoResponse: PhotoInfoResponse? ->
                if (isFinished) {
                    view.showProgress(false)
                    view.loadDataSuccess(searchImageList)
                } else {
                    getSearchImages(photoInfoResponse!!, urlThumbnail, title)
                }
            }, { error ->
                view.showProgress(false)
                view.showEmptyDataError(error.localizedMessage)
                view.showErrorMessage(error.localizedMessage)
            })

        subscriptions.add(subscribe)
    }

    // endregion

    // ==============================
    // region Private functions
    // ==============================

    private fun getIdToPhotoInfo(imageResponse: ImagesResponse) {
        for (image in imageResponse.photos.photos) {
            try {
                getPhotoInfo(image.id, image.url_z, image.title, false)
            } catch (e: Exception) {
            }
        }
        getPhotoInfo("", "", "", true)
    }

    private fun getSearchImages(
        photoInfoResponse: PhotoInfoResponse,
        urlThumbnail: String,
        title: String
    ) {
        var searchImage = SearchImage()
        searchImage.id = photoInfoResponse.photo.id
        searchImage.author = photoInfoResponse.photo.owner.username
        if (!TextUtils.isEmpty(photoInfoResponse.photo.owner.realname)) {
            searchImage.author =
                searchImage.author + " (" + photoInfoResponse.photo.owner.realname + ")"
        }
        searchImage.date = photoInfoResponse.photo.dates.taken
        searchImage.thumbnailURL = urlThumbnail
        searchImage.title = title

        searchImage.description = photoInfoResponse.photo.description.content

        searchImageList.add(searchImage)
    }

    // endregion

}