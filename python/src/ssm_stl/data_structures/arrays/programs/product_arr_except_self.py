"""
Problem Statement: Given an integer array nums, return an array answer such that answer[i] is equal to
the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
"""


class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        prefix_product = []
        suffix_product = []
        result_arr = []
        arr_length = len(nums)
        # print(arr_length)
        for i in range(0, arr_length):
            # print(i)
            prefix_product.append(nums[i] if i == 0 else nums[i] * prefix_product[i - 1])
            suffix_product.append(
                nums[arr_length - 1] if i == 0 else nums[arr_length - i - 1] * suffix_product[i - 1])

        print(prefix_product)
        print(suffix_product)
        for i in range(0, arr_length):
            if i == 0:
                result_arr.append(suffix_product[arr_length - 2])
            elif i == arr_length - 1:
                result_arr.append(prefix_product[i - 1])
            else:
                result_arr.append(prefix_product[i - 1] * suffix_product[arr_length - 1 - i - 1])

        return result_arr


"""
Test Cases:
"""
print(Solution().productExceptSelf([4, 3, 2, 1, 2]))
