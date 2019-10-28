package com.meleastur.technicaltest_jas.ui.main

import com.meleastur.technicaltest_jas.model.SearchImage
import com.meleastur.technicaltest_jas.ui.base.BaseContract

class MainContract {

    interface View: BaseContract.View {
        fun showSearchImagesFragment()
        fun showDetailImageFragment(searchImage: SearchImage)
    }

    interface Presenter: BaseContract.Presenter<MainContract.View>{
        fun showDetailImageFragment(searchImage: SearchImage)
    }
}