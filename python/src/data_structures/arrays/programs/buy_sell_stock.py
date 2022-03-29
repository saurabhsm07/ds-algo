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
        prices_dict, pos_dict = {}, {}
        for day, price in enumerate(prices):
            if price not in prices_dict.keys():
                prices_dict[price] = [day]
            else:
                prices_dict[price].append(day)

        prices.sort()

        max_profit = 0

        for i in range(len(prices)):
            if i > 0 and prices[i] == prices[i - 1]:
                continue

            if max_profit > prices[len(prices) - 1] - prices[i]:
                break

            for j in range(len(prices) - 1, i, -1):
                print(prices[i], prices[j])
                buy_sell_gap = self.get_best_sell_gap(prices_dict, prices[i], prices[j])

                estimated_profit = prices[j] - prices[i]

                if estimated_profit < max_profit:
                    break
                max_profit = estimated_profit if buy_sell_gap > 0 and estimated_profit > max_profit else max_profit

        return max_profit

    def get_best_sell_gap(self, prices_dict, buy_price, sell_price):
        return max(prices_dict[sell_price]) - min(prices_dict[buy_price])


if __name__ == '__main__':
    # print(Solution().maxProfit([7, 1, 5, 3, 6, 4]))
    print(Solution().maxProfit([3, 2, 6, 5, 0, 3]))
