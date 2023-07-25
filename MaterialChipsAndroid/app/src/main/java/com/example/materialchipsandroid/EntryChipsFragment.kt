package com.example.materialchipsandroid

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.materialchipsandroid.databinding.FragmentChoiceChipBinding
import com.example.materialchipsandroid.databinding.FragmentEntryChipBinding
import com.google.android.material.chip.Chip

class EntryChipsFragment : Fragment() {

    private lateinit var binding: FragmentEntryChipBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEntryChipBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.edTo.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

                if(!s.toString().isEmpty()){
                    if(s.toString().length == 1 && s.toString().last().toString() == ","){
                        binding.edTo.setText("")
                    }
                    else if(s.toString().length > 1 && s.toString().last().toString() == ","){
                        binding.edTo.setText("")
                    }
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if(!s.isNullOrEmpty()){
                    if(s.length > 1 && s.last().toString().equals(",")){
                        addChipToGroup(s.toString().replace(",",""))
                    }
                }

            }
        })
    }

    private fun addChipToGroup(person: String) {
        val chip = Chip(context)
        chip.text = person
        chip.chipIcon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_launcher_background)
        chip.isChipIconVisible = false
        chip.isCloseIconVisible = true
        // necessary to get single selection working
        chip.isClickable = true
        chip.isCheckable = false
        binding.chipGroup.addView(chip as View)
        chip.setOnCloseIconClickListener { binding.chipGroup.removeView(chip as View) }
    }


    companion object {

        @JvmStatic
        fun newInstance() = EntryChipsFragment()
    }

}