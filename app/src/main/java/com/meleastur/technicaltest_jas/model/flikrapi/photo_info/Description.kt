package com.meleastur.technicaltest_jas.model.flikrapi.photo_info

import com.google.gson.annotations.SerializedName

open class Description {
    @SerializedName("_content")
    lateinit var content: String
}
