package com.structQueue;

/**
 * Created by saurabh_mahambrey on 2/4/2019.
 * Problem Statement : Implement a cicular queue.
 */
public class CircularQueue {
    int queue[];
    int front,rear;

    public CircularQueue(int size) {
        queue=new int[size];
        front=rear=-1;
    }

    protected void enqueue(int data){
        if(front==rear && rear==-1){
            front++;
            rear++;
            System.out.println("enqueue "+data);
            queue[0]=data;
        }
        else if((front+1)%queue.length==rear){
            System.out.println("queue is full unable to enqueue "+data);
        }
        else {
            System.out.println("enqueue "+data);
            front=(front+1)%queue.length;
            queue[front]=data;
        }
    }

    protected  void dequeue(){
        if(rear==-1){
            System.out.println("queue is empty");
        }
        else if(rear==front){
            System.out.println("dequeue "+queue[rear]);
            rear=-1;
            front=-1;
        }
        else{
            System.out.println("dequeue "+queue[rear]);
            rear=(rear+1)%queue.length;
        }
    }

    protected void printQueue(){
        if(rear==-1){
            System.out.println("Queue is empty");
        }
        else{
            System.out.println("rear ="+rear);
            System.out.println("front ="+front);
            for (int i = rear; i != front ; i=(i+1)%queue.length) {
                System.out.println(queue[i]);
            }
            System.out.println(queue[front]);
        }
    }

    public static void main(String[] args) {
        CircularQueue obj = new CircularQueue(5);
        testCircularQueue(obj);
    }

    private static void testCircularQueue(CircularQueue obj) {
        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);
        obj.enqueue(5);
        obj.enqueue(6);

        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();

        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);

        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();

        obj.enqueue(6);
        obj.enqueue(7);
        obj.enqueue(8);
        obj.enqueue(9);
        obj.enqueue(10);


        obj.printQueue();
        obj.dequeue();
        obj.dequeue();
        obj.printQueue();
        obj.enqueue(11);
        obj.enqueue(12);
        obj.printQueue();
    }
}
