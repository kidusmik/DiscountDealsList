package com.kidusmichaelworku.discountdealslist.fragment.deals

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kidusmichaelworku.discountdealslist.database.DealsModel
import com.kidusmichaelworku.discountdealslist.databinding.LiDealsListBinding
import com.kidusmichaelworku.discountdealslist.services.Deals

class DealsListRecyclerAdapter(private val dealsList: List<Deals>, private val viewModel: DealsViewModel)
    : RecyclerView.Adapter<DealsListRecyclerAdapter.DealsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealsListViewHolder {
        val binding = LiDealsListBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return DealsListViewHolder(binding)
    }

    override fun getItemCount() = dealsList.size

    override fun onBindViewHolder(holder: DealsListViewHolder, position: Int) {
        with(holder){
            with(dealsList[position]) {
                binding.tvDescriptionDeals.text = dealsList[position].description
                binding.tvTitleDeals.text = dealsList[position].title
                binding.tvCouponCodeDeals.text = dealsList[position].code
                binding.tvDiscountedPriceDeals.text = dealsList[position].offer_value

                //val hours = "$hours learning hours, $country"
                //binding.topLearnerTime.text = hours
                Glide.with(holder.itemView.context)
                    .load(dealsList[position].image_url)
                    .into(binding.ivDeals)

                binding.imageButton.setOnClickListener {
                    val addedDeal = DealsModel(
                        lmd_id = dealsList[position].lmd_id,
                        description = dealsList[position].description,
                        title = dealsList[position].title,
                        code = dealsList[position].code,
                        offer_value = dealsList[position].offer_value
                    )

                    viewModel.addDeal(addedDeal)
                    Toast.makeText(holder.itemView.context, "Added to favorites",
                        Toast.LENGTH_SHORT).show()
                }

                holder.itemView.setOnClickListener {
                    Toast.makeText(holder.itemView.context, "Clicked an Item",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    inner class DealsListViewHolder(val binding: LiDealsListBinding)
        :RecyclerView.ViewHolder(binding.root)

}