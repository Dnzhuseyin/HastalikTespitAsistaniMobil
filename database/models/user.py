from datetime import datetime

class User:
    def __init__(self, fullname, email, password, role="user"):
        self.fullname = fullname
        self.email = email
        self.password = password  # Şifre hash'lenmiş olmalı
        self.role = role
        self.created_at = datetime.now()

    def to_dict(self):
        return {
            "fullname": self.fullname,
            "email": self.email,
            "password": self.password,
            "role": self.role,
            "created_at": self.created_at
        } 