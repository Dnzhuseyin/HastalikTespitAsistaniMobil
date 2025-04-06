const express = require('express');
const dotenv = require('dotenv');
const connectDatabase = require('./config/database');

// Ortam değişkenlerini yükle
dotenv.config();

// Express uygulamasını oluştur
const app = express();

// JSON body parser
app.use(express.json());

// Veritabanı bağlantısı
connectDatabase();

// Rotaları tanımla
app.use('/api/auth', require('./routes/auth'));
app.use('/api/diagnosis', require('./routes/diagnosis'));

// Sunucuyu başlat
const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
  console.log(`Sunucu ${PORT} portunda çalışıyor`);
});

// Hata yönetimi
process.on('unhandledRejection', (err) => {
  console.log('UNHANDLED REJECTION! Sunucu kapatılıyor...');
  console.log(err.name, err.message);
  process.exit(1);
}); 