package com.structTree;

import com.structures.*;


public class BinaryTree {
TreeNode root;

public BinaryTree(int data) {
	// TODO Auto-generated constructor stub
root = new TreeNode(data);
}
public BinaryTree() {

	root=null;// TODO Auto-generated constructor stub
}
public TreeNode createTree(){
	root = new TreeNode(1);
	root.left = new TreeNode(2);
	root.right = new TreeNode(3);
	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);
	root.right.left = new TreeNode(6);
	root.right.right = new TreeNode(7);
	root.left.left.left = new TreeNode(8);
	return root;

}

public TreeNode createDiameterTree(){
	root = new TreeNode(1);
	root.left = new TreeNode(2);
	root.right = new TreeNode(3);
	root.left.left = new TreeNode(4);
	root.left.left.left = new TreeNode(5);
	root.left.left.left.left = new TreeNode(6);
	root.left.right = new TreeNode(7);
	
	root.left.right.right = new TreeNode(8);
	root.left.right.right.right = new TreeNode(9);
	root.left.right.right.right.right = new TreeNode(10);
	
	return root;
}
}
