package com.structStack;

/**
 * Created by saurabh_mahambrey on 1/31/2019.
 *
 * Problem Statement : use a queue to show a stack implementation
 * solution : make the push step costly.After pushing a element to queue pop all elements below it and
 * push them in queue again that way latest element becomes top of the queue
 * pop remains the same.
 */
public class QueueAsStack {
    int queue[],top;
    public QueueAsStack(int size) {
        this.queue = new int[size];
        top=-1;
    }

    protected  void enqueue(int data,boolean state){
        if(top+1==queue.length)
            System.out.println("stack is full");
        else {
            top++;
            queue[top]=data;
            if(state){
            System.out.println("enqueued " + data);
            stacker();}

        }
    }

    private void stacker() {
        int vals[] = new int[top];
        for (int i = 0; i < vals.length; i++) {
            int data=dequeue(false);
            if(data!=-1) {
                vals[i]=data;
            }
        }
        for (int i = 0; i <vals.length ; i++) {
            enqueue(vals[i],false);
        }
    }

    protected int dequeue(boolean state) {
        if (top==-1) {
            System.out.println("stack is empty");
            return -1;
        }
        else{
            int data = queue[0];
            int size = top;
            if (state)
            System.out.println("dequeue "+data);
            for(int i=0;i<top;i++){
                queue[i]=queue[i+1];
            }
            top--;
        return data;
        }
    }

    protected  void printQueue(){
        System.out.println("queue status");
        for (int i = 0; i <=top; i++) {
            System.out.println(queue[i]);
        }
    }

    public static void main(String[] args) {
        QueueAsStack obj = new QueueAsStack(5);
        obj.enqueue(1,true);
        obj.enqueue(2,true);
        obj.enqueue(3,true);
        obj.enqueue(4,true);
        obj.enqueue(5,true);
        obj.printQueue();
        obj.dequeue(true);
        obj.dequeue(true);
        obj.dequeue(true);
        obj.dequeue(true);
        obj.dequeue(true);
        obj.dequeue(true);

    }


}
