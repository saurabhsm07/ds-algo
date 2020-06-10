package com.structTree;

import com.structures.*;

public class findPredSuccBST {

	/**
	 * the problem is to find the 'inorder' predecessor and successor of a given
	 * tree node
	 * 
	 * @param args
	 */

	public static TreeNode findPredecessor(TreeNode node) {
		TreeNode predecessor = node;
		while (node.right != null) {
			predecessor = node.right;
			node = node.right;
		}
		return predecessor;
	}

	public static TreeNode findSuccessor(TreeNode node) {
		TreeNode successor = node;
		while (node.left != null) {
			successor = node.left;
			node = node.left;
		}
		return successor;
	}

	public static TreeNode findNode(TreeNode node, int key) {
		if (node == null) {
			return null;
		}

		if (node.data == key) {

			return node;
		} else {
			if (node.data > key) {

				return findNode(node.left, key);
			} else {

				return findNode(node.left, key);
			}
		}
	}

	public static void printPreSuc(TreeNode node, int key) {
		node = findNode(node, key);
		if (node != null) {
			if (node.left != null) {
				System.out.println(findPredecessor(node.left).data);
			}
			if (node.right != null) {
				System.out.println(findSuccessor(node.right).data);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
TreeNode root = BinarySearchTree.createBST();

printPreSuc(root, 110);
	}

}
