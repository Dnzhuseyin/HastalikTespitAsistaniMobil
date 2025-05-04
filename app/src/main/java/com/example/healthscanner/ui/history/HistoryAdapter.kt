package com.example.healthscanner.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.healthscanner.R
import com.example.healthscanner.data.model.AnalysisResult

class HistoryAdapter(
    private val results: List<AnalysisResult>
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val result = results[position]
        holder.bind(result)
    }
    
    override fun getItemCount(): Int = results.size
    
    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: CardView = itemView.findViewById(R.id.history_card_view)
        private val dateTextView: TextView = itemView.findViewById(R.id.date_text_view)
        private val resultTypeTextView: TextView = itemView.findViewById(R.id.result_type_text_view)
        
        fun bind(result: AnalysisResult) {
            dateTextView.text = result.date
            resultTypeTextView.text = result.resultType
            
            // Sonuç tipine göre kart rengini ayarla
            val backgroundColor = when (result.resultType) {
                "Hastalık Riski Yok" -> R.color.colorHealthy
                "Şüpheli Bulgular Var" -> R.color.colorWarning
                "Doktora Danışın" -> R.color.colorDanger
                else -> R.color.colorNeutral
            }
            
            cardView.setCardBackgroundColor(
                ContextCompat.getColor(itemView.context, backgroundColor)
            )
            
            // Kart tıklama olayı (detay için)
            cardView.setOnClickListener {
                // Burada detay sayfasına yönlendirebiliriz
                // Şimdilik sadece bir örnek
            }
        }
    }
} 