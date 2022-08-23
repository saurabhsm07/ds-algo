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

Algorithm:
    STEP 1: Sort the input list.
        - will help in linear analysis and skipping duplicate combinations
    STEP 2: fix a pointer to First element.
        - perform 2 sum between remaining elements of the array, buy using left pointer and right pointer method
    - NOTE skip over element selection if they are equal to previous elements

Time Complexity: O(n^2) -> o(nlog(n)) (for sorting) + n^2 ( 3 sum using 2 nested loops)
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

            left_pointer, right_pointer = pointer + 1, len(nums) - 1

            while left_pointer < right_pointer:
                three_sum = val + nums[left_pointer] + nums[right_pointer]
                if three_sum == 0:
                    result.append([val, nums[left_pointer], nums[right_pointer]])
                    right_pointer -= 1
                    left_pointer += 1
                elif three_sum > 0:
                    right_pointer -= 1
                else:
                    left_pointer += 1

                # skip iterations on same values
                while left_pointer - 1 != pointer and left_pointer < right_pointer and (
                        nums[left_pointer] == nums[left_pointer - 1] or (
                        right_pointer < len(nums) - 1 and nums[right_pointer] == nums[right_pointer + 1])):
                    # print('here')
                    if nums[left_pointer] == nums[left_pointer - 1]:
                        left_pointer += 1
                    if right_pointer < len(nums) - 1 and nums[right_pointer] == nums[right_pointer + 1]:
                        right_pointer -= 1

        return result


if __name__ == "__main__":
    # print(Solution().threeSum([-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4]))
    print(Solution().threeSum([-1, 0, 1, 2, -1, -4]))
