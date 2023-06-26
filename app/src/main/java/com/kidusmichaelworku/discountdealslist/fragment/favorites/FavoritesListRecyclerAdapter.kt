package com.kidusmichaelworku.discountdealslist.fragment.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kidusmichaelworku.discountdealslist.R
import com.kidusmichaelworku.discountdealslist.database.FavoritesModel
import com.kidusmichaelworku.discountdealslist.databinding.LiDealsListBinding
import com.kidusmichaelworku.discountdealslist.fragment.deals.DealsViewModel

class FavoritesListRecyclerAdapter(private val dealsList: List<FavoritesModel>, private val viewModel: FavoritesViewModel)
    : RecyclerView.Adapter<FavoritesListRecyclerAdapter.FavoritesListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesListViewHolder {
        val binding = LiDealsListBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoritesListViewHolder(binding)
    }

    override fun getItemCount() = dealsList.size

    override fun onBindViewHolder(holder: FavoritesListViewHolder, position: Int) {
        with(holder){
            with(dealsList[position]) {
                binding.tvDescriptionDeals.text = dealsList[position].description
                binding.tvTitleDeals.text = dealsList[position].title
                binding.tvCouponCodeDeals.text = dealsList[position].code
                binding.tvDiscountedPriceDeals.text = dealsList[position].offer_value
                binding.imageButton.setImageResource(R.drawable.baseline_delete_forever_24)

                Glide.with(holder.itemView.context)
                    .load(dealsList[position].image_url)
                    .into(binding.ivDeals)

                holder.itemView.setOnClickListener {
                    val action: NavDirections = FavoritesFragmentDirections.actionNavigationFavoritesToDealsDetailFragment(favoritesModel =  dealsList[position])
                    Navigation.findNavController(it).navigate(action)
                }
                binding.imageButton.setOnClickListener {
                    viewModel.deleteDeal(dealsList[position])
                }
            }
        }
    }

    inner class FavoritesListViewHolder(val binding: LiDealsListBinding)
        :RecyclerView.ViewHolder(binding.root)

}