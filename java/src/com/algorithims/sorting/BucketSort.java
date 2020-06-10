package com.algorithims.sorting;

import java.util.*;

/**
 * 
 * @author saurabh_mahambrey
 *
 *         Bucket sort: Sort a large set of floating point numbers which are in
 *         range from 0.0 to 1.0 and are uniformly distributed across the range
 * 
 *         Algorithim: bucketSort(arr[], n) 1) Create n empty buckets (Or
 *         lists). 2) Do following for every array element arr[i]. .......a)
 *         Insert arr[i] into bucket[n*array[i]] 3) Sort individual buckets
 *         using insertion sort. 4) Concatenate all sorted buckets.
 */
public class BucketSort {

	float arr[];

	public BucketSort(float[] arr2) {
		super();
		this.arr = arr2;
	}

	public void bucketSortImpl() {
		Map<String, List<Float>> bucket = new TreeMap<String, List<Float>>();

		for (int i = 1; i <= 9; i++) {
			bucket.put("0." + (new Integer(i).toString()), new LinkedList<Float>());
		}
		for (int i = 0; i < arr.length; i++) {
			//
			StringBuilder sb = new StringBuilder(new Double(arr[i]).toString());
			String val = "0" + sb.substring(sb.indexOf("."), sb.indexOf(".") + 2).toString();

			if (bucket.containsKey(val)) {
				bucket.get(val).add(arr[i]);
			} else {
				System.out.println(val + " elements out of index" + arr[i]);
				List<Float> list = new LinkedList<Float>();
				list.add(arr[i]);
				bucket.put(val, list);
			}
		}

		System.out.println("initial bucket");
		System.out.println(bucket);
		Set<String> keyset = bucket.keySet();
		int count = 0;
		for (String key : keyset) {
			if (bucket.get(key).size() != 0) {
				if (bucket.get(key).size() > 1) {
					List<Float> list = (insertionSortRoutine(bucket.get(key)));
					for (Float double1 : list) {
						arr[count] = double1;
						++count;
					}
				} else {
					arr[count] = bucket.get(key).get(0);
					++count;
				}
			}

		}

	}

	private List<Float> insertionSortRoutine(List<Float> list) {
		// TODO Auto-generated method stub
		float arr[] = new float[list.size()];
		int i = 0;
		System.out.println(list);
		for (float val : list) {
			arr[i] = val;
			i++;
		}

		for (int j = 1; j < arr.length; j++) {
			float temp = arr[j];
			int k = j - 1;
			while (k >= 0 && temp < arr[k]) {
				arr[k + 1] = arr[k];
				k--;
			}
			arr[k + 1] = temp;

		}
		list.removeAll(list);
		for (int j = 0; j < arr.length; j++) {
			list.add(arr[j]);
		}
		System.out.println(list);
		return list;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float[] arr = new float[] { 0.897F, 0.565F, 0.656F, 0.1234F, 0.665F, 0.3434F, 0.221F, 0.432F };
		BucketSort obj = new BucketSort(arr);
		obj.bucketSortImpl();

		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}

	}

}
