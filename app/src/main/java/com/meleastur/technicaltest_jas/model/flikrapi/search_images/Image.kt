package com.meleastur.technicaltest_jas.model.flikrapi.search_images

import com.google.gson.annotations.SerializedName

open class Image {
    lateinit var id: String
    lateinit var title: String

    @SerializedName("url_l")
    lateinit var url_l: String

    @SerializedName("url_o")
    lateinit var url_o: String

    @SerializedName("url_c")
    lateinit var url_c: String

    @SerializedName("url_z")
    lateinit var url_z: String

    @SerializedName("url_n")
    lateinit var url_n: String

    @SerializedName("url_m")
    lateinit var url_m: String

    @SerializedName("url_q")
    lateinit var url_q: String

    @SerializedName("url_s")
    lateinit var url_s: String

    @SerializedName("url_t")
    lateinit var url_t: String

    @SerializedName("url_sq")
    lateinit var url_sq: String
}
