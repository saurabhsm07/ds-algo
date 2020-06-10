package com.structStack;

/**
 * Created by saurabh_mahambrey on 1/31/2019.
 * Problem Statement : push pop operation on stacks desigin of Linked Lists
 */
public class StackLinkedList {
    DataNode head;

    static class DataNode{
        int data;
        DataNode next;

        public DataNode(int data) {
            this.data=data;
            this.next=null;
        }
    }

    protected  void push(int data){
        if(head==null) {
            head = new DataNode(data);

        }
        else {
            DataNode temp = new DataNode(data);
            temp.next=head;
            head=temp;
        }
        System.out.println("push "+data);
    }

    protected int pop(){
        if(head==null){
            System.out.println("stack empty");
          return -1;}
        else {
            int data = head.data;
            head=head.next;
            System.out.println("pop "+data);
            return data;
        }
    }

    protected void stackState(){
        if(head==null)
            System.out.println("can't print stack empty");
        else {
            DataNode temp = head;
            while (temp!=null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        StackLinkedList obj = new StackLinkedList();
        obj.push(1);
        obj.push(4);
        obj.stackState();
        obj.pop();
        obj.pop();
        obj.stackState();

        obj.push(2);
        obj.push(5);
        obj.stackState();

        obj.pop();
        obj.push(3);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
    }

}
