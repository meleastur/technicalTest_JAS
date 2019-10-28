package com.meleastur.technicaltest_jas.ui.detail_image

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.meleastur.technicaltest_jas.R
import com.meleastur.technicaltest_jas.di.component.DaggerDetailImageFragmentComponent
import com.meleastur.technicaltest_jas.di.module.DetailImageFragmentModule
import com.meleastur.technicaltest_jas.model.SearchImage
import org.androidannotations.annotations.EFragment
import org.androidannotations.annotations.FragmentArg
import org.androidannotations.annotations.ViewById
import java.net.URL
import javax.inject.Inject

@EFragment(R.layout.fragment_detail_image)
open class DetailImageFragment : Fragment(), DetailImageContract.View {

    @Inject
    lateinit var presenter: DetailImageContract.Presenter

    // ==============================
    // region FragmentArg
    // ==============================
    @FragmentArg
    protected lateinit var searchImage: SearchImage

    // endRegion

    // ==============================
    // region Views
    // ==============================
    @ViewById(R.id.image_thumbnail)
    protected lateinit var thumbnailImage : ImageView

    @ViewById(R.id.image_author)
    protected lateinit var author : TextView

    @ViewById(R.id.image_title)
    protected lateinit var title : TextView

    @ViewById(R.id.image_date)
    protected lateinit var date : TextView

    @ViewById(R.id.image_description)
    protected lateinit var description : TextView

    // endregion

    // ==============================
    // region vars
    // ==============================

    // endregion

    // ==============================
    // region Fragment
    // ==============================

    fun newInstance(searchImage: SearchImage): DetailImageFragment {
        return DetailImageFragment_
            .builder().searchImage(searchImage)
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectDependency()

        presenter.attach(this)
        presenter.subscribe()
    }

    override fun onResume() {
        super.onResume()

        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    fun initViews() {
        try {
            val url = URL(searchImage.thumbnailURL)
            Glide.with(this)
                .load(url)
                .into(thumbnailImage)
        } catch (e: UninitializedPropertyAccessException) {
            Glide.with(this)
                .load(R.drawable.ic_photo)
                .into(thumbnailImage)
        }
        author.text = searchImage.author
        title.text = searchImage.title
        date.text = searchImage.date
        description.text = searchImage.description
    }


    // endregion

    // ==============================
    // region SearchImagesContract.View
    // ==============================
    override fun shareImageSuccess(searchImage: ArrayList<SearchImage>) {
    }

    // endregion

    // ==============================
    // region Dagger
    // ==============================
    private fun injectDependency() {
        val component = DaggerDetailImageFragmentComponent.builder()
            .detailImageFragmentModule(DetailImageFragmentModule())
            .build()

        component.inject(this)
    }
    // endregion
}