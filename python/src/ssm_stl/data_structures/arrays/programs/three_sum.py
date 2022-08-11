"""
Problem Statement: Given an integer array nums,
                    return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
                    and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

link: https://leetcode.com/problems/3sum/
solution link: https://www.youtube.com/watch?v=jzZsG8n2R9A&ab_channel=NeetCode

Tags: blind-75, Array-9
"""


class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        # sort the list
        nums.sort()

        result = []
        for pointer, val in enumerate(nums):
            if pointer > 0 and val == nums[pointer - 1]:
                continue

            left_p, right_p = pointer + 1, len(nums) - 1

            while left_p < right_p:
                three_sum = val + nums[left_p] + nums[right_p]
                if three_sum == 0:
                    result.append([val, nums[left_p], nums[right_p]])
                    right_p -= 1
                    left_p += 1
                elif three_sum > 0:
                    right_p -= 1
                else:
                    left_p += 1

                # skip iterations on same values
                while left_p - 1 != pointer and left_p < right_p < len(nums) - 1 and (
                        nums[left_p] == nums[left_p - 1] or nums[right_p] == nums[right_p + 1]):
                    if nums[left_p] == nums[left_p - 1]:
                        left_p += 1
                    if right_p < len(nums) - 1 and nums[right_p] == nums[right_p + 1]:
                        right_p -= 1

        return result


if __name__ == "__main__":
    print(Solution().threeSum([-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4]))
