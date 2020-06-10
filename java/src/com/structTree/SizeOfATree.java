package com.structTree;

/**
 * 
 * @author Saurabh
 *
 *problem statement :
 *Size() function recursively calculates the size of a tree. It works as follows:

Size of a tree = Size of left subtree + 1 + Size of right subtree.

 *solution :
 *size(tree)
1. If tree is empty then return 0
2. Else
     (a) Get the size of left subtree recursively  i.e., call 
          size( tree->left-subtree)
     (a) Get the size of right subtree recursively  i.e., call 
          size( tree->right-subtree)
     (c) Calculate size of the tree as following:
            tree_size  =  size(left-subtree) + size(right-
                               subtree) + 1
     (d) Return tree_size
 */
public class SizeOfATree {
	Node root;

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			super();
			this.data = data;
			this.left = this.right = null;
		}

	}

	/**
	 * 
	 * @param root
	 *            // node of the tree
	 * @return //size of the subtree
	 */
	public static int getSizeOfTree(Node root) {
		if (root != null) {
			return 1 + getSizeOfTree(root.right) + getSizeOfTree(root.left);
		} else
			return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SizeOfATree tree = new SizeOfATree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("The size of binary tree is : " + getSizeOfTree(tree.root));
	}

}
