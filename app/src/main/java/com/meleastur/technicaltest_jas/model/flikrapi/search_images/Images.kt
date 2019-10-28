package com.meleastur.technicaltest_jas.model.flikrapi.search_images

import com.google.gson.annotations.SerializedName

open class Images {
    var page: Int = 0

    @SerializedName("perpage")
    var photoCountPerPage: Int = 0

    var total: Int = 0

    @SerializedName("photo")
    lateinit var photos: List<Image>
}
