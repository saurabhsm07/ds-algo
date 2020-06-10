package com.structTree;

import com.structures.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {
/**Algorithm Preorder(tree)
   1. Visit the root.
   2. Traverse the left subtree, i.e., call Preorder(left-subtree)
   3. Traverse the right subtree, i.e., call Preorder(right-subtree) 
 * 
 * @param node
 */
public static void  preOrder(TreeNode node){
	if(node==null)
		return;
	System.out.print("  "+node.data);
	preOrder(node.left);
	preOrder(node.right);
}

/**Algorithm Inorder(tree)
   1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   2. Visit the root.
   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
 * 
 * @param node
 */
public static void inOrder(TreeNode node){
	if(node==null)
		return;
	inOrder(node.left);
	System.out.print("  "+node.data);
	inOrder(node.right);
}

/**Algorithm Postorder(tree)
   1. Traverse the left subtree, i.e., call Postorder(left-subtree)
   2. Traverse the right subtree, i.e., call Postorder(right-subtree)
   3. Visit the root.
 * 
 * @param node
 */
public static void postOrder(TreeNode node){
	if(node==null)
		return;
	
	postOrder(node.left);
	postOrder(node.right);
	System.out.print("  "+node.data);
}

/**Algorithm:
For each node, first the node is visited and then it�s child nodes are put in a FIFO queue.

printLevelorder(tree)
1) Create an empty queue q
2) temp_node = root //start from root
3) Loop while temp_node is not NULL
    a) print temp_node->data.
    b) Enqueue temp_node�s children (first left then right children) to q
    c) Dequeue a node from q and assign it�s value to temp_node
 * 
 * @param node
 */
public static void leverOrder(TreeNode node){
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	queue.add(node);
	while(!queue.isEmpty()){
		TreeNode temp = queue.poll();
		if(temp==null)
			return;
		System.out.print("  "+temp.data);
		if(temp.left!=null)
		queue.add(temp.left);
		if(temp.right!=null)
		queue.add(temp.right);
		
	}
}

public static void inOrderStack(TreeNode node){
	Stack<TreeNode> stack = new Stack<TreeNode>();
	
	TreeNode current = node;
	while (current!=null) {
		stack.push(current);
		current=current.left;
		
	}
	while(!stack.isEmpty()){
		current= stack.pop();
		System.out.print("  "+current.data);
		current=current.right;
		while (current!=null) {
			stack.push(current);
			current=current.left;
			
		}
	}
	
}


public static void inOrderThreaded(TreeNode node){
	TreeNode current = node;
while (current!=null) {
	if(current.left==null){
		System.out.print("  "+current.data);
		current=current.right;
	}
	else{
		TreeNode preConn = current.left;
		while(preConn.right!=null && preConn.right!=current){
			preConn=preConn.right;
		}
		if(preConn.right==null){
			preConn.right=current;
			current=current.left;
		}
		else{
			System.out.print("  "+current.data);
			current=current.right;
			preConn=null;
		}
	}
}
}
public static void main(String args[]){
	BinaryTree tree = new BinaryTree();
	TreeNode node=null;
	node=tree.createTree();
	System.out.println("pre-order");
	preOrder(node);
	System.out.println("\nin-order");
	inOrder(node);
	System.out.println("\npost-order");
	postOrder(node);
	System.out.println("\nlevel-order");
    leverOrder(node);
    System.out.println("\nin-order with stack");
    inOrderStack(node);
    System.out.println("\nin-order with threads");
    inOrderThreaded(node);
}
}
