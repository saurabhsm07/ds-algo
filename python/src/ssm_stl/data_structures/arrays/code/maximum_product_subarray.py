"""
Problem Statement: Given an integer array nums,
find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Link: https://leetcode.com/problems/maximum-product-subarray/
Solution: https://www.youtube.com/watch?v=mBNrRy2_hVs

Tags: blind-75, Array-6
"""
from typing import List


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        product_arr = [(nums[0], nums[0], nums[0]) if nums[0] != 0 else (0, 1, 1)]

        if len(nums) == 1:
            return nums[0]

        for i in range(1, len(nums)):
            product_arr.append((nums[i],
                                min(nums[i],
                                    nums[i] * product_arr[i - 1][1],
                                    nums[i] * product_arr[i - 1][2]),
                                max(nums[i],
                                    nums[i] * product_arr[i - 1][1],
                                    nums[i] * product_arr[i - 1][2])))

        # print(product_arr)

        return max([max(x) if x[0] != 0 else 0 for x in product_arr])


print(Solution().maxProduct([2, 3, -2, 4]))
