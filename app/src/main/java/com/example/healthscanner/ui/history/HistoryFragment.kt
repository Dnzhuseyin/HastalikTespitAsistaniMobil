package com.example.healthscanner.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthscanner.R
import com.example.healthscanner.data.model.AnalysisResult
import java.text.SimpleDateFormat
import java.util.*

class HistoryFragment : Fragment() {
    
    private lateinit var historyRecyclerView: RecyclerView
    private lateinit var emptyTextView: TextView
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        historyRecyclerView = view.findViewById(R.id.history_recycler_view)
        emptyTextView = view.findViewById(R.id.empty_text_view)
        
        // Demo veriler oluştur
        val demoResults = createDemoResults()
        
        if (demoResults.isEmpty()) {
            emptyTextView.visibility = View.VISIBLE
            historyRecyclerView.visibility = View.GONE
        } else {
            emptyTextView.visibility = View.GONE
            historyRecyclerView.visibility = View.VISIBLE
            
            historyRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            historyRecyclerView.adapter = HistoryAdapter(demoResults)
        }
    }
    
    private fun createDemoResults(): List<AnalysisResult> {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        val calendar = Calendar.getInstance()
        
        val results = mutableListOf<AnalysisResult>()
        
        // Bugünkü analiz
        results.add(
            AnalysisResult(
                id = 1,
                date = dateFormat.format(calendar.time),
                resultType = "Hastalık Riski Yok",
                description = "Görüntü analizi sonucunda herhangi bir hastalık belirtisi tespit edilmedi.",
                imageUri = null
            )
        )
        
        // 2 gün önceki analiz
        calendar.add(Calendar.DAY_OF_MONTH, -2)
        results.add(
            AnalysisResult(
                id = 2,
                date = dateFormat.format(calendar.time),
                resultType = "Şüpheli Bulgular Var",
                description = "Görüntü analizinde bazı şüpheli bulgular tespit edildi.",
                imageUri = null
            )
        )
        
        // 1 hafta önceki analiz
        calendar.add(Calendar.DAY_OF_MONTH, -5)
        results.add(
            AnalysisResult(
                id = 3,
                date = dateFormat.format(calendar.time),
                resultType = "Doktora Danışın",
                description = "Görüntüde yüksek risk içeren bulgular tespit edildi.",
                imageUri = null
            )
        )
        
        return results
    }
} 