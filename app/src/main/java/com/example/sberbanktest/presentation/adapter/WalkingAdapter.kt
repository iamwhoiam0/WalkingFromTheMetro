package com.example.sberbanktest.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sberbanktest.data.entities.Data
import com.example.sberbanktest.data.entities.WalkListData
import com.example.sberbanktest.databinding.ItemStrollBinding
import com.example.sberbanktest.utils.MyHandler

class WalkingAdapter(private var walkListData: WalkListData): RecyclerView.Adapter<WalkingAdapter.WalkingViewHolder>() {


    class WalkingViewHolder(val binding: ItemStrollBinding): RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<Data>(){
        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalkingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemStrollBinding.inflate(layoutInflater)

        val myHandler = MyHandler()
        binding.handler = myHandler

        return WalkingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WalkingViewHolder, position: Int) {
        holder.binding.data = walkListData.data[position]
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return walkListData.data.size
    }
}