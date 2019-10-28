package com.meleastur.technicaltest_jas.model

import android.os.Parcel
import android.os.Parcelable


open class SearchImage() : Parcelable {
    var id: String = ""
    var thumbnailURL: String = ""
    var title: String = ""
    var author: String = ""
    var date: String = ""
    var description: String = ""

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()!!
        thumbnailURL = parcel.readString()!!
        title = parcel.readString()!!
        author = parcel.readString()!!
        date = parcel.readString()!!
        description = parcel.readString()!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(thumbnailURL)
        parcel.writeString(title)
        parcel.writeString(author)
        parcel.writeString(date)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SearchImage> {
        override fun createFromParcel(parcel: Parcel): SearchImage {
            return SearchImage(parcel)
        }

        override fun newArray(size: Int): Array<SearchImage?> {
            return arrayOfNulls(size)
        }
    }
}
