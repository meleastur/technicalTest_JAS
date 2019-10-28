package com.meleastur.technicaltest_jas.ui.search_images

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.meleastur.technicaltest_jas.R
import com.meleastur.technicaltest_jas.model.SearchImage
import java.net.URL

class SearchImagesAdapter(
    private val context: Context,
    val searchImageList: ArrayList<SearchImage>, fragment: Fragment
) : RecyclerView.Adapter<SearchImagesAdapter.ListViewHolder>() {

    private val listener: SearchImagesAdapter.onItemClickListener
    private val fragment: Fragment

    init {
        this.listener = fragment as SearchImagesAdapter.onItemClickListener
        this.fragment = fragment
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var searchImage = searchImageList[position]

        holder.title.text = searchImage.title
        holder.author.text = searchImage.author

        var url: URL? = null
        // TODO
        //  Checkear searchImage.thumbnailURL en el parseo del Presenter
        try {
            url = URL(searchImage.thumbnailURL)
            Glide.with(fragment)
                .load(url)
                .centerCrop()
                .into(holder.image)
        } catch (e: UninitializedPropertyAccessException) {
            Glide.with(fragment)
                .load(R.drawable.ic_photo)
                .centerCrop()
                .into(holder.image)
        }

        holder.layout!!.setOnClickListener {
            listener.itemDetail(searchImage.id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context)
                .inflate(com.meleastur.technicaltest_jas.R.layout.item_search_images, parent, false)
        return SearchImagesAdapter.ListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return searchImageList.size
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var layout =
            itemView.findViewById<RelativeLayout>(com.meleastur.technicaltest_jas.R.id.item_parent)
        val image =
            itemView.findViewById<ImageView>(com.meleastur.technicaltest_jas.R.id.image_thumbnail)
        val title =
            itemView.findViewById<TextView>(com.meleastur.technicaltest_jas.R.id.image_title)
        val author =
            itemView.findViewById<TextView>(com.meleastur.technicaltest_jas.R.id.image_author)
    }

    interface onItemClickListener {
        fun itemDetail(imageId: String)
    }
}