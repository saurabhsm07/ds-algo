package com.structTree;

import com.structures.TreeNode;

public class DeleteNodeBST {

public TreeNode DeleteNode(TreeNode node, int key){
	if(node==null){
		return node;
	}
	
	 if(node.data>key){
		node.left = DeleteNode(node.left, key);
	}
	else if (node.data<key){
		node.right = DeleteNode(node.right, key);
	}
	else {
		if(node.left==null){
			return node.right;
		}
		else if(node.right==null){
			return node.left;
		}
		else {
			//assign the new root of the in order successor 
			int minNode = findMin(node.right);
			node.data= minNode;
			//delete that node from tree
			node.right = DeleteNode(node.right,node.data);
		}
	
	}
	return node;
}

private static int findMin(TreeNode node) {
	// TODO Auto-generated method stub
	int min = node.data;
	while(node.left!=null){
	min = node.left.data;
	node=node.left;
		}
	return min;
}

public static void main(String args[]){

TreeNode root =BinarySearchTree.createBST();

DeleteNodeBST obj = new DeleteNodeBST();
root =obj.DeleteNode(root,50);
TreeTraversal.inOrder(root);
System.out.println();

root =obj.DeleteNode(root,70);
TreeTraversal.inOrder(root);
System.out.println();
root =obj.DeleteNode(root,20);
TreeTraversal.inOrder(root);
System.out.println();
}
}
