package com.kidusmichaelworku.discountdealslist.fragment.deals

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kidusmichaelworku.discountdealslist.database.DealsModel
import com.kidusmichaelworku.discountdealslist.databinding.LiDealsListBinding
import com.kidusmichaelworku.discountdealslist.services.Offers

class DealsListRecyclerAdapter(private val offersList: List<Offers>, private val viewModel: DealsViewModel)
    : RecyclerView.Adapter<DealsListRecyclerAdapter.DealsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealsListViewHolder {
        val binding = LiDealsListBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return DealsListViewHolder(binding)
    }

    override fun getItemCount() = offersList.size

    override fun onBindViewHolder(holder: DealsListViewHolder, position: Int) {
        with(holder){
            with(offersList[position]) {
                binding.tvDescriptionDeals.text = offersList[position].description
                binding.tvTitleDeals.text = offersList[position].title
                binding.tvCouponCodeDeals.text = offersList[position].code
                binding.tvDiscountedPriceDeals.text = offersList[position].offer_value

                //val hours = "$hours learning hours, $country"
                //binding.topLearnerTime.text = hours
                Glide.with(holder.itemView.context)
                    .load(offersList[position].image_url)
                    .into(binding.ivDeals)

                binding.imageButton.setOnClickListener {
                    val addedDeal = DealsModel(
                        lmd_id = offersList[position].lmd_id,
                        description = offersList[position].description,
                        title = offersList[position].title,
                        code = offersList[position].code,
                        offer_value = offersList[position].offer_value
                    )

                    viewModel.addDeal(addedDeal)
                    Toast.makeText(holder.itemView.context, "Added to favorites",
                        Toast.LENGTH_SHORT).show()
                }

                holder.itemView.setOnClickListener {
                    //it.findNavController().navigate()
                    Toast.makeText(holder.itemView.context, "Clicked an Item",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    inner class DealsListViewHolder(val binding: LiDealsListBinding)
        :RecyclerView.ViewHolder(binding.root)

}