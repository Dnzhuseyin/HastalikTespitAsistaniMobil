from database.connection import connect_database

def test_mongodb_connection():
    db = connect_database()
    
    if db:
        try:
            test_collection = db.test_collection
            result = test_collection.insert_one({"test": "Bağlantı testi"})
            test_data = test_collection.find_one({"test": "Bağlantı testi"})
            
            if test_data:
                print("Test başarılı: Veri eklendi ve okundu!")
                
            test_collection.delete_one({"test": "Bağlantı testi"})
            print("Veritabanı bağlantısı ve CRUD işlemleri başarılı!")
            return True
            
        except Exception as e:
            print(f"Test sırasında hata oluştu: {e}")
            return False
    else:
        print("Veritabanı bağlantısı kurulamadı!")
        return False

if __name__ == "__main__":
    test_mongodb_connection() 