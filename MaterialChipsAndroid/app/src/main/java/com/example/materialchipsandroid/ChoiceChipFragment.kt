package com.example.materialchipsandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.materialchipsandroid.databinding.FragmentChoiceChipBinding
import com.google.android.material.chip.Chip

class ChoiceChipFragment : Fragment() {

    private lateinit var binding: FragmentChoiceChipBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentChoiceChipBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.chipGroupChoice.setOnCheckedChangeListener { group, checkedId ->

            val chip: Chip? = group.findViewById(checkedId)

            chip?.let {chipView ->
                Toast.makeText(context, chip.text, Toast.LENGTH_SHORT).show()
            } ?: kotlin.run {
            }
        }
    }


}
