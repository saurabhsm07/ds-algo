"""
Problem Statement: Given an integer array nums, return an array answer such that answer[i] is equal to
the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Link: https://leetcode.com/problems/product-of-array-except-self/
Solution: https://www.youtube.com/watch?v=bNvIQI2wAjk
Tags: blind-75, Array-4
"""


class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        left_prod, right_prod, result = [], [], []
        input_length = len(nums)

        left_prod.append(nums[0])    # first element
        right_prod.append(nums[input_length - 1])  # last element
        for i in range(1, input_length):
            left_prod.append(left_prod[i - 1] * nums[i])
            right_prod.append(right_prod[i - 1] * nums[input_length - 1 - i])

        print(left_prod, right_prod)

        result.append(right_prod[input_length - 2])   # first element

        for i in range(1, input_length - 1):
            result.append(left_prod[i - 1] * right_prod[input_length - 2 - i])

        result.append(left_prod[input_length - 2])  # last element
        return result


"""
Test Cases:
"""
print(Solution().productExceptSelf([4, 3, 2, 1, 2]))
