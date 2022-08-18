"""
Problem Statement: Given an integer array nums, find the contiguous subarray (containing at least one number)
                   which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23

Link: https://leetcode.com/problems/maximum-subarray/
Solution Link: https://www.youtube.com/watch?v=5WZl3MMT0Eg

Tags: blind-75, Array-5
"""
from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        result = nums[0]
        current_max = 0

        for num in nums:
            if current_max < 0:
                current_max = 0

            current_max = current_max + num

            result = max(result, current_max)

        return result

    def maxSubArrayWithPointers(self, nums: List[int]) -> int:
        result_dict = {'start': 0, 'end': 0, 'max': nums[0]}
        left_pointer, right_pointer = 0, 1
        current_max = nums[0]

        while right_pointer < len(nums):
            print(left_pointer, right_pointer, current_max)
            if current_max < 0 or current_max + nums[right_pointer] < 0:
                print('here')
                current_max = nums[right_pointer]
                left_pointer = right_pointer
                right_pointer = right_pointer + 1
            else:
                current_max = current_max + nums[right_pointer]
                right_pointer = right_pointer + 1

            if result_dict['max'] < current_max:
                result_dict['max'] = current_max
                result_dict['start'] = left_pointer
                result_dict['end'] = right_pointer - 1

        print(result_dict)
        return result_dict['max']