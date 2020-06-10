package com.services;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
public class ActivitySelection {
//fails for non unique end time entries needs actual arry sorting and not map shit
	public void SelectActivities(int start[],int finish[],int totalActivities){
	 Map<Integer,Integer> activities= new TreeMap<Integer,Integer> ();
	 for (int i = 0; i < finish.length; i++) {
		activities.put(finish[i],start[i]);
	}
	Iterator<Integer> itr = activities.keySet().iterator();
  int[] startClone = new int[finish.length];
  int[] finishClone = new int[finish.length];
  int i=0;
  System.out.println(activities);
	while (itr.hasNext()) {
    finishClone[i]= (int) itr.next();
    startClone[i] = (int) activities.get(finishClone[i]);
    i++;
	}
	
for (int j = 0; j < finishClone.length; j++) {
 System.out.println(startClone[j]);
}
   i=0;
   System.out.println("activity 1 = starts at "+startClone[0]+" ends at "+finishClone[0]);
   for (int j = 1,c=1; c<=totalActivities && j<finishClone.length; j++) {
	if(startClone[j]>=finishClone[i]){
		c++;
   System.out.println("activity "+c+" = starts at "+startClone[j]+" ends at "+finishClone[j]);
	i=j;
	
	}else 
	{
		System.out.println(startClone[j]+" "+finishClone[i]);
	}
}
	}
	
	}

