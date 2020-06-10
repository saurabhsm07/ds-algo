package com.structArrays;

/**
 * Problem Statement :Maximum profit by buying and selling a share at most twice (dynamic programming)
 * 
 * In a daily share trading, a buyer buys shares in the morning and sells it on same day.
 * If the trader is allowed to make at most 2 transactions in a day,
 * where as second transaction can only start after first one is complete (Sell->buy->sell->buy).
 * Given stock prices throughout day, find out maximum profit that a share trader could have made.
 */
public class MaxProfitOnShares {
    /**
     * The function to calculate max profit for at most 2 transactions is divided into 2 parts
     *
     * @param price
     * @return
     */
    private int getMaxProfit(int price[]){

    /** Part 1 : we go from right to left in the price from (n-1 -> 0) array and calculate the
     * max profit made at that point as maximum of profit of transaction ahead of it  and
     * buying at current price and selling at max current price
     * Maximum(profit[i+1],maxPrice-price[i])
     */
    int profit[] = new int[price.length];
    int maxPrice=price[price.length-1];
    for (int i =0;i<profit.length;i++){
        profit[i]=0;
    }
    for (int i=price.length-2;i>=0;i--){
        if(price[i] > maxPrice){
            maxPrice=price[i];
        }

        profit[i]=Math.max(profit[i+1],maxPrice-price[i]);
    }

/** Part 2 : we go from left to right in the price from (1 -> n-1) array and calculate the
 * max profit made at that point as maximum of profit of previous transaction and
 * selling at current price after buying at current minimum
 * Maximum(profit[i-1],price[i]-currentMin)
 */
    int minPrice = price[0];
    for (int i=1;i<price.length;i++){

        if(minPrice>price[i]){
            minPrice=price[i];
        }

        profit[i]=Math.max(profit[i-1],price[i]-minPrice+profit[i]);

    }

    return profit[profit.length-1];
}

public static void main(String args[]){
    MaxProfitOnShares obj = new MaxProfitOnShares();
    int arr[]= new int[]{2, 30, 15, 10, 8, 25, 80};
    int profit=obj.getMaxProfit(arr);
    System.out.println("maximum profit that can be made based on given data = "+profit);
}
}
