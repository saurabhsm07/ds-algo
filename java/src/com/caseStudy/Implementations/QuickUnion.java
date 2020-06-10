package com.caseStudy.Implementations;

import com.caseStudy.Interfaces.UnionFindInterface;

public class QuickUnion implements  UnionFindInterface{

	private int id[];
	public  int initialization=0,find=0,union=0;
	public QuickUnion(int size) {
		// TODO Auto-generated constructor stub
		id = new int[10];
	for (int i = 0; i < size; i++) {
		id[i]=i;
		initialization++; //number of initialization operation
	}
	}
	
	public  int root(int a){
		while(a!=id[a]){
			find++; //number of find operations
			a=id[a];
		}
		return a;
	}
	
	@Override
	public void union(int a, int b) {
		// TODO Auto-generated method stub
		id[root(a)] = root(b);
		union++;
	}

	@Override
	public boolean find(int a, int b) {
		// TODO Auto-generated method stub
		return root(a)==root(b);
	}

	public void getRunCount(){
		System.out.println("initialization Cost =" +initialization);
		System.out.println("find operation Cost =" +find);
		System.out.println("union operation Cost =" +union);
	}
}
