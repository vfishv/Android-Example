package com.example.materialchipsandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.materialchipsandroid.databinding.LayoutFilterChipAdapterBinding

class FilterChipListAdapter : RecyclerView.Adapter<FilterViewHolder>() {

    var items = mutableListOf<Items>()


    fun setData(items: List<Items>){
        this.items = items as MutableList<Items>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val binding = LayoutFilterChipAdapterBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        //val view  = LayoutInflater.from(parent.context).inflate(R.layout.layout_filter_chip_adapter,parent, false)
        return FilterViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {

        val data = items[position]
        holder.textTitle.text = data.title
        holder.textCategory.text = data.category
    }
}

class FilterViewHolder(binding: LayoutFilterChipAdapterBinding) : RecyclerView.ViewHolder(binding.root) {

    val textTitle = binding.textTitle
    val textCategory = binding.textCategory

}
