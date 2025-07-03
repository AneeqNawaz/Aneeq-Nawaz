import pytest
from utils.data_generator import generate_user_payload

@pytest.fixture(scope="session")
def shared_user():
    """Generates a single test user reused across all CRUD tests."""
    return generate_user_payload()
