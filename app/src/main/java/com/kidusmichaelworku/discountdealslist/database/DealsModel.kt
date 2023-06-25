package com.kidusmichaelworku.discountdealslist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "favorites_table")
data class DealsModel(
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
)