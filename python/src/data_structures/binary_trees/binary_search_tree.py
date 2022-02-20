class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __repr__(self):
        return str(self.val)

class BinarySearchTree(TreeNode):
    def __init__(self, head):
        head = TreeNode()


object = BinarySearchTree(2)
print(object)