package com.problemSolutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FindIternary {

	/**
	 * @param table: holding the information regarding the skewed iternary
	 */

	private Map<String, String> table = new HashMap<String, String>();
	
	public void printIternary(){
	Set<String> srcs = table.keySet();
	Set<String> dest= new TreeSet<String>();
	dest.addAll(table.values());
	System.out.println(srcs);
	System.out.println(dest);
	String src="";
	for (String vals : srcs) {
		if(!dest.contains(vals)){
			src=vals;
		}
	}
	System.out.println(src);
	while(table.get(src)!=null){
		System.out.print(src+"----->");
	src=table.get(src);
	}
	System.out.print(src);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
FindIternary obj = new FindIternary();
obj.table.put("Chennai", "Banglore");
obj.table.put("Bombay", "Delhi");
obj.table.put("Goa", "Chennai");
obj.table.put("Delhi", "Goa");
obj.printIternary();
	}

}
