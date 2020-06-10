package com.structHeap;
/**
 * 
 * @author saurabh_mahambrey //full source GEEKS FOR GEEKS
 *
 *problem statement :
 *Given a binary tree we need to check it has heap property or not, 
 *Binary tree need to fulfill following two conditions for being a heap �
   It should be a complete tree (i.e. all levels except last should be full).
   Every node�s value should be greater than or equal to its child node 
   (considering max-heap).
   
   solution:
   check if heap :
   isHeapUtil function is written considering following things �

Every Node can have 2 children, 0 child (last level nodes) or 1 child (there can be at most one such node).
If Node has No child then it�s a leaf node and return true (Base case)
If Node has one child (it must be left child because it is a complete tree) then we need to compare this node with its single child only.
If Node has both child then check heap property at Node at recur for both subtrees.
Complete code.

check if complete tree:

Hence we proceed in the following manner in order to check if the binary tree 
is complete binary tree.
Calculate the number of nodes (count) in the binary tree.
Start recursion of the binary tree from the root node of the binary tree with index (i) being set as 0 and the number of nodes in the binary (count).
If the current node under examination is NULL, then the tree is a complete binary tree. Return true.
If index (i) of the current node is greater than or equal to the number of nodes in the binary tree (count) i.e. (i>= count), 
then the tree is not a complete binary. Return false.
Recursively check the left and right sub-trees of the binary tree for same condition. 
For the left sub-tree use the index as (2*i + 1) while for the right sub-tree use the index as (2*i + 2).
 */
public class IfBinaryTreeIsHeap {

	/**
	 * @param args
	 *
	 */
	
 static class TreeNode{
	int data;
	TreeNode left,right;
	public TreeNode(int data) {
		// TODO Auto-generated constructor stub
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
 
 public boolean isCompleteTree(int nodeCount,TreeNode node,int pos){
	 if(node==null)
		 return true;
	 
	 if((node!=null)&&(pos<nodeCount)){
		 return isCompleteTree(nodeCount, node.left, pos*2+1)&&isCompleteTree(nodeCount, node.right, pos*2+2);
	 }
	 System.out.println(node.data);
	 return false;
 }
 
 public boolean isHeapStructure(TreeNode root){
	 if(root==null)
		 return true;
	 if((root.left!=null)&&(root.right!=null)&&(root.left.data<root.data)&&(root.right.data<root.data)){
		 return isHeapStructure(root.left)&&isHeapStructure(root.right);
	 }
	 if((root.left!=null)&&(root.right==null)&&(root.left.data<root.data)){
		 return isHeapStructure(root.left);
	 }
	 if((root.left==null)&&(root.right!=null)&&(root.right.data<root.data)){
		 return isHeapStructure(root.right);
	 }
	 if((root.left==null)&&(root.right==null)){
		 return true;
	 }
	 
	 return false;
 }
 
 public static int countNodes(TreeNode root){
	 if(root==null){
		 return 0;
	 }
	 return 1+countNodes(root.left)+countNodes(root.right);
	 
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(0);
        int totalNodes=countNodes(root);
        System.out.println("total nodes= "+totalNodes);
        System.out.println(new IfBinaryTreeIsHeap().isCompleteTree(totalNodes, root, 0)&& new IfBinaryTreeIsHeap().isHeapStructure(root));
//        System.out.println(new IfBinaryTreeIsHeap().isHeapStructure(root));
	}

}
