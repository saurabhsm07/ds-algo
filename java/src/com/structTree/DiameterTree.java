package com.structTree;

import com.structures.*;


public class DiameterTree {

	/**diameter is the longest distance between the leaf nodes of a tree 
	 * ref = http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
	 * @param args
	 */
	static int diameter=0,left=0,right=0;
	public static int findDiameter(TreeNode node){
int left,right;

		if(node==null)
			return 0;
		else{
		 left=findDiameter(node.left);
		 right=findDiameter(node.right);
	
	    if(diameter<left+right){
	    	System.out.println("CHANGE diameter = "+diameter+" new diameter ="+left+right);
		  diameter = left+right;
	    }
	    else{
	    	System.out.println("NO CHANGE diameter = "+diameter+" new diameter ="+left+right);
	    }
	    if(left>right)
			return left+1;
			else 
				return right+1;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
BinaryTree tree = new BinaryTree();
   findDiameter(tree.createDiameterTree());
	System.out.println("diameter = "+diameter);
	}

}
