package com.structLinkedList;

/**
 * Created by saurabh_mahambrey on 1/28/2019.
 */
public class CircularLinkedListTrivial {

    Node head;

    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next=null;
        }

        @Override
        public String toString() {
            return "Node ="+ data;
        }
    }

    protected void splitCircularList(){
        Node ptr1,ptr2;
        int count=1,size=0;
        ptr1=head;ptr2=head;
        if(ptr1.next.data==ptr2.data){
            System.out.println("one element cannot be split");
        }
        else{
            while(ptr1.next.next.data!=head.data && ptr1.next.next.data!=head.next.data){
                System.out.println(ptr1.data);
                count++;
                ptr1=ptr1.next.next;
                ptr2=ptr2.next;
            }
            if(ptr1.next.next.data==head.next.data){
                ptr1=ptr1.next;
                ptr2=ptr2.next;
                 size=2*count-1;
            }
            else{
                ptr1=ptr1.next.next;
                ptr2=ptr2.next;
                size = 2*count;
            }
            System.out.println("counter = "+count);
            System.out.println("List split 1 :");
            for (int i=0;i<count;i++){
                System.out.print(ptr1.data+"-->");
                ptr1=ptr1.next;
            }
            System.out.println("Done \n List split 2 :");
            for (int i=0;i<size-count;i++){
                System.out.print(ptr2.data+"-->");
                ptr2=ptr2.next;
            }
            System.out.println("Done");
        }

    }
   protected void  createCircularList(int arr[]){
     if(head == null){
         head = new Node(arr[0]);
         Node temp = head;
         for (int i=1;i<arr.length;i++){
              temp.next = new Node(arr[i]);
             temp=temp.next;

         }
         temp.next=head;

     }
       else{
         Node temp = head;
         while(temp.next.data!=head.data){
             temp=temp.next;
         }
        for (int i=0;i<arr.length;i++){
            temp.next = new Node(arr[i]);
            temp=temp.next;
     }
         temp.next=head;
     }
    }

    protected  int josephusSurvivor(int n,int m){
        Node temp = head;
        int count=0,deathCount=0;
        while(deathCount<n-1){
            for (int i=1;i<m;i++){
                temp=temp.next;
                   count++;
            if(temp.data==0)
                i--;
            }
            int data=temp.data;
            temp.data=0;

            while (temp.data==0) {
                temp = temp.next;
                count++;
            }
            deathCount++;
//            count++;
            System.out.println("Position died ="+(count%n)+" data = "+data);
//            count++;
        }
//        while(temp.data==0){
//            temp=temp.next;
//            count++;
//        }
        return (count+1)%n;
    }

    protected static void printCircularLinkedList(Node head){
        Node temp = head;
        do{
            System.out.print(temp.data + "-->");
        temp=temp.next;

        }while(head.data != temp.data);
        System.out.println("done");
    }

    public static void main(String[] args) {
    CircularLinkedListTrivial obj = new CircularLinkedListTrivial();


//        testProblem1(obj);

        testProblem2(obj);

    }

    /**
     * Problem Statement : find a josephus survivor in a given list
     * statement : link :https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/
     * @param obj
     */
    private static void testProblem2(CircularLinkedListTrivial obj) {
        obj.createCircularList(new int[]{1, 2, 3, 4,5,6,7,8,9});
        int position=obj.josephusSurvivor(9,3);
        System.out.println("position that survives =" + position);
    }

    /**
     * Problem statement : divide a circular Linked list in 2 halves
     *
     * @param obj
     */
    private static void testProblem1(CircularLinkedListTrivial obj) {
        obj.createCircularList(new int[] {1,2,3,4,5});
        obj.createCircularList(new int[] {11,12,13,14});

        obj.printCircularLinkedList(obj.head);
        obj.splitCircularList();
    }

}
