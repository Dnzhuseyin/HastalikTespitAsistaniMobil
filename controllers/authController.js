const User = require('../models/User');

// Kullanıcı kaydı
exports.register = async (req, res) => {
  try {
    const { fullName, email, password } = req.body;

    const user = await User.create({
      fullName,
      email,
      password
    });

    // JWT token oluştur
    const token = // ... JWT token oluşturma işlemi

    res.status(201).json({
      success: true,
      token,
      user
    });
  } catch (error) {
    res.status(400).json({
      success: false,
      error: error.message
    });
  }
}; 