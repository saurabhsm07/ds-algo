package com.structTree;

import com.structures.TreeNode;

/**
 * @author saurabh_mahambrey
 *converting BST to BT using depending on problem statement
 */
public class BstToBt {
 /**
 * PS: Given a Binary Search Tree (BST), convert it to a Binary Tree such that every key of the original BST 
 * is changed to key plus sum of all greater keys in BST
 */
	
	/**
	 * static variable used to add values to the node.data
	 */
	private static int ValueToAdd=0;
public void createBT1(TreeNode root){
	 if(root.right!=null){
		 createBT1(root.right);
      }
	 root.data+=ValueToAdd;
	 ValueToAdd=root.data;
	 
	 if(root.left!=null){
		 createBT1(root.left);
	 }
 }
public static void main(String[] args) {
BstToBt obj = new BstToBt();	 
	TreeNode root=BinarySearchTree.createBST();
	  /* Let us create following BST
          50
       /     \
     30      70
    /  \    /  \
  20   40  60   80 
                 \
                 90*/
 obj.createBT1(root);
	 
TreeTraversal.inOrder(root);
}
}
