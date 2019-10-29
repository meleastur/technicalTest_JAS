package com.meleastur.technicaltest_jas.di.module

import com.meleastur.technicaltest_jas.ui.detail_image.DetailImageContract
import com.meleastur.technicaltest_jas.ui.detail_image.DetailImagePresenter
import com.meleastur.technicaltest_jas.ui.search_images.SearchImagesContract
import com.meleastur.technicaltest_jas.ui.search_images.SearchImagesPresenter
import dagger.Module
import dagger.Provides


@Module
class FragmentModule {

    @Provides
    fun provideSearchImagesPresenter(): SearchImagesContract.Presenter {
        return SearchImagesPresenter()
    }

    @Provides
    fun provideDetailImagePresenter(): DetailImageContract.Presenter {
        return DetailImagePresenter()
    }
}