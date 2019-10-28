package com.meleastur.technicaltest_jas.ui.main

import com.meleastur.technicaltest_jas.ui.base.BaseContract

class MainContract {

    interface View: BaseContract.View {
        fun showSearchImagesFragment()
    }

    interface Presenter: BaseContract.Presenter<MainContract.View>
}