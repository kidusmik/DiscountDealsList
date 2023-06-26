package com.kidusmichaelworku.discountdealslist.fragment.deals_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.kidusmichaelworku.discountdealslist.database.DealModel
import com.kidusmichaelworku.discountdealslist.database.FavoritesModel
import com.kidusmichaelworku.discountdealslist.databinding.FragmentDealsDetailBinding
import com.kidusmichaelworku.discountdealslist.services.Offers

class DealsDetailFragment : Fragment() {
    private var _binding: FragmentDealsDetailBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDealsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val dealDetailViewModel = ViewModelProvider(this)[DealDetailViewModel::class.java]

        requireActivity().title = "Offer Details"
        val offer: DealModel? = DealsDetailFragmentArgs.fromBundle(requireArguments()).offersModel
        val favorites: FavoritesModel? = DealsDetailFragmentArgs.fromBundle(requireArguments()).favoritesModel
        //val lmsID: Int = DealsDetailFragmentArgs.fromBundle(requireArguments()).lmsID

        var imageURL: String? = null
        var title: String? = null
        var description: String? = null
        var original_price: String? = null
        var discounted_price: String? = null
        var expiry_date: String? = null
        var terms_and_conditions: String? = null

        if (offer != null){
            imageURL = offer.image_url
            title = offer.title
            description = offer.description
            original_price = offer.long_offer
            discounted_price = offer.offer_value
            expiry_date = offer.end_date
            terms_and_conditions = offer.terms_and_conditions
        }
        else if (favorites != null) {
            imageURL = favorites.image_url
            title = favorites.title
            description = favorites.description
            original_price = favorites.long_offer
            discounted_price = favorites.offer_value
            expiry_date = favorites.end_date
            terms_and_conditions = favorites.terms_and_conditions
            }

        Glide.with(requireContext())
            .load(imageURL)
            .into(binding.ivDealInfo)

        binding.tvTitleDealInfo.text = title
        binding.tvDescriptionDealInfo.text = description
        binding.tvExpiryDateDealInfo.text = expiry_date
        binding.tvDiscountedPriceDealInfo.text = discounted_price
        binding.tvOriginalPriceDealInfo.text = original_price
        binding.tvTermsAndConsDealInfo.text = terms_and_conditions
    }
}