from datetime import datetime
from bson import ObjectId

class Diagnosis:
    def __init__(self, user_id, image_data, diagnosis_result):
        self.user_id = user_id
        self.image_data = image_data  # Base64 formatında görüntü verisi
        self.diagnosis_result = diagnosis_result
        self.created_at = datetime.now()
        self.status = "pending"  # pending, reviewed, completed
        self.doctor_notes = ""
        self.reviewed_by = None

    def to_dict(self):
        return {
            "user_id": ObjectId(self.user_id),
            "image_data": self.image_data,
            "diagnosis_result": {
                "condition": self.diagnosis_result.get("condition", ""),
                "confidence": self.diagnosis_result.get("confidence", 0),
                "details": self.diagnosis_result.get("details", "")
            },
            "created_at": self.created_at,
            "status": self.status,
            "doctor_notes": self.doctor_notes,
            "reviewed_by": self.reviewed_by
        } 