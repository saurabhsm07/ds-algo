"""
Problem Statement: perform basic operations on a linked list : Add, Delete etc
"""


# single node structure :

class Node:

    def __init__(self, data):
        self.data = data
        self.next = None


# Linked List structure :

class LinkedList:

    def __init__(self):
        self.head = None

    def push(self, ele):
        """
        adds element to the beginning of the linked list
        :return: void
        """

        if self.head is None:
            self.head = Node(ele)
        else:
            new_node = Node(ele)
            new_node.next = self.head
            self.head = new_node

    def append(self, ele):
        """
        adds element to the end of the linked list
        :param ele: element to be added at the end
        :return: void
        """

        if self.head is None:
            self.head = Node(ele)
        else:
            temp = self.head
            while temp.next is not None:
                temp = temp.next

            temp.next = Node(ele)

    def add_at(self, ele, pos):
        """
        method adds an element to the given location in the linked list
        :param ele: element to be added in the linked list
        :param pos: location at which element is to be added
        :return: void
        """
        temp = self.head

        i = 1
        while i < pos-1 and temp.next is not None:
            temp = temp.next
            i += 1
        if temp.next is not None and i == pos - 1:
            new_data = Node(ele)
            new_data.next = temp.next
            temp.next = new_data

        else:
            print('\n \n position {} is out of bound for this linked list'.format(pos))

    def get(self, key, search_type='element'):
        """
        method returns the position of the given element or element at the given position in the linked list
        :param search_type: 'element' or 'position' based search
        :param key: position/ value of the element to be found
        :return position or value based on input search type
        """
        if search_type == 'element':
            temp = self.head

            pos = 0
            while temp.data != key and temp.next is not None:
                temp = temp.next
                pos += 1

            if temp.next is None:
                print('\n \n element {} does not exist in the linked list'.format(key))
                return -1
            return pos + 1
        elif search_type == 'position':
            temp = self.head

            i = 0
            while i < key-1 and temp is not None:
                temp = temp.next
                i += 1
            if temp is None:
                print('\n position {} is out of bounds for this linked list'.format(key))
                return -1

            return temp.data

        else:
            print('search unsupported or spelling error INPUT GIVEN = {}'.format(search_type))

    def delete(self, ele):
        """
        method removes the given element from the linked list
        :param ele: element to be removed from the linked list
        :return: void
        """

        if self.head is None:
            print('Linked list is empty');
        else:
            temp = self.head
            if temp.data == ele:
                temp = temp.next
                self.head = temp
            else:
                temp_prev = temp
                temp = temp.next
                while temp.next is not None and temp.next.data != ele:
                    temp = temp.next

                if temp.next is None:
                    print('\n \n the element {} does not exist in the given linked lit'.format(ele))
                else:
                    print('successfully deleted  element {}'.format(temp.next.data))
                    temp.next = temp.next.next

    def find_length_recursive(self, node):
        """
        method finds the length of the linked list recursively
        :param node: current node of the linked list
        :return: length of the linked list
        """
        if node is None:
            return 0
        else:
            return 1 + self.find_length_recursive(node.next)

    def search_node_recursive(self, node, key):
        """
        method searches for a node of a linked list recursively
        :param node: current node of the linked list
        :param key: element to be found
        :return: position of the element
        """
        if node is None:
            print('node does not exist')
            return -1000
        elif node.data == key:
            return 1
        else:
            return self.search_node_recursive(node.next, key) + 1

    def print(self):
        """
        Prints the elements in the linked list
        :return:
        """

        print('\n Linked Lists contents are : \n')
        temp = self.head
        if temp is None:
            print('no elements in the linked list')
        else:
            while temp is not None:
                print(temp.data, " - >", end=" ")
                temp = temp.next


if __name__ == '__main__':
    linked_list = LinkedList()

    # test linked list push method:
    input_arr = [1, 2, 4, 5, 11]
    for i in range(len(input_arr)):
        linked_list.push(input_arr[i])

    linked_list.print()

    # test linked list append method:
    linked_list.append(23)
    linked_list.print()

    # test linked list add at method:
    linked_list.add_at(22, 2)
    linked_list.print()

    linked_list.add_at(13, 4)
    linked_list.print()

    linked_list.add_at(8, 55)

    # test linked list find at method:
    pos = 31
    data = linked_list.get(pos, 'position')
    if data != -1:
        print('element as position {} = {}'.format(pos, data))

    ele = 2
    data = linked_list.get(ele, 'element')
    if data != -1:
        print('position of element {} = {}'.format(ele, data))

    # test linked list delete an element:
    ele = 13
    linked_list.delete(ele)
    linked_list.print()

    # ele = 11
    # linked_list.delete(ele)
    # linked_list.print()
    #
    # ele = 23
    # linked_list.delete(ele)
    # linked_list.print()
    #
    # ele = 111
    # linked_list.delete(ele)
    # linked_list.print()

    # test find linked list length:
    length = linked_list.find_length_recursive(linked_list.head)
    print('\n \n LENGTH of the linked list =  ', length)

    # find node of the linked list:
    linked_list.print()
    ele = 1
    location = linked_list.search_node_recursive(linked_list.head, ele)

    if location < 0:
        print('\n \n  element {} does not exist in l.l'.format(ele))
    else:
        print('the element {} is present at location = {}'.format(ele, location))
