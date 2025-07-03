import requests
from utils.config import BASE_URL

class UserAPI:
    endpoint = f"{BASE_URL}/user"

    @staticmethod
    def create_user(payload):
        return requests.post(UserAPI.endpoint, json=payload)

    @staticmethod
    def get_user(username):
        return requests.get(f"{UserAPI.endpoint}/{username}")

    @staticmethod
    def update_user(username, payload):
        return requests.put(f"{UserAPI.endpoint}/{username}", json=payload)

    @staticmethod
    def delete_user(username):
        return requests.delete(f"{UserAPI.endpoint}/{username}")