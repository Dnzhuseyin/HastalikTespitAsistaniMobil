package com.example.healthscanner.data.model

import android.net.Uri

data class AnalysisResult(
    val id: Long,
    val date: String,
    val resultType: String,
    val description: String,
    val imageUri: Uri?
) 