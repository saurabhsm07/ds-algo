package com.structLinkedList;

import java.util.Comparator;



public class DetectAndRemoveLoopLL {
	Node head;

	class Node  implements Comparator<Node>{
		int data;
		Node next;
		public Node(int data){
			// TODO Auto-generated constructor stub
		this.data=data;
		}

		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			
			return o1.data-o2.data;
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
	
	public void pushNode(int data){
		Node newNode = new Node(data);
		newNode.next=head;
		head=newNode;
	}
	
	public void printList(){
		Node itr =head;
		while (itr!=null) {
			System.out.print(itr.data+" ");
			itr=itr.next;
		}
		System.out.println();
	}
	
	public void findCycle(){
		Node itr1=head;
		Node itr2=head;
	
		while(itr1!=null && itr2!=null && itr2.next!=null){
		
			itr1=itr1.next;
		
			itr2=itr2.next.next;
			if(itr1.data==itr2.data){
				System.out.println("loop exists");
				break;
			}
				
		}
		if(itr1!=null && itr1==itr2){
		itr1=head;
		while(itr1!=itr2){
			itr1=itr1.next;
			itr2=itr2.next;
		}
		System.out.println("loop starts at element "+itr1.data);
		System.out.println("loop is ");
		while(itr1.next!=itr2){
			System.out.print(itr1.data+"-->");
		itr1=itr1.next;
		}
		System.out.print(itr2.data);
		}
	}
	
	public static void main(String[] args) {
		
		 DetectAndRemoveLoopLL llist = new DetectAndRemoveLoopLL();
		llist.pushNode(20);
	        llist.pushNode(4);
	        llist.pushNode(15);
	        llist.pushNode(10);
	        llist.head.next.next.next.next = llist.head;
//	        llist.printList();
	       llist.findCycle();
	
	}
}
