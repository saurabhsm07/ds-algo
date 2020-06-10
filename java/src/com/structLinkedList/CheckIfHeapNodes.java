package com.structLinkedList;

public class CheckIfHeapNodes {
public static void mfCalculator(int yearCount,double monthlyInvestment,double interestRate){
	double total=0;
	for (int i = 1; i <=yearCount; i++) {
		double annualIntrest =interestRate*((monthlyInvestment*12)+total)/100;
		total+=(monthlyInvestment*12)+(annualIntrest); 
	System.out.println("year count = "+i+" capital= "+total);
	}
	System.out.println("in "+yearCount+" years= "+total);
}
	public static void main(String[] args) {
//	String web ="068516fbdcbd9b66f6fec2d9cae8150b";
//	String folder ="068516fbdcbd9b66f6fec2d9cae8150b";
//	String location ="068516fbdcbd9b66f6fec2d9cae8150b";
//	System.out.println(web.equals(folder));
//	System.out.println(location.equals(web));
//	
//	String web1 ="ab2ce82aa6c4c41397507d0754b03673";
//	String folder1 ="ab2ce82aa6c4c41397507d0754b03673";
//	String location1 ="ab2ce82aa6c4c41397507d0754b03673";
//	System.out.println(web1.equals(folder1));
//	System.out.println(location1.equals(web1));

	mfCalculator(20,2000,20);
	}
}
