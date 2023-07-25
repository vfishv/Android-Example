package com.example.materialchipsandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.materialchipsandroid.databinding.LayoutActionChipBinding

class ActionChipFragment : Fragment() {

    private lateinit var binding:LayoutActionChipBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = LayoutActionChipBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.chipAlarm.setOnClickListener {
            Toast.makeText(context, "Alarm", Toast.LENGTH_SHORT).show()
        }

        binding.chipMusic.setOnClickListener {
            Toast.makeText(context, "Music", Toast.LENGTH_SHORT).show()
        }

        binding.chipCall.setOnClickListener {
            Toast.makeText(context, "Call", Toast.LENGTH_SHORT).show()
        }

        binding.chipMessage.setOnClickListener {
            Toast.makeText(context, "Message", Toast.LENGTH_SHORT).show()
        }
    }


}
