package com.structStack;

/**
 * Created by saurabh_mahambrey on 2/1/2019.
 * Problem Statement : implement stack operations using a priority queue or a heap
 *
 * solution :In priority queue, we assign priority to the elements that are being pushed.
 * A stack requires elements to be processed in Last in First Out manner.
 * The idea is to associate a count that determines when it was pushed. This count works as a key for the priority queue.
   So the implementation of stack uses a priority queue of pairs, with the first element serving as the key.
 */
public class PQueueAsAStack {
    int stack[][],top;
    static int count=0;
    public PQueueAsAStack(int stackSize) {
        this.stack= new int[stackSize][2];
        this.top=-1;
    }

    protected void enqueue(int data){
        if(stack.length==top+1)
            System.out.println("stack is full");
        else{
            System.out.println("pushed "+data);
            top++;
            count++;
            stack[top][0]=count;
            stack[top][1]=data;
            heap();
        }
    }

    protected  void dqueue(){
        if(top==-1)
            System.out.println("stack is empty");
        else {
            System.out.println("popped " + stack[0][1]);
            for (int i = 0; i < top; i++) {
                stack[i][0]=stack[i+1][0];
                stack[i][1]=stack[i+1][1];
            }
            top--;
            heap();
        }
    }

    protected  void heap(){
        for (int i = (top+1)/2-1; i >=0 ; i--) {
            heapify(i);

        }
    }

    private void heapify(int ele) {
        int max = ele;
        if ((ele*2+1 <=top) && (stack[max][0]<stack[2*ele+1][0])){
            max=max*2+1;

        }
        if ((ele*2+2 <=top) && (stack[max][0]<stack[2*ele+2][0])){
            max=max*2+2;

        }
        if(ele!=max){
            stack[ele][0]=stack[max][0]+stack[ele][0];
            stack[max][0]=stack[ele][0]-stack[max][0];
            stack[ele][0]=stack[ele][0]-stack[max][0];

            stack[ele][1]=stack[max][1]+stack[ele][1];
            stack[max][1]=stack[ele][1]-stack[max][1];
            stack[ele][1]=stack[ele][1]-stack[max][1];

            heapify(max);
        }

    }

    private  void printStack(){
        for (int i = 0; i <=top; i++) {
            System.out.println(" val = "+stack[i][1]+"  priority ="+stack[i][0]);
        }
    }

    public static void main(String[] args) {
        testProblem1();
    }

    private static void testProblem1() {
        PQueueAsAStack obj = new PQueueAsAStack(5);
        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);
        obj.enqueue(5);
        obj.printStack();
        obj.dqueue();
        obj.dqueue();
        obj.dqueue();
        obj.enqueue(312);
        obj.enqueue(42);
        obj.enqueue(522);
        obj.enqueue(522);
        obj.dqueue();
        obj.dqueue();
        obj.dqueue();
    }
}
