import pytest
from ssm_stl.data_structures.arrays.programs.miscellaneous_2 import check_if_unique


@pytest.mark.array_tests_ps2
def test_check_if_unique_test_1():
    assert check_if_unique("aabbccd") == False


@pytest.mark.array_tests_ps2
def test_check_if_unique_test_2():
    assert check_if_unique("abcedf") == True