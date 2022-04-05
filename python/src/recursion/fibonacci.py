from utils.function_timers import get_execution_time_simple
class Solution(object):
    records = {1: 1, 0: 0}

    def fib(self, n):
        if n < 2:
            return n
        else:
            return self.fib(n - 1) + self.fib(n - 2)

    def fib_memoization(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 2:
            return n
        else:
            if n in Solution.records.keys():
                return Solution.records[n]
            else:
                Solution.records[n] = self.fib_memoization(n - 1) + self.fib_memoization(n - 2)
                return Solution.records[n]


if __name__ == "__main__":
    import time

    t1 = time.time()
    Solution().fib(30)
    t2 = time.time()
    print(t2 - t1)

    t1 = time.time()
    Solution().fib_memoization(700)
    t2 = time.time()
    print(t2 - t1)