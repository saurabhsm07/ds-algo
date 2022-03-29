"""
Problem Statement: Given an array of integers nums and an integer target,
                   return indices of the two numbers such that they add up to target.
                   You may assume that each input would have exactly one solution,
                   and you may not use the same element twice.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]]

link: https://leetcode.com/problems/two-sum/
solution link:

Tags: blind-75, Array-1
"""


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # make use of dictionary <value in array as key, position of element as value>
        result_dict = {}
        for pos, val in enumerate(nums):
            if target - val in result_dict.keys():
                return [result_dict[target - val], pos]
            else:
                result_dict[val] = pos


if __name__ == '__main__':
    # print(Solution().twoSum(nums=[2, 7, 11, 15], target=9))
    print(Solution().twoSum(nums=[3, 2, 4], target=6))
