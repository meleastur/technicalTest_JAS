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
    var page: Int = 0
    var perPage: Int = 0

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()!!
        thumbnailURL = parcel.readString()!!
        title = parcel.readString()!!
        author = parcel.readString()!!
        date = parcel.readString()!!
        description = parcel.readString()!!
        page = parcel.readInt()
        perPage = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(thumbnailURL)
        parcel.writeString(title)
        parcel.writeString(author)
        parcel.writeString(date)
        parcel.writeString(description)
        parcel.writeInt(page)
        parcel.writeInt(perPage)
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
