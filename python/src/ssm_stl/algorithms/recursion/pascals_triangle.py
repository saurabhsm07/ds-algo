"""
Problem statement: Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]

leet code: https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/
"""

import time


class Solution(object):
    pascal_value_store = {}  # not of major use

    def getRow_legacy(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        pascals_row = []
        for i in range(0, rowIndex + 1):
            pascals_row.append(self.get_pascal_value_legacy(rowIndex, i))

        return pascals_row

    def get_pascal_value_legacy(self, level, i):
        if i == 0 or i == level:
            return 1
        else:
            return self.get_pascal_value_legacy(level - 1, i - 1) + self.get_pascal_value_legacy(level - 1, i)

    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        pascals_row = [None] * (rowIndex + 1)
        optimal_level = (rowIndex + 2) / 2 if rowIndex % 2 == 0 else (rowIndex + 1) / 2
        print(optimal_level)
        for i in range(0, int(optimal_level)):
            pascals_row[i] = self.get_pascal_value(rowIndex, i)
            pascals_row[rowIndex - i] = pascals_row[i]
        return pascals_row

    def get_pascal_value(self, level, i):
        if i == 0 or i == level:
            return 1
        else:
            if (level, i) in self.pascal_value_store.keys():
                return self.pascal_value_store[(level, i)]
            else:
                self.pascal_value_store[(level, i)] = self.get_pascal_value(level - 1, i - 1) \
                                                      + self.get_pascal_value(level - 1, i)
        return self.pascal_value_store[(level, i)]


if __name__ == '__main__':
    start_time = time.perf_counter()
    print(Solution().getRow(100))
    end_time = time.perf_counter()

    print("Time Complexity = ", (end_time - start_time))

    start_time = time.perf_counter()
    print(Solution().getRow_legacy(50))
    end_time = time.perf_counter()

    print("Time Complexity = ", (end_time - start_time))
