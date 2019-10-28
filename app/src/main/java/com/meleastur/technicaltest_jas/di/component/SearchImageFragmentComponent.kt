package com.meleastur.technicaltest_jas.di.component

import com.meleastur.technicaltest_jas.di.module.SearchImagesFragmentModule
import com.meleastur.technicaltest_jas.ui.search_images.SearchImagesFragment
import dagger.Component

@Component(modules = arrayOf(SearchImagesFragmentModule::class))
interface SearchImageFragmentComponent {

    fun inject(searchImagesFragment: SearchImagesFragment)
}