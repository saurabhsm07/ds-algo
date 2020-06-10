package com.structTree;
/**
 * 
 * @author saurabh_mahambrey
 *Given a Binary Tree, print left view of it. 
 *Left view of a Binary Tree is set of nodes visible when tree is visited from left side.
 */
public class PrintLeftViewOfTree {
TreeNode root;
static int max=0;
	static class TreeNode{
		int data;
		
		TreeNode left,right;
		public TreeNode(int data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
	
	public void printLeftTree(TreeNode node,int level){
		if((node!=null)){
			if(level>max){
				System.out.println(node.data);
				max=level;
			}
			printLeftTree(node.left, level+1);
			printLeftTree(node.right, level+1);
		}
			
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  PrintLeftViewOfTree tree = new PrintLeftViewOfTree();
  tree.root = new TreeNode(12);
  tree.root.left = new TreeNode(10);
  tree.root.right = new TreeNode(30);
  tree.root.right.left = new TreeNode(25);
  tree.root.right.right = new TreeNode(40);
  
  tree.printLeftTree(tree.root,1);
	}

}
