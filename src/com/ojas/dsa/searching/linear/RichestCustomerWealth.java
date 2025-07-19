package com.ojas.dsa.searching.linear;

// Leetcode: 1672

public class RichestCustomerWealth {
    public static void main(String[] args) {

        int[][] accounts = {
                {1, 2, 3},
                {3, 2, 1},
                {5, 6, 2}
        };
        int i = maximumWealth(accounts);
        System.out.println(i);
    }

    private static int maximumWealth(int[][] accounts) {

        // person = row
        // account = col

        int maxWealth = Integer.MIN_VALUE;
        for (int person = 0; person < accounts.length; person++) {
            // When you start a new column, take a sum for that row
            int sum = 0;
            for (int account = 0; account < accounts[person].length; account++) {
                sum += accounts[person][account];
            }
            if (sum > maxWealth)
                maxWealth = sum;
        }

        return maxWealth;
    }
}
