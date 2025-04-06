from pymongo import MongoClient
from dotenv import load_dotenv
import os

# .env dosyasından ortam değişkenlerini yükle
load_dotenv()

def connect_database():
    try:
        # MongoDB Atlas bağlantı URI'si
        MONGODB_URI = "mongodb+srv://dnzhuseyinnn1:JWxne3gd0USni2CZ@ac-upzbkur.mrg84hv.mongodb.net/?retryWrites=true&w=majority"
        
        # MongoDB'ye bağlan
        client = MongoClient(MONGODB_URI)
        
        # Veritabanını seç
        db = client['medical_diagnosis']
        
        # Bağlantıyı test et
        client.server_info()
        
        print("MongoDB Atlas bağlantısı başarılı!")
        return db
    except Exception as e:
        print(f"MongoDB bağlantı hatası: {e}")
        return None

# Veritabanı bağlantısını test et
if __name__ == "__main__":
    db = connect_database() 