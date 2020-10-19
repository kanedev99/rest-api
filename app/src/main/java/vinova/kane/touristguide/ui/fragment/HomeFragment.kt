package vinova.kane.touristguide.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import vinova.kane.touristguide.R
import vinova.kane.touristguide.adapter.PlaceAdapter
import vinova.kane.touristguide.databinding.FragmentHomeBinding
import vinova.kane.touristguide.model.Place
import vinova.kane.touristguide.viewmodel.HomeViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: PlaceAdapter
    private lateinit var viewModel: HomeViewModel
    private val listPlaces = ArrayList<Place>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        initData()

        return binding.root
    }

    private fun initData(){
        viewModel.getPlaces()

        viewModel.placesResult.observe(viewLifecycleOwner, Observer {
            Log.d("HomeFragment", "Message: $it")
            listPlaces.addAll(it)
            adapter.notifyDataSetChanged()
        })

        adapter = PlaceAdapter(listPlaces)
        binding.rvListPlaces.adapter = adapter
    }

}