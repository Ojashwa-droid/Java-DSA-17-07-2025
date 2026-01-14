package com.ojas.dsa.arrays.medium;

public class BuyAndSellStocks {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int min = prices[0];

        for (int i = 1; i < n; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            if (prices[i] < min){
                min = prices[i];
            }
        }
        return maxProfit;
    }
}
