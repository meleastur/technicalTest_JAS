package com.meleastur.technicaltest_jas.di.component

import com.meleastur.technicaltest_jas.di.module.FragmentModule
import com.meleastur.technicaltest_jas.ui.detail_image.DetailImageFragment
import com.meleastur.technicaltest_jas.ui.search_images.SearchImagesFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(searchImagesFragment: SearchImagesFragment)

    fun inject(detailImageFragment: DetailImageFragment)
}