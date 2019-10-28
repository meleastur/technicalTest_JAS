package com.meleastur.technicaltest_jas.ui.search_images

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.meleastur.technicaltest_jas.R
import com.meleastur.technicaltest_jas.di.component.DaggerSearchImageFragmentComponent
import com.meleastur.technicaltest_jas.di.module.SearchImagesFragmentModule
import com.meleastur.technicaltest_jas.model.SearchImage
import com.meleastur.technicaltest_jas.ui.main.MainActivity
import org.androidannotations.annotations.EFragment
import org.androidannotations.annotations.OptionsMenu
import org.androidannotations.annotations.ViewById
import javax.inject.Inject

@EFragment(R.layout.fragment_search_images)
@OptionsMenu(R.menu.menu_search_images)
open class SearchImagesFragment : Fragment(), SearchImagesContract.View,
    SearchImagesAdapter.onItemClickListener,
    SearchView.OnQueryTextListener {

    @Inject
    lateinit var presenter: SearchImagesContract.Presenter

    // ==============================
    // region Views
    // ==============================

    @ViewById(R.id.progressBar)
    protected lateinit var progressBar: ProgressBar

    @ViewById(R.id.recyclerView)
    protected lateinit var recyclerView: RecyclerView

    @ViewById(R.id.text_error)
    protected lateinit var textError: TextView

    @ViewById(R.id.image_error)
    protected lateinit var imageError: ImageView

    // endregion

    // ==============================
    // region vars
    // ==============================

    lateinit var searchView: SearchView
    var queryFilterOld: String? = null
    var queryFilterSelected: String? = null

    var adapter: SearchImagesAdapter? = null

    // endregion

    // ==============================
    // region Fragment
    // ==============================

    fun newInstance(): SearchImagesFragment {
        return SearchImagesFragment_
            .builder()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectDependency()

        presenter.attach(this)
        presenter.subscribe()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    // endregion

    // ==============================
    // region SearchImagesContract.View
    // ==============================

    override fun showProgress(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun showErrorMessage(error: String) {
        Log.e("Error", error)
    }

    override fun hideEmptyData() {
        imageError.visibility = View.GONE
        textError.visibility = View.GONE
    }

    override fun showEmptyDataError(error: String) {
        imageError.visibility = View.GONE
        textError.visibility = View.GONE
        textError.text = error
    }

    override fun loadDataSuccess(searchImage: ArrayList<SearchImage>) {
        adapter = SearchImagesAdapter(activity!!, searchImage, this)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    // endregion

    // ==============================
    // region  SearchImagesAdapter.onItemClickListener
    // ==============================
    override fun itemDetail(searchImage: SearchImage) {
        (activity as MainActivity).presenter.showDetailImageFragment(searchImage)
    }

    // endregion

    // ==============================
    // region Dagger
    // ==============================
    private fun injectDependency() {
        val listComponent = DaggerSearchImageFragmentComponent.builder()
            .searchImagesFragmentModule(SearchImagesFragmentModule())
            .build()

        listComponent.inject(this)
    }
    // endregion

    // =========================================
    //  Fragment.onPrepareOptionsMenu
    // ========================================
    override fun onPrepareOptionsMenu(menu: Menu) {

        val searchItem = menu.findItem(R.id.action_search)
        searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        val activity = activity

        if (activity != null) {
            val searchManager = activity.getSystemService(Context.SEARCH_SERVICE) as SearchManager
            searchView.setSearchableInfo(searchManager.getSearchableInfo(activity.componentName))
        }

        if (!TextUtils.isEmpty(queryFilterOld)) {
            queryFilterSelected = queryFilterOld
            searchItem.expandActionView()
            searchView.setQuery(queryFilterOld, true)
        } else {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(searchView.windowToken, 0)
        }

        menu.findItem(R.id.action_search).isVisible = true
    }

    // endregion

    // ==============================
    // region SearchView.OnQueryTextListener
    // ==============================

    override fun onQueryTextSubmit(query: String?): Boolean {

        if (!TextUtils.isEmpty(query)) {
            showProgress(true)
            hideEmptyData()

            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(searchView.windowToken, 0)

            queryFilterSelected = query
            presenter.searchImageByText(queryFilterSelected!!)

            return true
        }

        return false
    }

    override fun onQueryTextChange(queryFilter: String?): Boolean {
        // Nada que hacer aqui
        return false
    }

    // endregion
}