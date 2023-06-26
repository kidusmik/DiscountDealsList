package com.kidusmichaelworku.discountdealslist.fragment.deals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kidusmichaelworku.discountdealslist.databinding.FragmentDealsBinding
import com.kidusmichaelworku.discountdealslist.services.DealsNetwork
import com.kidusmichaelworku.discountdealslist.services.DealsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DealsFragment : Fragment() {

    private var _binding: FragmentDealsBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDealsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val dealsService = DealsNetwork.getRetrofitClient ().create (DealsService::class.java)
        val dealsViewModel = ViewModelProvider(this)[DealsViewModel::class.java]

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext())
         //Use coroutines to make the API calls in a separate thread
        CoroutineScope (Dispatchers.IO).launch {
            // Get list of deals
            val response = dealsService.getOffers()

            // Pass the response to the RecyclerView
            withContext (Dispatchers.Main) {
                val rvDealsAdapter = DealsListRecyclerAdapter(response.offers, dealsViewModel)
                binding.rvDealsList.layoutManager = layoutManager
                binding.rvDealsList.adapter = rvDealsAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}