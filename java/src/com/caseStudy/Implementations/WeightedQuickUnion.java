package com.caseStudy.Implementations;

import com.caseStudy.Interfaces.UnionFindInterface;

public class WeightedQuickUnion implements UnionFindInterface {
	
	private int id[],sz[];
	public  int initialization=0,find=0,union=0;
	
	public WeightedQuickUnion(int size) {
		// TODO Auto-generated constructor stub
		id = new int[10];
		sz =new int[10];
	for (int i = 0; i < size; i++) {
		id[i]=i;
		sz[i]=1;
		initialization++;
	}
	}

	
	public  int root(int a){
		while(a!=id[a]){
			find++;
			a=id[a];
		}
		return a;
	}
	
	
	@Override
	public void union(int a, int b) {
		// TODO Auto-generated method stub
		int i = root(a);
		int j = root(b);
		union++;
		if(sz[i]>sz[j]){
			id[j] = i;
			sz[i]+=sz[j];
		}
		else{
			id[i]=j;
			sz[j]+=sz[i];
		}

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
		for (int i = 0; i < sz.length; i++) {
			System.out.print(" "+sz[i]);
		}
	}

}
