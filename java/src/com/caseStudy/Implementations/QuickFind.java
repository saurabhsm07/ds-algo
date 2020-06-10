package com.caseStudy.Implementations;

import com.caseStudy.Interfaces.UnionFindInterface;

public class QuickFind implements UnionFindInterface{

	private int id[];
	public  int initialization=0,find=0,union=0;
	public QuickFind(int size) {
		// TODO Auto-generated constructor stub
		id = new int[10];
	for (int i = 0; i < size; i++) {
		id[i]=i;
		initialization++;
	}
	}
	
	public boolean find (int p,int q){
		find++;
		return id[p]==id[q];
		
	}
	
	public void union (int p,int q){
		
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) {
			union++;
			if(id[i]==pid){
				id[i] = qid;
			}
		}
	}
	
	public void getRunCount(){
		System.out.println("initialization Cost =" +initialization);
		System.out.println("find operation Cost =" +find);
		System.out.println("union operation Cost =" +union);
	}
}
