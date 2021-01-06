# """
# Problem Statement: Given an integer array and a positive integer k, count all distinct pairs with difference equal to k.
# Link: https://www.geeksforgeeks.org/count-pairs-difference-equal-k/
# """
#
# """
# Algorithm:
#     Use Hashing:
#     1) Initialize count as 0.
#     2) Insert all distinct elements of arr[] in a hash map.  While inserting,
#         ignore an element if already present in the hash map.
#     3) Do following for each element arr[i].
#        a) Look for arr[i] + k in the hash map, if found then increment count.
#        b) Look for arr[i] - k in the hash map, if found then increment count.
#        c) Remove arr[i] from hash table.
# """
#
#
# # solution 1:
#
# def find_pairs_p1s1(in_arr, diff):
#     keySet = {}
#     for i in range(len(in_arr)):
#         keySet[in_arr[i]] = in_arr[i]
#     print(keySet)
#     difference_count = 0
#     for i in range(len(in_arr)):
#         if in_arr[i] + diff in keySet.keys():
#             difference_count += 1
#         if in_arr[i] - diff in keySet.keys():
#             difference_count += 1
#     print('SOLUTION P1S1: \n total element pairs = ', difference_count / 2)
#
#
# """
# Test Cases:
# """
#
# # test case 1:
# test_arr = [1, 5, 3, 4, 2]
# difference = 3
# find_pairs_p1s1(test_arr, difference)
#
# # test case 2:
# test_arr = [8, 12, 16, 4, 0, 20]
# difference = 4
# find_pairs_p1s1(test_arr, difference)
#
# """
# Implement an algorithm to determine if a string has all unique characters. What if you
# cannot use additional data structures?
# """
from functools import reduce


def check_if_unique(ip_str: str) -> bool:
    """

    @return: Boolean value True if string characters are unique false otherwise
    @param ip_str:  input string to be checked if unique
    """
    ip_str = reduce(lambda x, y: x+y, sorted(ip_str))

    for i in range(0, len(ip_str) - 1):
        if ip_str[i] == ip_str[i+1]:
            return False
    return True


