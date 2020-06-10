package com.structLinkedList;

public class AddTwoLinkedListNumbers {
	
	Node head;
	class Node{
		int data;
		Node next;
		public Node(int data) {
			super();
			this.data = data;
			this.next=null;
		}
		
		
	}
	public void addNodesToLinkList(int data){
		if(head==null){
			head=new Node(data);
		}
		else{
			Node temp=head;
			while(temp.next!=null){
			 temp=temp.next;
			}
		temp.next=new Node(data);
		}
	}
	
	public void printLinkedList(){
		Node itr=head;
		while(itr!=null){
			System.out.print(itr.data+"-->");
			itr=itr.next;
		}
	
	}
public static void addNumbersInList(Node n1,Node n2){
	int intSum=0,finalSum=0,carry=0,pos=1;	
	while(n1!=null){
		intSum=n1.data+n2.data+carry;
		System.out.println(" "+intSum);
	    if(intSum>=10){
	    	intSum=intSum-10;
	    	carry=1;
	    }
	    else{
	    	carry=0;
	    }
	    finalSum+=intSum*pos;
	    pos*=10;
	    n1=n1.next;
	    n2=n2.next;
	    intSum=0;
		}
	if(carry==1){
		finalSum+=1*pos;
	}
System.out.println("the total of the 2 linkedlists is = "+finalSum);	
}
public static void main(String[] args) {
	AddTwoLinkedListNumbers obj1 = new AddTwoLinkedListNumbers();
	AddTwoLinkedListNumbers obj2 = new AddTwoLinkedListNumbers();
	int[] arr1= new int[]{2,3,9,9};
    int[] arr2= new int[]{4,7,8,4};
    for (int i = 0; i < arr2.length; i++) {
		obj1.addNodesToLinkList(arr1[i]);
		obj2.addNodesToLinkList(arr2[i]);
	}
addNumbersInList(obj1.head,obj2.head);
}


}
