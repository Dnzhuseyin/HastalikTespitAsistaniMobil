from ..connection import connect_database
from ..models.user import User
from ..models.diagnosis import Diagnosis
from bson import ObjectId

class DatabaseService:
    def __init__(self):
        self.db = connect_database()
        self.users = self.db['users']
        self.diagnoses = self.db['diagnoses']

    def create_user(self, user: User):
        try:
            result = self.users.insert_one(user.to_dict())
            return str(result.inserted_id)
        except Exception as e:
            print(f"Kullanıcı oluşturma hatası: {e}")
            return None

    def create_diagnosis(self, diagnosis: Diagnosis):
        try:
            result = self.diagnoses.insert_one(diagnosis.to_dict())
            return str(result.inserted_id)
        except Exception as e:
            print(f"Teşhis kaydı oluşturma hatası: {e}")
            return None

    def get_user_diagnoses(self, user_id: str):
        try:
            diagnoses = self.diagnoses.find({"user_id": ObjectId(user_id)})
            return list(diagnoses)
        except Exception as e:
            print(f"Teşhis kayıtları getirme hatası: {e}")
            return []

    def update_diagnosis(self, diagnosis_id: str, updates: dict):
        try:
            result = self.diagnoses.update_one(
                {"_id": ObjectId(diagnosis_id)},
                {"$set": updates}
            )
            return result.modified_count > 0
        except Exception as e:
            print(f"Teşhis güncelleme hatası: {e}")
            return False 