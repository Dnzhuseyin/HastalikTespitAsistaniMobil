from database.services.database_service import DatabaseService
from database.models.user import User
from database.models.diagnosis import Diagnosis
import base64

def main():
    # Veritabanı servisini başlat
    db_service = DatabaseService()

    # Yeni kullanıcı oluştur
    user = User(
        fullname="John Doe",
        email="john@example.com",
        password="hashed_password"  # Gerçek uygulamada hash'lenmiş olmalı
    )
    user_id = db_service.create_user(user)

    # Görüntü verisi (örnek olarak)
    with open("example_image.jpg", "rb") as image_file:
        image_data = base64.b64encode(image_file.read()).decode('utf-8')

    # Teşhis sonucu oluştur
    diagnosis = Diagnosis(
        user_id=user_id,
        image_data=image_data,
        diagnosis_result={
            "condition": "Healthy",
            "confidence": 0.95,
            "details": "No abnormalities detected"
        }
    )
    diagnosis_id = db_service.create_diagnosis(diagnosis)

    # Kullanıcının tüm teşhislerini getir
    user_diagnoses = db_service.get_user_diagnoses(user_id)
    for d in user_diagnoses:
        print(f"Teşhis Tarihi: {d['created_at']}")
        print(f"Durum: {d['diagnosis_result']['condition']}")
        print(f"Güven: {d['diagnosis_result']['confidence']}")
        print("---")

if __name__ == "__main__":
    main() 