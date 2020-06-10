package com.problemSolutions;

import com.structTree.BinaryTree;
import com.structures.*;

import java.util.HashMap;
import java.util.Map;



public class PrintVerticalNodes {
	
	class Values{
		int min,max;
	}
	class HashLink {
		int data;
		HashLink next;
	public HashLink(int data,HashLink next) {
		// TODO Auto-generated constructor stub
	this.data=data;
	this.next=next;
	}
	}
	
	Map<Integer, HashLink> hashMap = new HashMap<Integer, HashLink>();
	Values value = new Values();
	
public void preOrder(TreeNode node,Values value,int hd){
if(node==null)
	return;
if(value.min>hd)
	value.min=hd;
if(value.max<hd)
	value.max=hd;

HashLink LL = hashMap.get(hd);
 if(LL==null){
	
	 hashMap.put(hd,new HashLink(node.data,null));
 }
 else{
	 while(LL.next!=null){
		 LL = LL.next;
		 System.out.println("abc");
		 }
 LL.next=new HashLink(node.data, null);

 }
preOrder(node.left, value, hd-1);
preOrder(node.right, value, hd+1);
}

public void printOrder(TreeNode node){
	preOrder(node, value, 0);
	for (int i = value.min; i <= value.max; i++) {
		printList(hashMap.get(i));
	}
}

private static void printList(HashLink hashLink) {
	// TODO Auto-generated method stub
	while (hashLink!=null) {
		System.out.print(hashLink.data+"  ");
	hashLink=hashLink.next;
	}
System.out.println();
}

public static void main(String args[]){
	PrintVerticalNodes obj = new PrintVerticalNodes();
	obj.printOrder(new BinaryTree().createTree());
	
}
}
