"""problem statement: You are given the root of a binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
If such a node does not exist, return null
"""


class Solution(object):
    def searchBST(self, root, val):
        """
        :type root: TreeNode
        :type val: int
        :rtype: TreeNode
        """

        return self.search_node(root, val)

    #     def in_order(self, root):
    #         if root:
    #             print(root.val)
    #             self.in_order(root.left)
    #             self.in_order(root.right)

    def search_node(self, root, val):
        if not root:
            return root
        else:
            # print(root)
            if root.val == val:
                return root
            elif root.val > val:
                return self.search_node(root.left, val)
            else:
                return self.search_node(root.right, val)
