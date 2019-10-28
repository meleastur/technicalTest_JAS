package com.meleastur.technicaltest_jas.di.module

import com.meleastur.technicaltest_jas.ui.search_images.SearchImagesContract
import com.meleastur.technicaltest_jas.ui.search_images.SearchImagesPresenter
import dagger.Module
import dagger.Provides


@Module
class SearchImagesFragmentModule {

    @Provides
    fun provideSearchImagesPresenter(): SearchImagesContract.Presenter {
        return SearchImagesPresenter()
    }
}