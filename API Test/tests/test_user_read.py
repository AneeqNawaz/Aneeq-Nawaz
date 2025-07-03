import time
import pytest
from apis.user_api import UserAPI
from utils.data_generator import generate_user_payload

@pytest.mark.order(2)
def test_get_user():
    user = generate_user_payload()
    create_response = UserAPI.create_user(user)
    assert create_response.status_code == 200

    # Retry up to 3 times to confirm user exists
    for _ in range(3):
        time.sleep(0.5)
        response = UserAPI.get_user(user["username"])
        if response.status_code == 200:
            break
    else:
        pytest.fail(f"User '{user['username']}' not found after creation")

    assert response.json()["username"] == user["username"]