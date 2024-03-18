package com.example.navigationcomponent.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationcomponent.Model.Products
import com.example.navigationcomponent.databinding.LayoutProductlistBinding
import com.squareup.picasso.Picasso

class productAdapter (
    private val itemclict:ItemClickListener,
    private val mList: List<Products>

) : RecyclerView.Adapter<productAdapter.ViewHolder>()
{


    interface ItemClickListener {
        fun onClick(position: Int, value: String?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutProductlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.binding.tvProductname.text = item.title
        //change
        val imageUrl: String = item.thumbnail
        Picasso.get().load(imageUrl).into(holder.binding.tvImage)

        holder.binding.root.setOnClickListener {
            itemclict.onClick(position,item.title)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(val binding: LayoutProductlistBinding) : RecyclerView.ViewHolder(binding.root)
}