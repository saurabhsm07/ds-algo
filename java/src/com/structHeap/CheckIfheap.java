package com.structHeap;


public class CheckIfheap {
private int arr[];
public static int count=0;

public boolean ifHeap(int arr[],int pos){
	if((pos*2+1<arr.length)||(pos*2+1>arr.length && pos*2+2>arr.length)){
		int largest = pos;
		if((pos*2+1<arr.length))
		if(arr[pos]>arr[pos*2+1])
		 largest = pos*2+1;
		if((pos*2+2<arr.length))
	if(arr[pos]>arr[pos*2+2])
		 largest = pos*2+2;
	
   if(largest!=pos)
	return false;
   else
	  return true;
	}
return false;
}/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean status=false;
CheckIfheap obj = new CheckIfheap();
obj.arr= new int[]{90, 15, 10, 3, 12, 2, 7, 7};
	for (int i=obj.arr.length/2-1; i >=0; i--) {
	 status=obj.ifHeap(obj.arr, i);
		if(!status){
			System.out.println("not a heap");
		break;
		}
}
if(status){
	System.out.println("is a heap");
}
	}
	

}
