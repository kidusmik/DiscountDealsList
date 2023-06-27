package com.kidusmichaelworku.discountdealslist.fragment.favorites

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kidusmichaelworku.discountdealslist.R
import com.kidusmichaelworku.discountdealslist.database.FavoritesModel
import com.kidusmichaelworku.discountdealslist.databinding.LiDealsListBinding

class FavoritesListRecyclerAdapter(
    private val dealsList: List<FavoritesModel>,
    private val viewModel: FavoritesViewModel
) : RecyclerView.Adapter<FavoritesListRecyclerAdapter.FavoritesListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesListViewHolder {
        val binding = LiDealsListBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoritesListViewHolder(binding)
    }

    override fun getItemCount() = dealsList.size

    override fun onBindViewHolder(holder: FavoritesListViewHolder, position: Int) {
        with(holder) {
            with(dealsList[position]) {
                val title = dealsList[position].title ?: "N/A"
                val description = dealsList[position].description ?: "N/A"
                val coupon = dealsList[position].code ?: "N/A"
                val discountedPrice = dealsList[position].offer_value ?: "N/A"

                binding.imageButton.setImageResource(R.drawable.baseline_delete_forever_24)

                /** Used [Html] because the data fetched contains HTML contents **/
                binding.tvDescriptionDeals.text =
                    Html.fromHtml(description, Html.FROM_HTML_MODE_COMPACT)
                binding.tvTitleDeals.text = Html.fromHtml(title, Html.FROM_HTML_MODE_COMPACT)
                binding.tvCouponCodeDeals.text = Html.fromHtml(coupon, Html.FROM_HTML_MODE_COMPACT)
                binding.tvDiscountedPriceDeals.text =
                    Html.fromHtml(discountedPrice, Html.FROM_HTML_MODE_COMPACT)

                Glide.with(holder.itemView.context)
                    .load(dealsList[position].image_url)
                    .into(binding.ivDeals)

                holder.itemView.setOnClickListener {
                    val action: NavDirections =
                        FavoritesFragmentDirections.actionNavigationFavoritesToDealsDetailFragment(
                            favoritesModel = dealsList[position]
                        )
                    Navigation.findNavController(it).navigate(action)
                }
                binding.imageButton.setOnClickListener {
                    viewModel.deleteDeal(dealsList[position])
                    Toast.makeText(
                        holder.itemView.context, "Deal deleted",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    inner class FavoritesListViewHolder(val binding: LiDealsListBinding) :
        RecyclerView.ViewHolder(binding.root)

}