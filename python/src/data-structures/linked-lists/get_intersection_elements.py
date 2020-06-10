"""
Problem Statement: Given two lists sorted in increasing order,
                   create and return a new list representing the intersection of the two lists.
Link: https://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/
"""

from link_list_operations import LinkedList, Node


class LinkedListIntersection:

    def get_intersection(self, head1, head2):
        l3 = LinkedList()
        temp1 = head1
        temp2 = head2
        temp3 = l3.head
        l3.head = temp3
        print(temp3)
        while temp1 is not None and temp2 is not None:
            print(temp1.data,"   ", temp2.data)
            if temp1.data == temp2.data:
                new_node = Node(temp2.data)
                if temp3 is None:
                    temp3 = new_node
                    temp1 = temp1.next
                    temp2 = temp2.next
                    l3.append(temp3.data)
                elif temp3.data != new_node.data:

                    temp3.next = new_node
                    temp1 = temp1.next
                    temp2 = temp2.next
                    temp3 = temp3.next
                    l3.append(temp3.data)
                else:
                    temp1 = temp1.next
                    temp2 = temp2.next
            elif temp1.data > temp2.data:
                temp2 = temp2.next
            else:
                temp1 = temp1.next

        l3.print()
        return l3


if __name__ == '__main__':
    # test case 1:
    l1 = LinkedList()
    l2 = LinkedList()

    arr_1 = [4, 6, 8, 10, 12, 14]
    arr_2 = [10, 12, 14, 16, 18]

    for i in range(len(arr_1)):
        l1.append(arr_1[i])

    for i in range(len(arr_2)):
        l2.append(arr_2[i])

    print('\n \n input linked lists are :')
    l1.print()
    l2.print()

    get_intersection_obj = LinkedListIntersection()
    ll_intersection = get_intersection_obj.get_intersection(l1.head, l2.head)
    print("OUTPUT : the intersection of the linked lists is: \n")
    ll_intersection.print()
