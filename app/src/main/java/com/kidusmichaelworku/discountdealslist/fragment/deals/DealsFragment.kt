package com.kidusmichaelworku.discountdealslist.fragment.deals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kidusmichaelworku.discountdealslist.R
import com.kidusmichaelworku.discountdealslist.databinding.FragmentDealsBinding
import com.kidusmichaelworku.discountdealslist.services.Deals
import com.kidusmichaelworku.discountdealslist.services.DealsNetwork
import com.kidusmichaelworku.discountdealslist.services.DealsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DealsFragment : Fragment() {

    private var _binding: FragmentDealsBinding? = null
//
//    // This property is only valid between onCreateView and
//    // onDestroyView.

    private val binding get() = _binding!!
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        //val dealsViewModel =
            //ViewModelProvider(this)[DealsViewModel::class.java]

        _binding = FragmentDealsBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        dealsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val dealsService = DealsNetwork.getRetrofitClient ().create (DealsService::class.java)

        //val rvDeals: RecyclerView = binding.rvDealsList
        val dealsViewModel =
            ViewModelProvider(this)[DealsViewModel::class.java]

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext())

        val deal1 = Deals(1275984,
            "timesprime.com","https://www.timesprime.com/",
            "Times Prime Membership @ just &#8377;1199",
            "Times Prime Membership",
            "Get it at just &#8377;1199","","",
            "Entertainment,Entertainment Subscription","No","N",
            "https://www.timesprime.com/",
            "https://smartlink.linkmydeals.com/?account_id=18950&network=&url=https%3A%2F%2Fwww.timesprime.com%2F",
            "https://static.timesprime.com/2x/youtube-logo-box.png","Deal","Offer","Hot Offer","new",
            "2023-06-19","2023-06-27")

        val deal2 = Deals(12345678, "toliday.in","https://www.toliday.in/","Get Flat &#8377;300 discount on Flight and Hotel Booking","Get &#8377;300 OFF","This voucher is valid on Flight and Hotel Booking","FLAT300","","Travel,Domestic Flights,International Flights,Hotels","No","N","https://toliday.in/","https://smartlink.linkmydeals.com/?account_id=18950&network=&url=https%3A%2F%2Ftoliday.in%2F","https://toliday.in/coupon-code/10.png","Code","Price-Off","&#8377;300","new","2023-02-01","2023-06-25")

        val dealList: List<Deals> = listOf(deal1, deal2)

        val rvDealsAdapter = DealsListRecyclerAdapter(dealList, dealsViewModel)

        binding.rvDealsList.layoutManager = layoutManager
        binding.rvDealsList.adapter = rvDealsAdapter


// Use coroutines to make the API calls in a separate thread
//        CoroutineScope (Dispatchers.IO).launch {
//            // Get list of deals
//            val deals = dealsService.getDeals ()
//
//            // Do something with the results on the main thread
//            withContext (Dispatchers.Main) {
//                val title =
//            }
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}