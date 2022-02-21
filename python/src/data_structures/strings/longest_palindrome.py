"""
Problem Statement: (leet code)
Given a string s, return the longest palindromic substring in s.

 Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
"""


class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        longest_palindrome = ''

        start = 0
        end = 0
        for i in range(0, len(s)):
            palindrome_odd = self.check_palindrome_from_center(s, i, i) #aba
            palindrome_even = self.check_palindrome_from_center(s, i, i + 1) #abba
            print("Longest odd palindrome from {} = {}".format(s[i], palindrome_odd))
            print("Longest even palindrome from {} = {}".format(s[i], palindrome_even))

            if len(palindrome_odd) > len(palindrome_even) and len(longest_palindrome) < len(palindrome_odd):
                longest_palindrome = palindrome_odd

            if len(palindrome_odd) < len(palindrome_even) and len(longest_palindrome) < len(palindrome_even):
                longest_palindrome = palindrome_even

        return longest_palindrome

    def check_palindrome_from_center(self, word, start, end):
        current_longest = ''
        while start >= 0 and end < len(word) and word[start] == word[end]:
            current_longest = word[start: end + 1]
            start -= 1
            end += 1

        return current_longest
