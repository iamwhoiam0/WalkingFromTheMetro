package com.example.sberbanktest.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sberbanktest.data.entities.Data
import com.example.sberbanktest.data.entities.Route
import com.example.sberbanktest.databinding.ItemRouteBinding

class RouteAdapter (private var routeListData: List<Route>): RecyclerView.Adapter<RouteAdapter.RouteViewHolder>(){

    class RouteViewHolder(val binding: ItemRouteBinding): RecyclerView.ViewHolder(binding.root)

    companion object: DiffUtil.ItemCallback<Data>(){
        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RouteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRouteBinding.inflate(layoutInflater)

        return RouteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RouteViewHolder, position: Int) {
        holder.binding.route = routeListData[position]
        holder.binding.position.text = String.format("%d", position + 1)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return routeListData.size
    }


}