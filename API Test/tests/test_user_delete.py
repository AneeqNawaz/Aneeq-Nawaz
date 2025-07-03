import time
import pytest
from apis.user_api import UserAPI
from utils.data_generator import generate_user_payload

@pytest.mark.order(4)
def test_delete_user():
    user = generate_user_payload()

    create_response = UserAPI.create_user(user)
    assert create_response.status_code == 200
    print("Create response:", create_response.status_code, create_response.text)

    # Retry GET
    for attempt in range(6):
        time.sleep(1)
        check = UserAPI.get_user(user["username"])
        print(f"GET attempt {attempt+1}: {check.status_code}")
        if check.status_code == 200:
            break
    else:
        pytest.fail(f"User '{user['username']}' not found before delete attempt")

    delete_response = UserAPI.delete_user(user["username"])
    print("Delete response:", delete_response.status_code, delete_response.text)
    assert delete_response.status_code == 200
