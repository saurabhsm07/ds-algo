class Node:
    def __init__(self, val):
        self.key = val
        self.left = None
        self.right = None

    def __str__(self):
        return str(self.key);


class BinaryTree:
    def __init__(self, Node):
        if Node is not None:
            self.root = Node
        else:
            self.root = None

    def add_node(self, val, queue=[], current_node=None):
        print(val, current_node)
        if current_node is None:
            current = self.root
        else:
            current = current_node

        if current is None:
            current = Node(val)
            return
        elif current.left is None:
            current.left = Node(val)
            return
        elif current.right is None:
            current.right = Node(val)
            return
        else:
            queue.append(current.left)
            queue.append(current.right)
            self.add_node(val, queue, queue.pop())

    def print_nodes(self, current_node=None):
        if current_node is None:
            current = self.root
        else:
            current = current_node

        print(current)
        if current.left is not None:
            self.print_nodes(current.left)
        if current.right is not None:
            self.print_nodes(current.right)


if __name__ == '__main__':
    btree = BinaryTree(Node(1))
    btree.add_node(2)
    btree.add_node(3)
    btree.add_node(4)
    btree.add_node(5)
    btree.add_node(6)

    btree.print_nodes()