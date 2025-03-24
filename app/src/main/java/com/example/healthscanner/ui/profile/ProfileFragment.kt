package com.example.healthscanner.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.healthscanner.R
import com.example.healthscanner.auth.LoginActivity

class ProfileFragment : Fragment() {
    
    private lateinit var profileImageView: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var editProfileButton: Button
    private lateinit var settingsButton: Button
    private lateinit var logoutButton: Button
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        profileImageView = view.findViewById(R.id.profile_image_view)
        nameTextView = view.findViewById(R.id.name_text_view)
        emailTextView = view.findViewById(R.id.email_text_view)
        editProfileButton = view.findViewById(R.id.edit_profile_button)
        settingsButton = view.findViewById(R.id.settings_button)
        logoutButton = view.findViewById(R.id.logout_button)
        
        // Örnek kullanıcı bilgileri
        nameTextView.text = "Test Kullanıcı"
        emailTextView.text = "test@example.com"
        
        editProfileButton.setOnClickListener {
            // Profil düzenleme ekranına git
        }
        
        settingsButton.setOnClickListener {
            // Ayarlar ekranına git
        }
        
        logoutButton.setOnClickListener {
            // Çıkış yap
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }
} 