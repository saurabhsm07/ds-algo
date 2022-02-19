"""
Problem statement: Given the head of a singly linked list, reverse the list, and return the reversed list.
"""


class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    @staticmethod
    def return_mock_ll(counter=10):
        head = ListNode(1)
        i = 1
        temp = head
        while i < counter:
            temp.next = ListNode(i + 1)
            temp = temp.next
            i += 1

        return head

    @staticmethod
    def print_ll(head):
        while head is not None:
            print(head)
            head = head.next

    def __repr__(self):
        return str(self.val)


# 1 - 2 - 3 - 4 - 5
#
# 5 - 4 - 3 - 2 - 1


class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        return self.reverser(None, head)

    def reverser(self, first_node, second_node):
        if not second_node:
            return first_node
        else:
            temp_marker = second_node.next
            second_node.next = first_node
            return self.reverser(second_node, temp_marker)


input_ll = ListNode.return_mock_ll()
print("input")
ListNode.print_ll(input_ll)
print("output")
ListNode.print_ll(Solution().reverseList(input_ll))
