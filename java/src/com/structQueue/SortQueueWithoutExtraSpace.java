package com.structQueue;

/**
 * Created by saurabh_mahambrey on 2/7/2019.
 * Problem Statement : sort a queue  without using extra space.
 */
public class SortQueueWithoutExtraSpace {

    int queue[],front,rear;

    public SortQueueWithoutExtraSpace(int size) {
        this.queue=new int[size];
        this.front=this.rear=-1;
    }

    protected  void enqueue(int data){
        if(front==-1){
            front++;
            rear++;
            queue[front]=data;
            System.out.println("pushed "+data);
        }
        else if(rear+1==queue.length){
            System.out.println("queue is full ");
        }
        else{
            rear++;
            queue[rear]=data;
            System.out.println("pushed "+data);
        }
    }

   protected int peek(){
       if(front==-1) {
           System.out.println("queue is empty ");
           return -1;
       }
       else
           return queue[front];
   }

   protected void dequeue(){
       if(front==-1){
           System.out.println("queue is empty");
       }
       else{
           System.out.println("dequeued "+queue[front]);
           if(front==rear){
               front=rear=-1;
           }
           else{
               for (int i = front; i < rear; i++) {
                   queue[i]=queue[i+1];
               }
               rear--;
           }
       }
   }

    protected void printQueue(){
        for (int i = front; i <=rear ; i++) {
            System.out.println(queue[i]);
        }
    }

    /**
     * sort stage 1 : part one of recursively trying to sort the queue (not working)
     */
  protected void sortStage1(){
      if(peek()!=-1) {
          int data = peek();
          dequeue();
          sortStage1();
          sortStage2(data);
      }


  }

    /**
     * sort stage 2 : part two of recursively trying to sort the queue (not working)
     */
    private void sortStage2(int data) {
        System.out.println("Stage 2 data="+data+"  peek="+peek());
        if(peek()==-1) {
            enqueue(data);
        }
        else if(peek()>data){
                int d=peek();
                dequeue();
                sortStage2(data);
                sortStage2(d);
            }
        else{
            enqueue(data);
        }
        }


    protected void sortQueueMethod1(){
        int totalElements=rear,min=0;
            min=peek();
             dequeue();
            enqueue(min);
        for (int i = 0; i < rear; i++) {
            if(min>peek()){
                min=peek();
            }
            int temp= peek();
            dequeue();
            enqueue(temp);
        }
        while (totalElements!=0) {

            min = methodOneRoutine1(totalElements,rear, min);

            totalElements--;
        }
        min=peek();
        dequeue();
        enqueue(min);
    }

    private int  methodOneRoutine1(int findMinTill, int totalElements, int min) {
        int newMin=100;
        System.out.println(" minimum element ="+min);
        System.out.println(totalElements+" total elements");
        for (int i = 0; i <=totalElements ; i++) {
            if(peek()==min){
                dequeue();
            }
            else{
                if(newMin>peek() && i <=findMinTill)
                    newMin=peek();
                int temp = peek();
                dequeue();
                enqueue(temp);
            }
        }
        enqueue(min);
        min=newMin;
        return min;
    }

    public static void main(String[] args) {
        SortQueueWithoutExtraSpace obj = new SortQueueWithoutExtraSpace(5);
        obj.enqueue(4);
        obj.enqueue(3);
        obj.enqueue(1);
        obj.enqueue(5);
        obj.enqueue(2);
        obj.printQueue();
//        testSortRecursive(obj);
    obj.sortQueueMethod1();
        obj.printQueue();
    }

    private static void testSortRecursive(SortQueueWithoutExtraSpace obj) {
        System.out.println("sorting queue");
        obj.sortStage1();
        obj.printQueue();
    }
}
