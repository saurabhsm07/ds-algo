package com.structLinkedList;


public class ReverseListInGroupsOfK {
Node head;

class Node{
	int data;
	Node next;
	public Node(int data) {
		// TODO Auto-generated constructor stub
	this.data=data;
	}

}


public void addNode(int data) {
if(head==null){
head=new Node(data);
}
else {
Node itr = head;
while(itr.next!=null){
	itr=itr.next;
}
itr.next = new Node(data);
}
}

public void reverse(){
Node prev,front,itr;
prev = null;
itr=head;
while (itr.next!=null) {

front=itr.next;
itr.next=prev;
prev=itr;
itr=front;

}
itr.next=prev;
head=itr;
}

public Node reverseGroupsOfK(int k,Node head){
	Node front=null,itr,prev=null;
	
	itr=head;
	for (int i = 0; i < k && itr!=null;i++) {
		front=itr.next;
		itr.next=prev;
		prev=itr;
		itr=front;
	}
	
	
	
	
	if(front!=null){
		System.out.println("head= "+itr.data+" "+"prev= "+head.data);
		head.next=reverseGroupsOfK(k, itr);}
	return prev;
}

public void printList(){
	Node itr =head;
	while (itr!=null) {
		System.out.print(itr.data+" ");
		itr=itr.next;
	}
	System.out.println();
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReverseListInGroupsOfK list1 = new ReverseListInGroupsOfK();
		list1.addNode(1);
		list1.addNode(2);
		list1.addNode(3);
		list1.addNode(4);
		list1.addNode(5);
		list1.addNode(6);
		list1.addNode(7);
		list1.addNode(8);
//		list1.addNode(9);


System.out.println("original List");
		list1.printList();
//		System.out.println("after reversal");
//		list1.reverse();
//		list1.printList();
		System.out.println("reversal in groups of k");
		System.out.println("head= "+list1.head.data+" "+"prev= "+0);
		
		list1.head=list1.reverseGroupsOfK(5,list1.head);
		
		list1.printList();
	}

}
