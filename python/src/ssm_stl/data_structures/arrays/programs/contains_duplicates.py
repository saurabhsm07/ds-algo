"""
Problem Statement: Given an integer array nums, return true if any value appears at least twice in the array,
                    and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Link: https://leetcode.com/problems/contains-duplicate/
Solution: N/A

Tags: blind-75, Array-3
"""
from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        nums.sort()

        left_pointer, right_pointer = 0, 1

        while right_pointer < len(nums):
            if nums[left_pointer] == nums[right_pointer]:
                return True
            else:
                left_pointer += 1
                right_pointer += 1

        return False
