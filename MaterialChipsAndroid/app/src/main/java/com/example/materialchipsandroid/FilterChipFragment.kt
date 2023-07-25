package com.example.materialchipsandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.materialchipsandroid.databinding.FragmentFilterChipBinding
import com.google.android.material.chip.Chip

class FilterChipFragment : Fragment() {

    private lateinit var binding: FragmentFilterChipBinding

    var adapter: FilterChipListAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFilterChipBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chipGroupFilter.setOnCheckedChangeListener { group, checkedId ->

            val chip: Chip? = group.findViewById(checkedId)

            chip?.let {chipView ->
                val predicate: (Items) -> Boolean = {item->
                    item.category == chipView.text
                }
                val filter = prepareData().filter(predicate)
                adapter?.setData(filter)
            } ?: kotlin.run {
                adapter?.setData(prepareData())
            }
        }

        adapter = FilterChipListAdapter()
        binding.recyclerviewFilter.layoutManager = LinearLayoutManager(context)
        binding.recyclerviewFilter.adapter = adapter
        adapter?.setData(prepareData())

    }

    fun updateData(view: View){
        val chip = view as Chip

        val predicate: (Items) -> Boolean = {
            it.category == chip.text
        }
        val filter = prepareData().filter(predicate)
        adapter?.setData(filter)
    }

    fun prepareData(): MutableList<Items> {
        val data = mutableListOf<Items>()
        data.add(Items("Food 1","Fast Delivery"))
        data.add(Items("Food 2","Pickup"))
        data.add(Items("Food 3","Best Offer"))
        data.add(Items("Food 4","Fast Selling"))
        data.add(Items("Food 5","Fast Delivery"))
        data.add(Items("Food 6","Pickup"))
        data.add(Items("Food 7","Fast Delivery"))
        data.add(Items("Food 8","Pickup"))
        return data
    }

    companion object {

        @JvmStatic
        fun newInstance() = FilterChipFragment()
    }

}