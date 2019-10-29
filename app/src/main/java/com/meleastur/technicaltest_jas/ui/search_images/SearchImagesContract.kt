package com.meleastur.technicaltest_jas.ui.search_images

import com.meleastur.technicaltest_jas.model.SearchImage
import com.meleastur.technicaltest_jas.ui.base.BaseContract

class SearchImagesContract {

    interface View: BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun showEmptyDataError(error:String)
        fun hideEmptyData()
        fun loadDataSuccess(searchImage: ArrayList<SearchImage>, isToAddMore: Boolean)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun searchImageByText(text: String)
        fun searchImageByText(text: String, page: Int)
        fun getPhotoInfo(photoId: String, urlThumbnail: String, title: String, page: Int, perPage: Int, isFinished: Boolean, isToAddMore: Boolean)
    }
}