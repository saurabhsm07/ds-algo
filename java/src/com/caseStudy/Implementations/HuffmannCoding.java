package com.caseStudy.Implementations;

import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmannCoding {
	private HuffmannStruct huffobj;
	class HuffmannStruct implements Comparable<HuffmannStruct>{
		char character;
		int frequency;
		HuffmannStruct left,right;
	public HuffmannStruct(char val,int freq) {
		// TODO Auto-generated constructor stub
	this.character = val;
	this.frequency=freq;
    this.left=this.right=null;
	}
	public HuffmannStruct() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(HuffmannStruct obj1) {
		// TODO Auto-generated method stub
		return this.frequency-obj1.frequency;
	}
	}
	
public  void createHuffmannCodes(char characs[],int freq[]){
	Queue<HuffmannStruct> heap = new PriorityQueue<HuffmannStruct>();
	for (int i = 0; i < freq.length; i++) {
		huffobj = new HuffmannStruct(characs[i], freq[i]);
		heap.add(huffobj);
	}

	while (heap.size()>1) {
		
		 HuffmannStruct obj1 = heap.remove();
		 HuffmannStruct obj2 = heap.remove();
		 huffobj = new HuffmannStruct();
		 huffobj.frequency = obj1.frequency+obj2.frequency;
		 huffobj.character = '$';
		 huffobj.left = obj1;
		 huffobj.right=obj2;
		 heap.add(huffobj);
	}
	printCodes(heap.peek(),"");
	
}

private static void printCodes(HuffmannStruct tree,String code) {
	// TODO Auto-generated method stub
	if(tree.character!='$'){
		System.out.println(tree.character+" : "+code);
	}
	
	if(tree.left!=null){
	printCodes(tree.left, code+"0");	
	}
	if(tree.right!=null){
		printCodes(tree.right, code+"1");	
		}

}


}
