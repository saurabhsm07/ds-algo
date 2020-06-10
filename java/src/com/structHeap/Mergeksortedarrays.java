package com.structHeap;

/**
 * 
 * @author saurabh_mahambrey
 *
 *PROBLEM STATEMENT:
 *Given k sorted arrays of size n each, merge them and print the sorted output.

Example:

Input:
k = 3, n =  4
arr[][] = { {1, 3, 5, 7},
            {2, 4, 6, 8},
            {0, 9, 10, 11}} ;

Output: 0 1 2 3 4 5 6 7 8 9 10 11 

SOLUTION :
We can merge arrays in O(nk*Logk) time using Min Heap. Following is detailed algorithm.

1. Create an output array of size n*k.
2. Create a min heap of size k and insert 1st element in all the arrays into the heap
3. Repeat following steps n*k times.
     a) Get minimum element from heap (minimum is always at root) and store it in output array.
     b) Replace heap root with next element from the array from which the element is extracted. 
     If the array doesn�t have any more elements, 
     then replace root with infinite. After replacing the root, heapify the tree
 */
public class Mergeksortedarrays {
	//declaring heap of positions
	public static class Ordinates{
		int i,j;

		public Ordinates(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[");
			builder.append(i);
			builder.append(",");
			builder.append(j);
			builder.append("]");
			return builder.toString();
		}
	 
	}
	
	public static class Heap{
		Ordinates heapArr[];
int size;
		public Heap(Ordinates[] arr) {
			super();
			this.size = arr.length;
			this.heapArr = arr;
		}
	
	public void heapify(int pos,int sortedArrSet[][]){
	 int small=pos,lChild=pos*2+1,rChild=pos*2+2;
	 
	
	 if((lChild<size)&&(sortedArrSet[heapArr[small].i][heapArr[small].j]>sortedArrSet[heapArr[lChild].i][heapArr[lChild].j])){
		small=lChild; 
		
	 }
	 
	 if((rChild<size)&&(sortedArrSet[heapArr[small].i][heapArr[small].j]>sortedArrSet[heapArr[rChild].i][heapArr[rChild].j])){
			small=rChild; 
		 }
	
	 if(small!=pos){
			Ordinates temp=heapArr[pos];
			heapArr[pos]=heapArr[small];
			heapArr[small]=temp;
		}
	}
	
	public void extractMin(int sortedArraySet[][]){
		System.out.println(heapArr[0].i+","+heapArr[0].j+"="+sortedArraySet[heapArr[0].i][heapArr[0].j]);
	if(heapArr[0].j<sortedArraySet[heapArr[0].i].length-1){
		heapArr[0].j++;
		heapArr[0]=new Ordinates(heapArr[0].i, heapArr[0].j);
//		displayHeap(this);
		heapify(0,sortedArraySet);
	}
	else{

		size--;
	 for (int i = 0; i < heapArr.length-1; i++) {
		heapArr[i]=heapArr[i+1];
	}
	 for (int i = (heapArr.length-size)/2-1; i >= 0; i--) {
//		 displayHeap(this);
		heapify(i, sortedArraySet);
		
	}
	}
	}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] =  {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};
	Ordinates arr1[]= new Ordinates[arr.length];
	
	int total=0;
for (int i = 0; i < arr.length; i++) {
	arr1[i]=new Ordinates(i, 0);
	total+=arr[i].length;
}

Heap obj = new Heap(arr1);

for (int i = obj.heapArr.length/2-1; i >=0; i--) {
	obj.heapify(i, arr);
}

displayHeap(obj);
System.out.println();
for (int i = 0; i < total; i++) {
	obj.extractMin(arr);
}

	}

	protected static void displayHeap(Heap obj) {
		for (int i = 0; i < obj.heapArr.length; i++) {
			System.out.print(" "+obj.heapArr[i]);
		}
	}

}
