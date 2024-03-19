package com.example.navigationcomponent

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationcomponent.Adapter.productAdapter
import com.example.navigationcomponent.Model.Products
import com.example.navigationcomponent.Repository.MainRepository
import com.example.navigationcomponent.Repository.MainRepository.Productlist
import com.example.navigationcomponent.Roomdatabase.databaseViewmodel
import com.example.navigationcomponent.ViewModel.MainViewModel
import com.example.navigationcomponent.databinding.FragmentHomeBinding


class HomeFragment() : Fragment() , productAdapter.ItemClickListener {
    private lateinit var binding: FragmentHomeBinding
var productlist= mutableListOf<Products>()
    private lateinit var rvAdapter: productAdapter
    val viewModel: MainViewModel by viewModels()
    val databaseViewmodel:databaseViewmodel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentHomeBinding.inflate(inflater,container,false)


        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext())

        // pass it to rvLists layoutManager
        binding.productlist.setLayoutManager(layoutManager)

        // initialize the adapter,

        setOperation()
        return binding.root

    }

    private fun setOperation() {
      binding.btngetdata.setOnClickListener {
          viewModel.getproductdata()
      }
        MainRepository.Productlist.observe(requireActivity(), Observer { productList ->

            Log.e("printdata",""+productList)
            productlist= productList.products.toMutableList()
            // and pass the required argument
            rvAdapter = productAdapter(this,productlist)

            // attach adapter to the recycler view
            binding.productlist.adapter = rvAdapter

           databaseViewmodel.insertdata(requireContext(),productlist)


        })

        binding.btngetdata2.setOnClickListener {
            databaseViewmodel.getalldata(requireContext())?.observe(requireActivity(), Observer { notifications ->
                // Update your list or perform any other action with the new data
                Log.e("data",""+notifications)

            })
        }



    }




    override fun onClick(position: Int, value: String?) {
       Log.e("value",""+value)
    }


}