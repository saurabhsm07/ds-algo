"""
Problem Statement: Find if given singly linked list is a palindrome

link: https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
"""
from link_list_operations import LinkedList


class CheckPalindrome(LinkedList):

    def check_if_palindrome(self):
        """
        method checks if the linked list pointed to by the head is a palindrome
        :return: void
        """
        if self.head is None:
            print("the linked list contains no elements")
        else:
            ele_stack = [] # stack of data elements from the linked list
            step1 = step2 = self.head

            while step2 is not None and step2.next is not None:
                ele_stack.append(step1.data)
                step1 = step1.next
                step2 = step2.next.next

            if step2 is not None:
                step1 = step1.next

            flag = True
            while len(ele_stack) > 0 and step1 is not None:
                print(step1.data)
                print(ele_stack)
                if ele_stack.pop() != step1.data:
                    flag = False
                    break
                else:
                    step1 = step1.next

            if flag:
                print('\n \n the given linked list is a palindrome')
            else:
                print('\n \n the given linked list is not a palindrome')


if __name__ == '__main__':
    linked_list = CheckPalindrome()

    # test case 1
    in_arr = [1, 2, 3, 4, 5]
    for i in range(0, len(in_arr)):
        linked_list.push(in_arr[i])

    linked_list.print()

    linked_list.check_if_palindrome()

    # test case 2
    in_arr = [1, 2, 3, 7, 3, 2, 1]
    for i in range(0, len(in_arr)):
        linked_list.push(in_arr[i])

    linked_list.print()

    linked_list.check_if_palindrome()
