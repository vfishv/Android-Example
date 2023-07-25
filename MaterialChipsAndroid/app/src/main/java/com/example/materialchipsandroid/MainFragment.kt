package com.example.materialchipsandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialchipsandroid.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btnEntryChip.setOnClickListener {
            replaceFragment(EntryChipsFragment.newInstance())
        }

        binding.btnFilterChip.setOnClickListener {
            replaceFragment(FilterChipFragment())
        }

        binding.btnChoiceChip.setOnClickListener {
            replaceFragment(ChoiceChipFragment())
        }

        binding.btnActionChip.setOnClickListener {
            replaceFragment(ActionChipFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        fragmentManager?.beginTransaction()?.replace(R.id.frame_container, fragment)?.addToBackStack(null)?.commit()
    }

}