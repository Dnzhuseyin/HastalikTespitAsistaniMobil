const mongoose = require('mongoose');

const diagnosisSchema = new mongoose.Schema({
  user: {
    type: mongoose.Schema.ObjectId,
    ref: 'User',
    required: true
  },
  image: {
    url: {
      type: String,
      required: [true, 'Görüntü URL\'si zorunludur']
    },
    publicId: String
  },
  diagnosis: {
    result: {
      type: String,
      required: [true, 'Teşhis sonucu zorunludur']
    },
    confidence: {
      type: Number,
      required: true,
      min: 0,
      max: 100
    },
    details: {
      type: String
    }
  },
  doctorNotes: {
    type: String
  },
  reviewedBy: {
    type: mongoose.Schema.ObjectId,
    ref: 'User'
  },
  status: {
    type: String,
    enum: ['pending', 'reviewed', 'completed'],
    default: 'pending'
  },
  createdAt: {
    type: Date,
    default: Date.now
  },
  updatedAt: {
    type: Date,
    default: Date.now
  }
});

// Güncelleme tarihini otomatik güncelle
diagnosisSchema.pre('save', function(next) {
  this.updatedAt = Date.now();
  next();
});

module.exports = mongoose.model('Diagnosis', diagnosisSchema); 