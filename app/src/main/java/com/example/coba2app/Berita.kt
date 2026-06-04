package com.example.coba2app

import android.os.Parcel
import android.os.Parcelable

data class Berita(
    val judul: String,
    val gambar: Int,
    val diskripsi: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(judul)
        parcel.writeInt(gambar)
        parcel.writeString(diskripsi)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Berita> {
        override fun createFromParcel(parcel: Parcel): Berita {
            return Berita(parcel)
        }

        override fun newArray(size: Int): Array<Berita?> {
            return arrayOfNulls(size)
        }
    }
}