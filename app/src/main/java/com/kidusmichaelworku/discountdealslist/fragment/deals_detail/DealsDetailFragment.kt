package com.kidusmichaelworku.discountdealslist.fragment.deals_detail

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kidusmichaelworku.discountdealslist.database.DealModel
import com.kidusmichaelworku.discountdealslist.database.FavoritesModel
import com.kidusmichaelworku.discountdealslist.databinding.FragmentDealsDetailBinding

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

        val offer: DealModel? = DealsDetailFragmentArgs.fromBundle(requireArguments()).offersModel
        val favorites: FavoritesModel? =
            DealsDetailFragmentArgs.fromBundle(requireArguments()).favoritesModel

        var imageURL: String? = null
        var title: String? = null
        var description: String? = null
        var originalPrice: String? = null
        var discountedPrice: String? = null
        var expiryDate: String? = null
        var termsAndConditions: String? = null

        /** This checks whether the argument passed is from Deals fragment or Favorites fragment **/
        if (offer != null) {
            imageURL = offer.image_url
            title = offer.title ?: "N/A"
            description = offer.description ?: "N/A"
            originalPrice = offer.long_offer ?: "N/A"
            discountedPrice = offer.offer_value ?: "N/A"
            expiryDate = offer.end_date ?: "N/A"
            termsAndConditions = offer.terms_and_conditions ?: "N/A"
        } else if (favorites != null) {
            imageURL = favorites.image_url
            title = favorites.title ?: "N/A"
            description = favorites.description ?: "N/A"
            originalPrice = favorites.long_offer ?: "N/A"
            discountedPrice = favorites.offer_value ?: "N/A"
            expiryDate = favorites.end_date ?: "N/A"
            termsAndConditions = favorites.terms_and_conditions ?: "N/A"
        }

        Glide.with(requireContext())
            .load(imageURL)
            .into(binding.ivDealInfo)

        binding.tvTitleDealInfo.text = Html.fromHtml(title, Html.FROM_HTML_MODE_COMPACT)
        binding.tvDescriptionDealInfo.text = Html.fromHtml(description, Html.FROM_HTML_MODE_COMPACT)
        binding.tvExpiryDateDealInfo.text = Html.fromHtml(expiryDate, Html.FROM_HTML_MODE_COMPACT)
        binding.tvDiscountedPriceDealInfo.text =
            Html.fromHtml(discountedPrice, Html.FROM_HTML_MODE_COMPACT)
        binding.tvOriginalPriceDealInfo.text =
            Html.fromHtml(originalPrice, Html.FROM_HTML_MODE_COMPACT)
        binding.tvTermsAndConsDealInfo.text =
            Html.fromHtml(termsAndConditions, Html.FROM_HTML_MODE_COMPACT)

    }
}