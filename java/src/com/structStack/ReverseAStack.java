package com.structStack;

/**
 * Created by saurabh_mahambrey on 1/31/2019.
 *
 * Problem Statement: Write a program to reverse a stack using recursion.
 * Solution : void insertAtBottom((): First pops all stack items and stores the popped item in function call stack using recursion.
 * And when stack becomes empty, pushes new item and all items stored in call stack.
 void reverse(): This function mainly uses insertAtBottom() to pop all items one by one and insert the popped items at the bottom.

 link :https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 * */
public class ReverseAStack {
   int stack[],top;

    public ReverseAStack(int size) {
        this.stack=new int[size];
        this.top=-1;
    }

    protected void pop(){
        if(top==-1)
            System.out.println("stack empty");
        else{
            System.out.println("popped "+stack[top]);
            top--;
        }
    }

    protected int peek(){
        if(top==-1){
            System.out.println("stack is empty");
            return -1;
        }
        else{
            return stack[top];
        }
    }

    protected  void push(int data){
        if(top==stack.length){
            System.out.println("stack is full");
        }
        else {
            System.out.println("pushed "+data);
            stack[++top]=data;
        }
    }

    protected  void printStack(){
        if (top == -1) {
            System.out.println("nothing to print stack is empty");
        }
        System.out.println("stack state :");
        for (int i =top;i>=0;i--)
            System.out.println(stack[i]);
    }

    private void reverse() {
        if(top>-1){
            int data = peek();
            pop();
            reverse();
            insertBottom(data);

        }
    }

    private void insertBottom(int data) {
        if(top==-1)
            push(data);
        else{
            int d = peek();
            pop();
            insertBottom(data);
            push(d);
        }
    }

    public static void main(String[] args) {
        ReverseAStack obj = new ReverseAStack(5);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.printStack();
        obj.reverse();
        obj.pop();
        obj.printStack();
    }


}
