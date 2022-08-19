"""
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []

Link: https://leetcode.com/problems/merge-k-sorted-lists/
Solution Links:
    approach 1:
    approach 2:

Tags: blind-75, Heap-1
"""
from typing import List, Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    @classmethod
    def create_linked_list_from_list(cls, nums: List):
        result = ListNode(-1)
        current = result

        for num in nums:
            current.next = ListNode(num)
            current = current.next

        return result.next

    @classmethod
    def create_list_of_linked_lists(cls, lists: List[List]):
        result_set = []
        for current_list in lists:
            result_set.append(cls.create_linked_list_from_list(current_list))

        return result_set


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if lists is None or len(lists) == 0:
            return []
        else:
            return self.merge_lists(lists, 0, len(lists) - 1)

    def merge_lists(self, lists, low, high):
        if low == high:
            return lists[low]
        else:
            mid = int((low + high) / 2)
            print(mid)
            left_list = self.merge_lists(lists, low, mid)
            right_list = self.merge_lists(lists, mid + 1, high)
            merged_list =  self.merge(left_list, right_list)
            print_linked_list(merged_list)
            return merged_list

    def merge(self, left_list, right_list):
        # print_linked_list(left_list)
        # print_linked_list(right_list)
        result = ListNode()
        current = result

        while left_list is not None or right_list is not None:
            if right_list is None:
                print(left_list.val)
                current.next = ListNode(left_list.val)
                left_list = left_list.next
            elif left_list is None:
                print(right_list.val)
                current.next = ListNode(right_list.val)
                right_list = right_list.next
            elif left_list.val < right_list.val:
                print(left_list.val)
                current.next = ListNode(left_list.val)
                left_list = left_list.next
            else:
                print(right_list.val)
                current.next = ListNode(right_list.val)
                right_list = right_list.next
            current = current.next
        return result.next


""" TEST CASES"""

input_set = ListNode.create_list_of_linked_lists([[1, 2, 3, 10], [6, 9, 11, 22], [55, 66, 99, 809], [-4, -5, -6, -7]])


def print_linked_list(input):
    print('-----')
    ll = input
    while ll is not None:
        print(ll.val, end="--->")
        ll = ll.next
    print('END')


# for input in input_set:
#     print_linked_list(input)

result = Solution().mergeKLists(input_set)

print_linked_list(result)