package com.structHeap;

public class HeapCruds {

	int arr[];
	int size;
	static int count = 0;

	public HeapCruds(int size) {
		// TODO Auto-generated constructor stub
		arr = new int[size];
		this.size = size;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.MIN_VALUE;
		}
	}

	public HeapCruds(int arr[]){
		this.arr = new int[arr.length];
		this.size=arr.length;
		for (int i = 0; i < arr.length; i++) {
			this.arr[i] = arr[i];
		}
	}
	public void insertElement(int ele) {

		if (count == arr.length) {
			System.out.println("no more elements can be added");
		} else {
			System.out.println("element added");
			arr[count] = ele;
			count++;
		}
	}

	public void minHeapify(int src) {
		int leftC = src * 2 + 1, rightC = src * 2 + 2, smallest = src;
		
		if (leftC < arr.length && arr[leftC] < arr[smallest]) {

			smallest = leftC;
		}
		if (rightC < arr.length && arr[rightC] < arr[smallest]) {
			smallest = rightC;
		}
		if (smallest != src) {
			swapElements(src, smallest);
			displayHeap();
			minHeapify(smallest);
			
		}
		
	}
	
	public void extractMin(){
		System.out.println("removed ele="+arr[0]);
		size--;
		for (int i = 0; i < size; i++) {
			arr[i]=arr[i+1];
		}
		for (int i = size/2-1; i >=0 ; i--) {
			minHeapify(i);
			
		}
		
	}
	
	public void insertEle(int ele){
		System.out.println(size);
		if(size==arr.length){
			System.out.println("no more elements can b added");
		}
		
		else{
			System.out.println("added ele="+ele);
			arr[size]=ele;
		size++;
		for (int i = size/2-1; i >=0 ; i--) {
			minHeapify(i);
			
		}
		}
	}
	
	public void decreaseKey(int pos,int val){
		if(pos>size){
			System.out.println("index out of bounds");
		}
		else {
			
			arr[pos]=arr[pos]-val;
			if(arr[pos]<arr[(pos-1)/2]){
				for (int i = (pos-1)/2; i >=0 ; i--) {
					minHeapify(i);
					
				}
			}
		}
	}

	protected void swapElements(int ele1, int ele2) {
		arr[ele1] = arr[ele2] + arr[ele1];
		arr[ele2] = arr[ele1] - arr[ele2];
		arr[ele1] = arr[ele1] - arr[ele2];
	}

	public void displayHeap() {
		System.out.println("iteration = "+(count++));
		for (int i = 0; i < size; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapCruds heap = new HeapCruds(new int[]{90, 15, 10, 7, 12, 2, 7, 3});
//heap.insertElement(1);
//heap.insertElement(3);
//heap.insertElement(6);
//heap.insertElement(5);
//heap.insertElement(9);
//heap.insertElement(8);
//heap.insertElement(10);

		//  3  7  2  10  12  15  7  90

	for (int i = heap.arr.length/2-1; i >=0 ; i--) {
		heap.minHeapify(i);
//		System.out.println();
//		heap.displayHeap();
	}
	
	System.out.println(heap.size);
	heap.displayHeap();

	heap.extractMin();
	heap.displayHeap();
	try {
	
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	heap.extractMin();
	heap.displayHeap();
	
	heap.insertEle(77);
	heap.displayHeap();
	
	
	
	heap.insertEle(-6);
	heap.displayHeap();
	
	heap.decreaseKey(2, 55);
	heap.displayHeap();
	}

	
}
