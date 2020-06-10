package com.algorithims.divideAndConquer;

import java.util.Scanner;

/**
 * Created by saurabh_mahambrey on 1/15/2019.
 *
 * Problem Statement : Given two integers x and n, write a function to compute xn
 *
 */
public class CustomPowerFunctions {
    private int number,power;

    public CustomPowerFunctions(int number,int power){
        this.number=number;
        this.power=power;
    }

    /**
     *
     * @param number
     * @param power
     * @return
     *
     * complexity 0(n) but can be done in 0(logn) by storing value of pow(n,p/2) in temporay variable
     */
    protected long customPowerFunc1(int number,int power){

        if(power==1)
              return number;
        if(power==0)
              return 1;
        long temp=customPowerFunc1(number,power/2);
        if(power%2!=0)
              return temp*temp*customPowerFunc1(number,1);
        else
              return temp*temp;
    }

    public static void main(String[] args) {

        CustomPowerFunctions obj;
        Scanner scn = new Scanner(System.in);

        System.out.println("enter the number and its power");
        obj=new CustomPowerFunctions(scn.nextInt(),scn.nextInt());
        System.out.println("customPow1("+obj.number+","+obj.power+") ="+obj.customPowerFunc1(obj.number,obj.power));
    }
}
