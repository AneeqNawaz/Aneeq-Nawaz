from faker import Faker
import random

faker = Faker()

def generate_user_payload(username=None):
    username = username or faker.user_name()
    return {
        "id": random.randint(1000, 9999),
        "username": username,
        "firstName": faker.first_name(),
        "lastName": faker.last_name(),
        "email": faker.email(),
        "password": faker.password(),
        "phone": faker.phone_number(),
        "userStatus": 1
    }

