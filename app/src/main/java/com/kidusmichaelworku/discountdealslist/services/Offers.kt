package com.kidusmichaelworku.discountdealslist.services

import android.os.Parcel
import android.os.Parcelable

data class Offers (
    val lmd_id: Int,
    val store: String?,
    val merchant_homepage: String?,
    val long_offer: String?,
    val title: String?,
    val description: String?,
    val code: String?,
    val terms_and_conditions: String?,
    val categories: String?,
    val featured: String?,
    val publisher_exclusive: String?,
    val url: String?,
    val smartlink: String?,
    val image_url: String?,
    val type: String?,
    val offer: String?,
    val offer_value: String?,
    val status: String?,
    val start_date: String?,
    val end_date: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(lmd_id)
        parcel.writeString(store)
        parcel.writeString(merchant_homepage)
        parcel.writeString(long_offer)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(code)
        parcel.writeString(terms_and_conditions)
        parcel.writeString(categories)
        parcel.writeString(featured)
        parcel.writeString(publisher_exclusive)
        parcel.writeString(url)
        parcel.writeString(smartlink)
        parcel.writeString(image_url)
        parcel.writeString(type)
        parcel.writeString(offer)
        parcel.writeString(offer_value)
        parcel.writeString(status)
        parcel.writeString(start_date)
        parcel.writeString(end_date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Offers> {
        override fun createFromParcel(parcel: Parcel): Offers {
            return Offers(parcel)
        }

        override fun newArray(size: Int): Array<Offers?> {
            return arrayOfNulls(size)
        }
    }
}