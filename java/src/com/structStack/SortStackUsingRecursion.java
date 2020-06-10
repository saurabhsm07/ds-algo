package com.structStack;

/**
 * Created by saurabh_mahambrey on 2/1/2019.
 * Problem Statement : Given a stack, sort it using recursion. Use of any loop constructs like while, for..etc is not allowed
 */
public class SortStackUsingRecursion {
    int stack[],top;

    public SortStackUsingRecursion(int data) {
        stack=new int[data];
        top=-1;
    }

    /**
     * step 1 : remove all elements one by one
     */
    public void sortPhase1(){
        System.out.print("phase 1 ");
        if(top!=0){
            int data = peek();
            pop();
            sortPhase1();
            if(data>peek()){
                sortPhase2(data);
            }
            else{
                push(data);
            }
        }

    }

    /**
     * step 2 : compare data with the stack top and recusively remove until we reach larger element than data and push the popped elements
     * @param data
     */
    private void sortPhase2(int data) {
        System.out.print("phase 2 ");
        int d=peek();
        pop();
        if(data>peek() && (peek()!=-1)){
            sortPhase2(data);
            push(d);
        }
        else {
            push(data);
            push(d);
        }
        }

    private void push(int data) {
        if(top+1==stack.length)
            System.out.println("stack full");
        else{
            System.out.println("push "+data);
            top++;
            stack[top]=data;
        }
    }

    private void pop() {
        if(top==-1)
            System.out.println("stack is empty");
        else {
            System.out.println("pop "+stack[top]);
            top--;
        }
    }

    private int peek() {
        if(top==-1)
            return -1;
        return stack[top];
    }

    protected  void printStack(){
        System.out.println("stack status");
        for (int i=0;i<=top;i++){
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        SortStackUsingRecursion obj = new SortStackUsingRecursion(5);
        testProblem2(obj);
    }

    private static void testProblem2(SortStackUsingRecursion obj) {
        obj.push(1);
        obj.push(5);
        obj.push(3);
        obj.push(2);
        obj.push(4);
        obj.printStack();
        obj.sortPhase1();
        obj.printStack();
    }
}
