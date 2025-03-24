package com.example.healthscanner.ui.analysis

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.healthscanner.R
import com.example.healthscanner.utils.NotificationHelper
import kotlin.random.Random

class AnalysisResultFragment : Fragment() {
    
    private lateinit var resultCardView: CardView
    private lateinit var resultTitleTextView: TextView
    private lateinit var resultDescriptionTextView: TextView
    private lateinit var analyzedImageView: ImageView
    private lateinit var homeButton: Button
    private lateinit var historyButton: Button
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_analysis_result, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        resultCardView = view.findViewById(R.id.result_card_view)
        resultTitleTextView = view.findViewById(R.id.result_title_text_view)
        resultDescriptionTextView = view.findViewById(R.id.result_description_text_view)
        analyzedImageView = view.findViewById(R.id.analyzed_image_view)
        homeButton = view.findViewById(R.id.home_button)
        historyButton = view.findViewById(R.id.history_button)
        
        // Görüntüyü al ve göster
        arguments?.getString("imageUri")?.let { uriString ->
            val uri = Uri.parse(uriString)
            analyzedImageView.setImageURI(uri)
            
            // Örnek olarak rastgele bir analiz sonucu gösterelim
            simulateAnalysisResult()
        }
        
        homeButton.setOnClickListener {
            findNavController().navigate(R.id.action_analysisResultFragment_to_homeFragment)
        }
        
        historyButton.setOnClickListener {
            findNavController().navigate(R.id.action_analysisResultFragment_to_historyFragment)
        }
    }
    
    private fun simulateAnalysisResult() {
        // Simüle analiz sonucu (gerçek uygulamada yapay zeka modeli sonuçlarına göre olacak)
        val resultType = Random.nextInt(3)
        
        when (resultType) {
            0 -> { // Hastalık Riski Yok
                resultCardView.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.colorHealthy))
                resultTitleTextView.text = "Hastalık Riski Yok"
                resultDescriptionTextView.text = "Görüntü analizi sonucunda herhangi bir hastalık belirtisi tespit edilmedi. Düzenli kontrollerinizi sürdürmenizi öneririz."
            }
            1 -> { // Şüpheli Bulgular
                resultCardView.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.colorWarning))
                resultTitleTextView.text = "Şüpheli Bulgular Var"
                resultDescriptionTextView.text = "Görüntü analizinde bazı şüpheli bulgular tespit edildi. Daha kesin bir sonuç için bir uzmana danışmanızı öneririz."
            }
            2 -> { // Doktora Danışın
                resultCardView.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.colorDanger))
                resultTitleTextView.text = "Doktora Danışın"
                resultDescriptionTextView.text = "Görüntüde yüksek risk içeren bulgular tespit edildi. En kısa sürede bir sağlık uzmanına başvurmanızı önemle tavsiye ederiz."
            }
        }
        
        // Kullanıcıya bildirim gönder
        NotificationHelper(requireContext()).showAnalysisResultNotification(
            resultTitleTextView.text.toString(),
            resultDescriptionTextView.text.toString()
        )
    }
} 