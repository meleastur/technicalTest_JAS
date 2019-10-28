package com.meleastur.technicaltest_jas.di.component

import com.meleastur.technicaltest_jas.di.module.DetailImageFragmentModule
import com.meleastur.technicaltest_jas.ui.detail_image.DetailImageFragment
import dagger.Component

@Component(modules = arrayOf(DetailImageFragmentModule::class))
interface DetailImageFragmentComponent {

    fun inject(detailImageFragment: DetailImageFragment)
}