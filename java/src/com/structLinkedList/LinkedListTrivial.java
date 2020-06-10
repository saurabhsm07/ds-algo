package com.structLinkedList;

/**
 * Created by saurabh_mahambrey on 1/24/2019.
 */
public class LinkedListTrivial {
    Node head=null;
     static class Node{
         int data;
         Node next;

         @Override
         public String toString() {
             return "data=" + data ;
         }

         @Override
         public boolean equals(Object o) {
             if (this == o) return true;
             if (!(o instanceof Node)) return false;

             Node node = (Node) o;

             if (data != node.data) return false;
             return true;

         }

         @Override
         public int hashCode() {
             int result = data;
             result = 31 * result + next.hashCode();
             return result;
         }

         public Node(int data) {
             this.data = data;
             this.next =null;
         }

     }

  protected  void removeDuplicates(){
Node prev,temp;
      temp = head.next;
      prev=head;
      while(temp!=null) {
          if (prev.data == temp.data) {
              prev.next = temp.next;
              temp = temp.next;

          } else {
              temp = temp.next;
              prev = prev.next;
          }
      }
      System.out.println();
      }



    protected void swapNodes(int key1,int key2){
       Node n1=null,p1=null,n2=null,p2=null,temp=head,prev = null;


        while (temp!=null){
            if(temp.data==key1){

                n1=temp;
                p1=prev;
            }
            if(temp.data==key2){
                n2=temp;
                p2=prev;
            }
            if(n1!=null && n2!=null)
                break;

            prev=temp;
            temp=temp.next;

        }
       if(n1==null || n2 == null){
           System.out.println("one or both the keys do not exist in the list");
       }
        else{
           if(key2-key1>1) {
               temp = n2.next;
               if (p1 != null)
                   p1.next = n2;
               else
                   head = n2;
               n2.next = n1.next;
               p2.next = n1;
               n1.next = temp;
           }
           else{
               if (p1 != null)
                   p1.next = n2;
               else
                   head = n2;
               n1.next = n2.next;
               n2.next = n1;

           }
       }

    }

    protected void recursivePairwiseSwap(Node p1,Node n1,Node n2){
        if(n1==null || n2 == null)
            return;
        else {
//            Node temp=n2.next;
            if(p1!=null)
            p1.next=n2;
            n1.next=n2.next;
            n2.next=n1;
            traverseLinkedList(this);
            recursivePairwiseSwap(n1,n1.next,n1.next.next);
        }
    }

    protected void findIntersection(Node head1,Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        Node head3 = null;
        while (temp1 != null && temp2 != null) {
            if (temp1.equals(temp2)) {
                head3=createList(head3, temp1.data);
                temp2 = temp2.next;
                temp1 = temp1.next;
            }
            else if (temp2.data < temp1.data) {
                temp2 = temp2.next;
            }
            else{
                temp1 = temp1.next;
            }
        }
        System.out.println("intersection list is :");
        while (head3!=null){
            System.out.print(head3.data+"-->");
            head3=head3.next;
        }
    }


    private Node createList(Node head3, int data) {
        System.out.println("added element");
        if (head3==null){
            head3 = new Node(data);
        }
        else {
            Node temp = head3;
        while (temp.next!=null)
            temp=temp.next;
        temp.next=new Node(data);
        }
        return head3;
    }


    public static void main(String[] args) {
LinkedListTrivial obj = new LinkedListTrivial();
LinkedListTrivial obj1 = new LinkedListTrivial();


//        testProblem1(obj);

//        testProblem2(obj);
//        testProblem3(obj);
testProblem4(obj, obj1);

    }


    /**
     * PM : find intersection between 2 linked lists (sorted ) and create a 3rd list from both
     * @param obj1
     * @param obj2
     */
    private static void testProblem4(LinkedListTrivial obj1, LinkedListTrivial obj2) {
         createList(obj1,new int[]{1,2,3,4,5,6});
         createList(obj2,new int[]{-1,-2,-3,4,5,6,7,8,9});
        new LinkedListTrivial().findIntersection(obj1.head,obj2.head);
    }

    /**
     * PM : remove duplicates from a linked list (sorted)
     * note : for unsorted its better to use hash map to store data (o(n)) coz otherwise we loop through(n^2) or sort the list(nlogn)
     * @param obj
     */
    private static void testProblem1(LinkedListTrivial obj) {
        createList(obj,new int[]{1,2,2,2,4,5,6});
        traverseLinkedList(obj);
        obj.removeDuplicates();

        traverseLinkedList(obj);
    }



    /**
     * PM: swap node links in a linked list .
     * TC: o(n);
     * @param obj
     */
    private static void testProblem2(LinkedListTrivial obj) {
        createList(obj,new int[]{1,2,3,4,5,6,7});
        traverseLinkedList(obj);
        obj.swapNodes(1, 3);

        traverseLinkedList(obj);
    }

    /**
     * PM:Recursively swap adjacent elements :
     * e.g : i/p =1->2->3->4->5->6 o/p =2->1->4->3->6->5
     * @param obj
     */
    private static void testProblem3(LinkedListTrivial obj) {
        createList(obj,new int[]{1,2,3,4,5,6,7});
        traverseLinkedList(obj);
        obj.recursivePairwiseSwap(null, obj.head, obj.head.next);

        traverseLinkedList(obj);
    }



    private static void traverseLinkedList(LinkedListTrivial obj) {
        Node temp;
        temp = obj.head;
        System.out.println();
        while (temp!= null) {

            System.out.print(temp.data + "-->");
            temp=temp.next;
        }
    }

    private static void createList(LinkedListTrivial obj,int arr[]) {

        obj.head=new Node(arr[0]);
        Node temp=obj.head;
        for (int i =1;i<arr.length;i++) {
            if (temp.next == null) {
                temp.next = new Node(arr[i]);
                temp=temp.next;
            } else {
                temp = temp.next;
            }
        }
    }

}
