import pytest
from apis.user_api import UserAPI
from utils.data_generator import generate_user_payload

@pytest.mark.order(3)
def test_update_user():
    updated_payload = generate_user_payload(username="testuser123")
    response = UserAPI.update_user("testuser123", updated_payload)
    assert response.status_code == 200