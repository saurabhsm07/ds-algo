"""
Problem Statement:
Given an integer N and another integer K,
write a function to find all the unique lists that consist of a combination of numbers from 1 to K,
where the sum of the elements in each list is equal to N. Each number from 1 to K can be repeated multiple times in a list.

Write a function named find_lists that takes two integers,
N and K, as input and returns a list of all unique lists that satisfy the given conditions.

Function Signature:

def find_lists(N: int, K: int) -> List[List[int]]:

Examples:

print(find_lists(5, 4))
# Output: [[1, 1, 1, 1, 1],
            [1, 1, 1, 2],
            [1, 1, 2, 1],
            [1, 1, 3],
            [1, 2, 1, 1],
            [1, 2, 2],
            [1, 3, 1],
            [1, 4],
            [2, 1, 1, 1],
            [2, 1, 2],
            [2, 2, 1],
            [2, 3],
            [3, 1, 1],
            [3, 2],
            [4, 1],
            [5]]

print(find_lists(4, 2))
# Output: [[1, 1, 1, 1], [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 2]]

print(find_lists(6, 3))
# Output: [[1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 2], [1, 1, 1, 2, 1], [1, 1, 1, 3], [1, 1, 2, 1, 1], [1, 1, 2, 2], [1, 1, 3, 1], [1, 1, 4], [1, 2, 1, 1, 1], [1, 2, 1, 2], [1, 2, 2, 1], [1, 2, 3], [1, 3, 1, 1], [1, 3, 2], [1, 4, 1], [1, 5], [2, 1, 1, 1, 1], [2, 1, 1, 2], [2, 1, 2, 1], [2, 1, 3], [2, 2, 1, 1], [2, 2, 2], [2, 3, 1], [2, 4], [3, 1, 1, 1], [3, 1, 2], [3, 2, 1], [3, 3], [4, 1, 1], [4, 2], [5, 1], [6]]

Note:
The order of the lists and the elements within each list does not matter.
Each list in the output should be unique, i.e., no two lists should have the same elements.

"""
from typing import List


def find_lists(n: int, k: int) -> List[List[int]]:
    result_list = []

    def backtrack_sum(temp_list, n, k):
        if n == 0:
            result_list.append(sorted(temp_list)) if sorted(temp_list) not in result_list else result_list
            return
        elif n < 0:
            return
        else:
            for i in range(1, k + 1):
                new_sum = n - i
                temp_list_curr = temp_list+[i]
                backtrack_sum(temp_list_curr, new_sum, k)

    backtrack_sum([], n, k)
    return result_list


print(find_lists(5, 4))
