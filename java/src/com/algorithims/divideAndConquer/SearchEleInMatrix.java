package com.algorithims.divideAndConquer;

/**
 * Created by saurabh_mahambrey on 1/15/2019.
 *
 * Problem Statement : Given an n x n matrix, where every row and column is sorted in increasing order.
 * Given a key, how to decide whether this key is in the matrix.
 A linear time complexity is discussed in the previous post.
 This problem can also be a very good example for divide and conquer algorithms.
 Following is divide and conquer algorithm.

 Status : highly error prone program.
 */
public class SearchEleInMatrix {
    int matrix[][];
    static class pos{
        int x,y;
        public pos(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public String toString() {
            return this.x+" "+this.y;
        }
    }


    protected pos findEleInMatrix(pos low,pos high,int element){
        pos mid=new pos((low.x+high.x)/2,(low.y+high.y)/2);
        System.out.println("low= "+matrix[low.x][low.y]);
        System.out.println("mid= "+matrix[mid.x][mid.y]);
        System.out.println("high= "+matrix[high.x][high.y]);
        System.out.println();
        if(matrix[low.x][low.y]>=matrix[high.x][high.y]) return null;

        if(matrix[low.x][low.y]>element || element >matrix[high.x][high.y]) return null;

        if(matrix[mid.x][mid.y]==element) {
            System.out.println("element present");
            return mid;
        }

        else if(matrix[mid.x][mid.y]<element)
        {
            pos obj=null;
            if(mid.y+1<=matrix.length-1) {
                obj = findEleInMatrix(new pos(0, mid.y + 1), high, element);
            }
            if (obj==null && mid.x+1<=matrix.length-1)
            obj=findEleInMatrix(new pos(mid.x+1,0),new pos(high.x,mid.y),element);
            return obj;
        }

        else{
            pos obj=null;
            if(mid.x-1>=0)
                    obj=findEleInMatrix(low,new pos(mid.x-1,matrix.length-1),element);
            if (obj==null && mid.y-1>=0)
            obj=findEleInMatrix(new pos(0,0),new pos(matrix.length-1,mid.y-1),element);
            return obj;
        }
    }
    public static void main(String[] args) {
        SearchEleInMatrix obj = new SearchEleInMatrix();
        obj.matrix=new int[][]{{10, 20, 30, 40},
                               {15, 25, 35, 45},
                               {27, 29, 37, 48},
                               {32, 33, 39, 50}};

        pos elementPosition=obj.findEleInMatrix(new pos(0, 0), new pos(obj.matrix.length-1, obj.matrix[0].length-1),37);
        System.out.println("Element position in matrix is = [" + elementPosition.x+ "][" + elementPosition.y+ "]");
    }
}
