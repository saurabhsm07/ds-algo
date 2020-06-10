package com.structTree;

import com.structures.*;

public class BinarySearchTree {
	
	TreeNode root;
	
	public BinarySearchTree() {
		root=null;
	}
	
	/**
	 * @param args
	 */
//call recursive insert	
public  void insertBST(int data){
	root = insertNode(root,data);
}

//recursively traverse a tree and insert in a node
public TreeNode insertNode(TreeNode node,int data){
	if(node==null){
		node= new TreeNode(data);
		return node;
	}
	 if(node.data < data){
	
		node.right = insertNode(node.right, data);
	}
	else if(node.data > data){
		node.left =insertNode(node.left, data);
	}
	return node;
}

//public void createBST(){
//	
//}

public TreeNode deleteNode(TreeNode node,int data){
if(node==null)
	return null;
else{
if(node.data <data){

	node.right =deleteNode(node.right, data);
	
}
else if(node.data>data){

	node.left =deleteNode(node.left,data);
	
}
else {
	// node with two children: Get the inorder successor (smallest
    // in the right subtree)
	if(node.left!=null && node.right!=null){
		int val =FindInorder(node.right);
	node.data = val;
	
	node.right=deleteNode(node.right, node.data);
	}
	else if(node.left==null && node.right==null){
		
		return null;
	}
	else if(node.left==null && node.right!=null){
		 return node.right;
	
	}
	else{
		return node.left;
		
	}

}
return node;
}




}
public TreeNode testDeleteNode(TreeNode node,int data){
	if (node==null) {
		return null;
	}
	else{
		
	
	 if(node.data>data){
		node.left= testDeleteNode(node.left, data);
	}
	else if(node.data<data){
		node.right= testDeleteNode(node.right, data);
	}
	else{
		if((node.left==null)&&(node.right==null)){
			return null;
		}
		else if((node.left!=null)&&(node.right==null)){
			return node.left;
			
		}
		else if((node.right!=null)&&(node.left==null)){
			return node.right;
			
		}
		else{
	        node.data=findInorderSuccessor(node.right);
	        node.right=deleteNode(node.right, node.data);
			
		}
	}
		return node;
	}
	
}
private int findInorderSuccessor(TreeNode right) {
	// TODO Auto-generated method stub
	TreeNode temp = right;
	int data=0;
	while(temp!=null){
		right=temp;
		data=temp.data;
		temp=temp.left;
	}
	System.out.println("node is "+right.data);
	
//	System.out.println("data is"+data);
	return data;
}

private  int FindInorder(TreeNode node) {
	// TODO Auto-generated method stub
	while(node.left!=null){
	 node= node.left;
	}
	return node.data;
    
}

void inorder()  {
    inorderRec(root);
 }

 // A utility function to do inorder traversal of BST
 void inorderRec(TreeNode root) {
     if (root != null) {
         inorderRec(root.left);
         System.out.print(" "+root.data);
         inorderRec(root.right);
     }
     }
public static TreeNode createBST(){
	BinarySearchTree tree = new BinarySearchTree();
	 
    /* Let us create following BST
          50
       /     \
      30      70
     /  \    /  \
   20   40  60   80 
                   \
                     90*/
    tree.insertBST(50);
    tree.insertBST(30);
    tree.insertBST(20);
    tree.insertBST(40);
    tree.insertBST(70);
    tree.insertBST(60);
    tree.insertBST(80);
    tree.insertBST(90);
    tree.insertBST(75);
//	
//    tree.inorder();
    return tree.root;
   
}

public static void main(String[] args) {
	BinarySearchTree obj = new BinarySearchTree();
	obj.root=createBST();

obj.inorder();
System.out.println();
  obj.root=obj.testDeleteNode(obj.root, 80);
 
  obj.inorder();

}
}
