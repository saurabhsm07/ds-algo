package com.structLinkedList;

public class MergeAltNodes {
	Node head;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
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
	
	public void printList(){
		Node itr =head;
		while (itr!=null) {
			System.out.print(itr.data+" ");
			itr=itr.next;
		}
		System.out.println();
	}
	
	public void createMergeList(Node head1,Node head2){
		Node temp1 = head1.next;
		Node temp2=head2;
		head = new Node(head1.data);
		Node itr = head;
		while ((temp1!=null) && (temp2!=null)) {
		itr.next = new Node(temp2.data);
		itr.next.next = new Node(temp1.data);
		itr = itr.next.next;
		temp1=temp1.next;
		temp2=temp2.next;
		}
		
		if(temp1!=null){
			while(temp1!=null){
			itr.next=temp1;
			itr=itr.next;
			temp1=temp1.next;
			}
		}
		
		if(temp2!=null){
			while(temp2!=null){
			itr.next=temp2;
			itr=itr.next;
			temp2=temp2.next;
			}
		}
	}

	public static void main(String[] args) {
		MergeAltNodes list1 = new MergeAltNodes();
		MergeAltNodes list2 = new MergeAltNodes();
		list1.addNode(1);
		list1.addNode(3);
		list1.addNode(5);
		list1.addNode(7);
		list1.addNode(9);
		list1.addNode(11);
		list1.addNode(13);
		list1.addNode(15);
		list1.addNode(17);
		list2.addNode(2);
		list2.addNode(4);
		list2.addNode(6);
		list2.addNode(8);
		list2.addNode(10);
//		list2.addNode(12);
//		list2.addNode(14);
//		list2.addNode(16);

	System.out.println("Ptinting list 1");
	list1.printList();
	
	System.out.println("Ptinting list 2");
	list2.printList();
	
	System.out.println("combining and printing a list 3 by alternate insertion of elements of list1 and list2");
	MergeAltNodes list3 = new MergeAltNodes();
	
	list3.createMergeList(list1.head,list2.head);
	list3.printList();
	}
}
