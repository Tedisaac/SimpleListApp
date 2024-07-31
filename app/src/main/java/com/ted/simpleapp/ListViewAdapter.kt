package com.ted.simpleapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ted.simpleapp.databinding.ItemLayoutBinding

class ListViewAdapter : RecyclerView.Adapter<ListViewAdapter.ViewHolder>() {
    private var  listItems = ArrayList<ListModel>()

    class ViewHolder(val itemLayoutBinding: ItemLayoutBinding) : RecyclerView.ViewHolder(itemLayoutBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listItems[position]

        Glide.with(holder.itemView)
            .load(listItem.image)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemLayoutBinding.imageView)

        holder.itemLayoutBinding.txtItem.text = listItem.text
    }

    fun setItemList(listItems: ArrayList<ListModel>) {
        this.listItems = listItems
        notifyDataSetChanged()
    }
}