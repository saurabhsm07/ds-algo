package com.structLinkedList;

enum Option
{ 
    Start, Before, After,End; 
} 
public class DoublyLinkedList {
 Node head;
	public class Node{
		int data;
		Node prev,next;
		public Node(int data) {
			super();
			this.data = data;
			this.prev = this.next=null;
		}
	
	}
		/**
		 * @param data :data to be added
		 * @param option : type of insertion to be performed
		 */
		public void addNode(int data,int posEle,Option option){
			switch(option){
			case After:
                 addNodeAfterPos(data, posEle);
				break;
			case Before:
				addNodeBeforePos(data, posEle);
				break;
			case End:
				addNodeAtEnd(data);
				break;
			case Start:
				addNodeAtStart(data);
				break;
				
			 default:
				System.out.println("no such insertion allowed");
				break;
				
			}
		}


		protected void addNodeAtEnd(int data) {
			Node ele = new Node(data);
			if (head==null) {
				head = new Node(data);
			} else {
			    Node itr= head;
			    while(itr.next!=null){
			    	itr=itr.next;
			    }
			itr.next=ele;
			ele.prev=itr;
			}
		}


		protected void addNodeBeforePos(int data, int posEle) {
			Node ele = new Node(data);
			if(head==null){
				head= new Node(data);
			
			}
			else {
				Node itr = head;
				while (itr.next!=null && itr.data!=posEle) {
				itr=itr.next;
				}
				if(itr.next==null){
				itr.next=ele;
				ele.prev=itr;
				}
				else {
					ele.next=itr;
					ele.prev=itr.prev;
					itr.prev.next=ele;
					itr.prev=ele;
				}
			}
		}


		protected void addNodeAfterPos(int data, int posEle) {
			if(head==null){
				 addNodeAtStart(data);
   
			 }
			 else {
				 Node itr=head;
				 Node ele = new Node(data);
				 while ( itr.next!=null && itr.data!=posEle ) {
					 itr=itr.next;
					}
				 if(itr.next==null){
					
					 itr.next=ele;
					 
				 }
				 else{
				     ele.prev=itr;
				     ele.next=itr.next;
				     itr.next.prev=ele;
				     itr.next=ele;
				 }
			 }
		}


		protected void addNodeAtStart(int data) {
			if (head==null) {
				head = new Node(data);
			}
			else {
				Node ele = new Node(data);
				ele.next=head;
				head.prev=ele;
				head=ele;
			}
		}
	
		protected void printDLL(){
			Node itr=head;
			while(itr!=null){
				System.out.print(itr.data+"-->");
				itr=itr.next;
			}
		}
		public static void main(String[] args) {
			DoublyLinkedList obj = new DoublyLinkedList();
			obj.addNode(5, 21, Option.After);
			obj.addNode(2, 5, Option.After);
			obj.addNode(1, 5, Option.After);
			obj.addNode(21, 2, Option.After);
			obj.addNode(34, 1, Option.After);
			obj.addNode(16, 34, Option.Before);
			obj.addNode(16, 0, Option.Start);
			obj.addNode(16, 0, Option.End);
			obj.printDLL();
		}
	}

