"""
Problem Statement: You are given an array prices where prices[i] is the price of a given stock on the ith day.
                  You want to maximize your profit by choosing a single day to buy one stock
                  and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
            Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
solution link:

Tags: blind-75, Array-2
"""


class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        max_profit = 0
        left, right = 0, 1

        while right < len(prices):
            if prices[left] < prices[right]:
                profit = prices[right] - prices[left]
                max_profit = max(profit, max_profit)
            else:
                left = right
            right += 1

        return max_profit


if __name__ == '__main__':
    print(Solution().maxProfit([7, 9, 3, 10, 2, 40]))
    # print(Solution().maxProfit([3, 2, 6, 5, 0, 3]))
