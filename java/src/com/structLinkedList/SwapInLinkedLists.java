package com.structLinkedList;

public class SwapInLinkedLists {
Node head;
	static class Node{
		int data;
		Node node;
		public Node(int data) {
			// TODO Auto-generated constructor stub
			this.data=data;
			node=null;
		}
	}
	/**
	 * @param args
	 */
	public void push(Node element){
	
	if(head==null){
		head = element;
	}
	else{
		Node temp= head;
		head = element;
		element.node = temp;
	}
	}
	
	public void print(){
		Node next = head;
		if(head==null){
			System.out.println("no elements in linkedlist");
			return;
		}
		while(next!=null){
			System.out.print(next.data+"  ");
			next = next.node;
		}
	System.out.println();
	}
	
	public void swapElements(int a ,int b){
		Node next = head,prev1=null,prev2=null,ele1=null,ele2=null,prev=null;
		boolean fl1=false,fl2=false;
		while(next!=null){
			if(a==next.data){
				
				 prev1 = prev;
				 ele1 = next;
				fl1=true;
			}
			if(b==next.data){
				prev2 = prev;
				 ele2 = next;
				fl2=true;
			}
			 prev = next;
			 next = next.node;
		}
		if(fl1==true && fl2 == true){

			  // If x is not head of linked list
	        if (prev1 != null)
	            prev1.node = ele2;
	        else //make y the new head
	            head = ele2;
	 
	        // If y is not head of linked list
	        if (prev2 != null)
	            prev2.node= ele1;
	        else // make x the new head
	            head = ele1;
	 
	        // Swap next pointers
	        Node temp = ele1.node;
	        ele1.node= ele2.node;
	        ele2.node = temp;
			
		}
		else {
			System.out.println("one of the elements does not exist");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwapInLinkedLists LLObj = new SwapInLinkedLists();
Node ele1 = new Node(10);
Node ele2 = new Node(20);
Node ele3 = new Node(30);
Node ele4 = new Node(40);

LLObj.push(ele1);
LLObj.push(ele2);
LLObj.push(ele3);
LLObj.push(ele4);
LLObj.print();

LLObj.swapElements(30, 10);
LLObj.print();
}

}
