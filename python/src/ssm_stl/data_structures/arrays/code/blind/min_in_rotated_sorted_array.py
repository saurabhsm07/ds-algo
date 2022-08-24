"""
Problem Statement: Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
Solution Link: https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/

Tags: blind-75, Array-7
"""


class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        smallest = self.find_min(0, len(nums) - 1, nums)
        return smallest

    @staticmethod
    def find_min(l, h, nums):
        print(l, h)
        if l == h or l > h:
            return nums[l]
        else:
            mid = int((l + h) / 2)
            if nums[mid - 1] < nums[mid] < nums[mid + 1]:
                s1 = Solution.find_min(l, mid - 1, nums)
                s2 = Solution.find_min(mid + 1, h, nums)
                return min(s1, s2)
            elif nums[mid - 1] > nums[mid]:
                return nums[mid]
            else:
                return nums[mid + 1]
