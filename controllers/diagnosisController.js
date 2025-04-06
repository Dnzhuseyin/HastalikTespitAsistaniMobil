const Diagnosis = require('../models/Diagnosis');

// Yeni teşhis kaydı oluşturma
exports.createDiagnosis = async (req, res) => {
  try {
    const { imageUrl, diagnosisResult, confidence } = req.body;

    const diagnosis = await Diagnosis.create({
      user: req.user.id, // JWT'den gelen kullanıcı ID'si
      image: {
        url: imageUrl
      },
      diagnosis: {
        result: diagnosisResult,
        confidence: confidence
      }
    });

    res.status(201).json({
      success: true,
      diagnosis
    });
  } catch (error) {
    res.status(400).json({
      success: false,
      error: error.message
    });
  }
}; 