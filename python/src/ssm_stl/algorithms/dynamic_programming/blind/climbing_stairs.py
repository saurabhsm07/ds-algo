"""
Problem Statement: You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Link: https://leetcode.com/problems/climbing-stairs/description/
Solution: https://www.youtube.com/watch?v=Y0lT9Fck7qI
Tags: blind-75, dp, blind-dp-1
"""

class Solution:
    def climbStairs(self, n: int) -> int:
        return self.get_path_bottom_up_dp(n)

    def get_path_dfs(self, x, n):
        if x == n:
            return 1
        elif x < n:
            return self.get_path(x + 1, n) + self.get_path(x + 2, n)
        else:
            return 0

    def get_path_bottom_up_dp(self, n):
        step_s_last, step_last = 1, 0

        for i in range(n):
            temp = step_s_last
            step_s_last = step_s_last + step_last
            step_last = temp

        return step_s_last