package com.example.myfirstapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.myfirstapp.R
import com.example.myfirstapp.databinding.ActivityMainBinding


class BlueFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blue, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myButton = view.findViewById<Button>(R.id.btnPlus)

        myButton.setOnClickListener {
            Toast.makeText(requireContext(), "estoy probando", Toast.LENGTH_SHORT).show()
        }
    }



}