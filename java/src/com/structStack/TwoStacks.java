package com.structStack;

/**
 * Created by saurabh_mahambrey on 1/31/2019.
 *
 * Problem Statement : implement 2 stacks in a array and should be space efficient
 *
 * Solution : start both stack from extreme ends of the array
 * */

public class TwoStacks {
    int stack[],top1,top2;

    public TwoStacks(int size) {
        this.stack = new int[size];
        this.top1=-1;
        this.top2=size;
    }

    protected  void pushStack1(int data){
     if(top1==top2-1){
         System.out.println("stack 1 full");
     }
        else {
         System.out.println("S1 pushed "+data);
         top1++;
         stack[top1]=data;
     }
    }

    protected  void pushStack2(int data){
     if(top2==top1+1)
         System.out.println("stack 2 full");
     else {
         System.out.println("S2 pushed "+data);
         top2--;
         stack[top2]=data;
     }
    }

    protected  void popStack1(){
     if(top1== -1)
         System.out.println("stack 1 empty");
     else{
         System.out.println("S1 popped "+ stack[top1]);
         top1--;
     }
    }
    protected void popStack2(){
     if(top2== stack.length)
         System.out.println("stack 2 empty");
     else {
         System.out.println("S2 popped "+ stack[top2]);
         top2++;
     }
    }

    protected void printStack1(){
        if(top1==-1)
            System.out.println("stack 1 empty can't print");
        else{
            System.out.println("stack 1 state");
        for (int i=top1;i>=0;i--) {
            System.out.println(stack[i]);
        }
        }
    }
    protected void printStack2(){
        if(top2== stack.length)
            System.out.println("stack 2 empty can't print");
        else{
            System.out.println("stack 2 state");
            for (int i = top2; i < stack.length ; i++) {
                System.out.println(stack[i]);

            }
        }
    }

    public static void main(String[] args) {
    TwoStacks obj = new TwoStacks(10);
        obj.pushStack1(1);
        obj.pushStack1(2);
        obj.pushStack1(3);
        obj.popStack1();
        obj.pushStack1(4);
        obj.pushStack1(5);
        obj.pushStack1(6);
        obj.pushStack1(7);
        obj.popStack1();

        obj.pushStack2(10);
        obj.pushStack2(9);
        obj.pushStack2(8);
        obj.pushStack2(7);

        obj.printStack1();
        obj.printStack2();
    }
}
