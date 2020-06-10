package com.structHeap;

import com.utility.Utility;


public class BuildHeap {
private int arr[];
static int count =0;
public void createHeap(int arr[],int pos)
{
	int largest =pos;
	
if((pos*2+1)<arr.length){

	if(arr[largest]>arr[pos*2+1]){
		largest=pos*2+1;
	
	}
}
if((pos*2+2)<arr.length){
	if(arr[largest]>arr[pos*2+2]){
		largest=pos*2+2;
	
	}
}
if(largest!=pos){
	System.out.println("swapped");
	arr=Utility.swapElements(arr, pos, largest);
	createHeap(arr, largest);
}
System.out.println("after iteration ="+(++count));
Utility.printArray(arr);

}
public static void main(String[] args) {
	BuildHeap heapObj= new BuildHeap();
	
	heapObj.arr=new int[]{90, 15, 10, 7, 12, 2, 7, 3};

	for (int i = heapObj.arr.length/2-1;i>=0; i--) {
		heapObj.createHeap(heapObj.arr, i);
		System.out.println("after iteration ="+(++count));
		Utility.printArray(heapObj.arr);
	}
	System.out.println("finallllleeee------------");
	Utility.printArray(heapObj.arr);
}
}
