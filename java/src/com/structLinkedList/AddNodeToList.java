package com.structLinkedList;

public class AddNodeToList {
	Node head;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
			next = null;
		}
	}

	public void addNode(int data) {
		if ((head == null)||(head.data > data)) {
			Node ele = new Node(data);
			ele.next=head;
			head = ele;
		}
		
			
			else {
			Node itr = head;
			
			while ((itr.next != null) && (itr.next.data < data)) {
            itr=itr.next;
			
			}
			if(itr.next!=null){
				Node ele = new Node(data);
				ele.next= itr.next;
				itr.next= ele;
			}
			else{
				itr.next = new Node(data);
			}
		}
	}

	public void printList(Node head) {
		System.out.println("Printing list");
while (head!=null) {
	System.out.print(head.data+" ");
head=head.next;
}
	}

	public static void main(String[] args) {
		//input data
		AddNodeToList llist = new AddNodeToList();
	         llist.addNode(5);
	         llist.printList(llist.head);
	         llist.addNode(10);
	         llist.printList(llist.head);
	         llist.addNode(7);
	         llist.printList(llist.head);
	         llist.addNode(3);
	         llist.printList(llist.head);
	         llist.addNode(1);
	         llist.printList(llist.head);
	         llist.addNode(9);
	         llist.printList(llist.head);
	         
	         System.out.println(llist.head.data);
	         
	}
}
