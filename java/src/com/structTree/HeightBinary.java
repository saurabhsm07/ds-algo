package com.structTree;

import com.structures.*;


public class HeightBinary {

	/**
	 * @param args
	 * finding max height of a binary tree
	 */
	
	public static int getHeight(TreeNode node){
		if(node==null){
			return 0;
		}
		int leftHeight=0,rightHeight=0;
		
		leftHeight=leftHeight+getHeight(node.left);
		rightHeight= rightHeight+getHeight(node.right);
		
		
	  if(leftHeight>rightHeight){
		return leftHeight+1;
	}
	else {
		return rightHeight+1;
	}}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        BinaryTree tree = new BinaryTree();
        System.out.println("height of the tree ="+getHeight(tree.createTree()));
	}

}
