package com.structTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class VirticalOrderTraverstal {
	private int max=0,min=0;
	Map<Integer, LinkedList<Integer>> table = new HashMap<Integer, LinkedList<Integer>>();
private static class Tree {
	private int data,pos;
	private Tree left,right;
	public Tree(int data) {
		// TODO Auto-generated constructor stub
	this.data=data;
	this.pos=0;
	this.left=this.right=null;
	}
}

public void getPositions(Tree head,int pos){
	if(head==null){
		return;
	}
	
	head.pos=pos;
	if(max<pos)
		max=pos;
	if(min>pos)
		min=pos;
	if(table.containsKey(pos)){
		System.out.println("appending to entry= "+pos);
		table.get(pos).add(head.data);
	}
	else{
		System.out.println("adding entry= "+pos);
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(head.data);
		table.put(pos, ll);
	}
	if(head.left!=null)
		getPositions(head.left,pos-1);
	if(head.right!=null)
		getPositions(head.right, pos+1);
}

public static void inOrder(Tree node,int pos){
	if(node==null)
		return;
	inOrder(node.left,pos);
	if(node.pos==pos)
	System.out.println("value= "+node.data);
	inOrder(node.right,pos);
}

public static void main(String args[]){
	Tree root = new Tree(1);
	root.left= new Tree(2);
	root.right= new Tree(3);
	root.left.left= new Tree(4);
	root.left.right= new Tree(5);
	root.right.left= new Tree(6);
	root.right.right= new Tree(7);
	root.right.left.right= new Tree(8);
	root.right.right.right= new Tree(9);
//	inOrder(root);
	VirticalOrderTraverstal obj = new VirticalOrderTraverstal();
	obj.getPositions(root, 0);
	
	
	
for (int i = obj.min; i <= obj.max; i++) {
	System.out.println(obj.table.get(i));
}
}
}
