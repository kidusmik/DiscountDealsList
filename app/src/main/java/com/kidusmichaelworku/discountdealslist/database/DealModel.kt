package com.kidusmichaelworku.discountdealslist.database

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kidusmichaelworku.discountdealslist.services.Offers

@Entity(tableName = "deals_table")
data class DealModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "lmd_id") var lmd_id: Int,
    @ColumnInfo(name = "store") val store: String? = null,
    @ColumnInfo(name = "merchant_homepage") val merchant_homepage: String? = null,
    @ColumnInfo(name = "long_offer") val long_offer: String? = null,
    @ColumnInfo(name = "title") val title: String? = null,
    @ColumnInfo(name = "description") val description: String? = null,
    @ColumnInfo(name = "code") val code: String? = null,
    @ColumnInfo(name = "terms_and_conditions") val terms_and_conditions: String? = null,
    @ColumnInfo(name = "categories") val categories: String? = null,
    @ColumnInfo(name = "featured") val featured: String? = null,
    @ColumnInfo(name = "publisher_exclusive") val publisher_exclusive: String? = null,
    @ColumnInfo(name = "url") val url: String? = null,
    @ColumnInfo(name = "smartlink") val smartlink: String? = null,
    @ColumnInfo(name = "image_url") val image_url: String? = null,
    @ColumnInfo(name = "type") val type: String? = null,
    @ColumnInfo(name = "offer") val offer: String? = null,
    @ColumnInfo(name = "offer_value") val offer_value: String? = null,
    @ColumnInfo(name = "status") val status: String? = null,
    @ColumnInfo(name = "start_date") val start_date: String? = null,
    @ColumnInfo(name = "end_date") val end_date: String? = null
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

    companion object CREATOR : Parcelable.Creator<DealModel> {
        override fun createFromParcel(parcel: Parcel): DealModel {
            return DealModel(parcel)
        }

        override fun newArray(size: Int): Array<DealModel?> {
            return arrayOfNulls(size)
        }
    }
}