
"""
Problem Statement: Given a singly linked list, find middle of the linked list. For example,
                    if given linked list is 1->2->3->4->5 then output should be 3.
link: https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
"""

from link_list_operations import LinkedList

class Node(LinkedList):

    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedListMiddle(LinkedList):

    def __init__(self):
        self.head = None

    def find_middle_ele(self):
        """
        method finds middle element in the given linked list
        :return: (-1,-1) if no elements, middle element if linked list is even sized, tuple of middle elements if odd sized
        """
        if self.head is None:
            return -1, -1
        else:
            step1 = step2 = self.head
            middle1 = -1
            while step2 is not None and step2.next is not None:
                middle1 = step1.data
                step1 = step1.next
                step2 = step2.next.next

            if step2 is None:
                return middle1, step1.data
            else:
                return step1.data


if __name__ == '__main__':
    linked_list_middle = LinkedListMiddle()

    input_arr = [1, 2, 4, 5, 11]
    for i in range(len(input_arr)):
        linked_list_middle.append(input_arr[i])

    linked_list_middle.print()

    middle = linked_list_middle.find_middle_ele()
    if type(middle) is not int:
        if middle[0] == middle[1] == -1:
            print('linked list has no elements')
        else:
            print('\n \n Size of the linked list is even hence 2 middle points are ({}, {})'.format(middle[0], middle[1]))
    else:
        print('\n middle elements is {}'.format(middle))
