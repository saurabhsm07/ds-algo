package com.caseStudy.Implementations;

import java.util.HashMap;
import java.util.Map;

class Name {
private String name;
Name(String name ){
this.name = name;
}
public String toString() {
return name;
}
}

public class DogMain {
public static void main(String[] args) {
	Map<String, Integer> map = new HashMap<String, Integer>();
	map.put("A", 10);
	map.put("B", 30);
	map.put("C", 20);
	System.out.println(map);
}
}