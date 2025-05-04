package com.example.healthscanner.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.healthscanner.R

class HomeFragment : Fragment() {
    
    private lateinit var scanButton: Button
    private lateinit var historyButton: Button
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        scanButton = view.findViewById(R.id.scan_button)
        historyButton = view.findViewById(R.id.history_button)
        
        scanButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_imageUploadFragment)
        }
        
        historyButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_historyFragment)
        }
    }
} 