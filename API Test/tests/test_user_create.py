import pytest
from apis.user_api import UserAPI
from utils.data_generator import generate_user_payload

@pytest.mark.order(1)
def test_create_user():
    payload = generate_user_payload()
    response = UserAPI.create_user(payload)
    assert response.status_code == 200

@pytest.mark.order(2)
def test_get_user():
    username = "testuser123"
    response = UserAPI.get_user(username)
    assert response.status_code == 200
    assert response.json()["username"] == username

@pytest.mark.order(3)
def test_update_user():
    updated_payload = generate_user_payload(username="testuser123")
    response = UserAPI.update_user("testuser123", updated_payload)
    assert response.status_code == 200

@pytest.mark.order(4)
def test_delete_user():
    response = UserAPI.delete_user("testuser123")
    assert response.status_code == 200
