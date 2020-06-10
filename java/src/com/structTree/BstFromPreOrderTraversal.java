package com.structTree;

import com.structures.TreeNode;

import java.util.Stack;

/**
 * 
 * @author saurabh_mahambrey 
 *
 *problem statement:
 *Construct BST from given preorder traversal | Set 1
Given preorder traversal of a binary search tree, construct the BST.

For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be root of following tree.

     10
   /   \
  5     40
 /  \      \
1    7      50

solution :
1:createBstRecursive
( O(n) time complexity )
The idea used here is inspired from method 3 of this post. The trick is to set a range {min .. max} for every node.
 Initialize the range as {INT_MIN .. INT_MAX}. The first node will definitely be in range, so create root node. 
 To construct the left subtree, set the range as {INT_MIN �root->data}. 
 If a values is in the range {INT_MIN .. root->data}, the values is part part of left subtree.
 To construct the right subtree, set the range as {root->data..max .. INT_MAX}.
 
 2:createBstItrStack
1. Create an empty stack.
2. Make the first value as root. Push it to the stack.
3. Keep on popping while the stack is not empty and the next value is greater than stack�s top value. 
   Make this value as the right child of the last popped node. Push the new node to the stack.
4. If the next value is less than the stack�s top value, make this value as the left child of the stack�s top node. 
   Push the new node to the stack.
5. Repeat steps 2 and 3 until there are items remaining in pre[].
 */
public class BstFromPreOrderTraversal {
private TreeNode root;
public void bstFromPreorder(int arr[]){
    int min=Integer.MIN_VALUE;
    int max=Integer.MAX_VALUE;
    root=new TreeNode(arr[0]);
    for (int i = 1; i < arr.length; i++) {
		if(arr[i]<root.data)
    	root.left=createBstRecursive(root.left,arr[i],min,root.data);
		else
		root.right=createBstRecursive(root.right,arr[i],root.data,max);
	}
}
private TreeNode createBstRecursive(TreeNode node, int val, int min, int max) {
	// TODO Auto-generated method stub
	if(node==null){
		 return new TreeNode(val);
	}
	else if(node.data>val && val> min){
		node.left=createBstRecursive(node.left,val,min,node.data);
	}
	else{
		node.right=createBstRecursive(node.right,val,node.data,max);
	}
	return node;
}

private TreeNode createBstItrStack(int ipArr[]){
	Stack<TreeNode>  stack= new Stack<TreeNode>();
	 root=new TreeNode(ipArr[0]);
	stack.add(root);
	for (int i = 1; i < ipArr.length; i++) {
	
		if(ipArr[i]>stack.peek().data){
			TreeNode temp=null;
		while(!stack.isEmpty()&& ipArr[i]>stack.peek().data){
			System.out.println(stack+" "+ipArr[i]);
			temp=stack.pop();
		}
		System.out.println(temp.data+" --->"+ipArr[i]);
		temp.right=new TreeNode(ipArr[i]);
		if(ipArr.length>=i)
		stack.push(new TreeNode(ipArr[i]));
		temp=null;
		System.out.println(stack);
		}
		else {
			stack.peek().left=new TreeNode(ipArr[i]);
			stack.push(stack.peek().left);
		}
	}
return root;
}


public static void main(String[] args) {
 BstFromPreOrderTraversal obj = new BstFromPreOrderTraversal();
// obj.bstFromPreorder(new int[]{10, 5, 1, 7, 40, 50});
 
 obj.createBstItrStack(new int[]{10, 5, 1, 7, 40, 50});
 TreeTraversal.inOrder(obj.root);
 System.out.println();
 TreeTraversal.preOrder(obj.root);
 
}
}
