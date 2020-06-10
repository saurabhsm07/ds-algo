package com.structQueue;

import javafx.geometry.Pos;

/**
 * Created by saurabh_mahambrey on 2/4/2019.
*Problem Statement : Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
 0: Empty cell

 1: Cells have fresh oranges

 2: Cells have rotten oranges
 So we have to determine what is the minimum time required so that all the oranges become rotten.
 A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1]

 solution : use a queue and save all the future oranges location to be rotted ,
 add a marker after each iteration of rotting to save the change in days continue till max oranges are rotted.

 link :https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
 **/

public class RotOranges{
    Position queue[];
    int oranges[][];
    static int count=-1;
    int front=-1,rear=-1;
    static class Position{
        int i,j;

        public Position(int x, int y) {
            this.i = x;
            this.j = y;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    public RotOranges(int size,int oranges[][]) {
        queue=new Position[size];
        this.oranges=oranges;
    }

    protected void enqueue(int i,int j){
        count++;
        if(front==-1){
            rear=count;
            front++;
            queue[rear]=new Position(i,j);
            System.out.println("enqueued "+queue[rear]);
        }
        else if(rear+1==queue.length){
            System.out.println("queue is full");
        }

        else {
            rear=count;
            queue[rear]=new Position(i,j);
            System.out.println("enqueued "+queue[rear]);
        }

    }

    protected Position dequeue(){
        count--;
        if(front==-1){
            System.out.println("queue is empty");
            return null;

        }
        else if(front==rear){
            System.out.println("dequeued "+queue[front]);
            Position temp = queue[front];
            front=rear=-1;
            return temp;
        }
        else{
            System.out.println("dequeued "+queue[front]);
            Position temp = queue[front];
            for (int i = front; i <rear ; i++) {
                queue[i]=queue[i+1];
            }
           rear=count;
           return temp;
        }

    }
    protected Position peekQ(){
        return queue[front];
    }

    protected int timeToRot(){
        int dayCount=0,rotten=0,fresh=0;
        for (int i = 0; i < oranges.length; i++) {
            for (int j = 0; j < oranges[0].length; j++) {
                if(oranges[i][j]==2){
                    rotten++;
                    storeData(i,j,oranges.length,oranges[0].length);
                }
                if(oranges[i][j]==1){
                    fresh++;
                }
            }
        }
        storeData(oranges.length, oranges[0].length, oranges.length,oranges[0].length);
        dayCount++;
        Position pos=dequeue();
        Position peeker=peekQ();
        int rotter=0;
        System.out.println("calculating time to rot");
        while(rear>0) {
            if(pos.i==oranges.length && (pos.i== peeker.i && pos.j ==peeker.j)) {
                System.out.println("breaking out");
                break;
            }
            else if (pos.i == oranges.length) {
                dayCount++;
                storeData(oranges.length, oranges[0].length, oranges.length,oranges[0].length);
            } else {
                if( oranges[pos.i][pos.j]==1) {
                    oranges[pos.i][pos.j] =2;
                    rotter++;
                    storeData(pos.i, pos.j, oranges.length, oranges[0].length);
                }
            }
            pos=dequeue();
            peeker=peekQ();
        }

           if(rotter==fresh)
            return dayCount;
        else
               return -1;

    }



    private void storeData(int i, int j,int m,int n) {
        if(i==oranges.length && j==oranges[0].length){
            enqueue(oranges.length,oranges[0].length);
        }
        else {
            if (i - 1 >= 0 && 1 == oranges[i - 1][j])
                enqueue(i - 1, j);
            if (i + 1 < m && 1 == oranges[i + 1][j])
                enqueue(i + 1, j);
            if (j + 1 < n && 1 == oranges[i][j + 1])
                enqueue(i, j + 1);
            if (j - 1 >= 0 && 1 == oranges[i][j - 1])
                enqueue(i, j - 1);
        }
    }

    public static void main(String[] args) {
        int arr[][] = { {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        RotOranges obj = new RotOranges(arr.length*arr[0].length,arr);
        testRottenOranges(obj);
    }

    private static void testRottenOranges(RotOranges obj) {
        int arr[][] = { {2, 1, 0, 2, 1},
                        {1, 0, 1, 2, 1},
                        {1, 0, 0, 2, 1}};
        int size =arr.length*arr[0].length;
        System.out.println(size);
        int days= obj.timeToRot();
        if(days==-1){
            System.out.println("all oranges won't rot");
        }
        else {
            System.out.println("oranges will rot in "+days);
        }
    }
}
