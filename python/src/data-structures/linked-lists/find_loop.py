"""
Problem Statement: Given a linked list, check if the linked list has loop or not.
link: https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
"""

from link_list_operations import LinkedList

class FindLoop(LinkedList):
    """
    Solution using Floyd’s Cycle-Finding Algorithm
    """

    def find_loop(self):
        """
        method finds if there exists a loop in the linked list:
        :return: true if loop exists ; false otherwise
        """

        step1 = self.head
        step2 = self.head
        flag = False
        while step2 is not None and step2.next is not None:
            step1 = step1.next
            step2 = step2.next.next

            if step2 is not None and step1.data == step2.data and step1.next.data == step2.next.data:
                flag = True
                break

        if flag:
            return True
        else:
            return False


if __name__ == '__main__':
    linked_list = FindLoop()
    linked_list.push(1)
    linked_list.push(2)
    linked_list.push(3)
    linked_list.push(4)
    # linked_list.head.next.next.next.next = linked_list.head  # creating a loop

    status = linked_list.find_loop()
    if status:
        print('loop exists in the given linked list')
    else:
        print('loop does not exists in the linked list')
