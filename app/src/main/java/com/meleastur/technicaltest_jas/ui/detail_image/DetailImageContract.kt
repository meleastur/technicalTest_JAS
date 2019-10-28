package com.meleastur.technicaltest_jas.ui.detail_image

import com.meleastur.technicaltest_jas.model.SearchImage
import com.meleastur.technicaltest_jas.ui.base.BaseContract

class DetailImageContract {

    interface View: BaseContract.View {
        fun shareImageSuccess(searchImage: ArrayList<SearchImage>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun shareImageUrl(url: String)
    }
}