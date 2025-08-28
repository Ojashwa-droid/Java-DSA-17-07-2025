package com.ojas.dsa.sorting.problems;

public class StringPalindrome {
    public static void main(String[] args) {
        String string = null;
        System.out.println(isPalindrome(string));


    }
    public static boolean isPalindrome(String string){
        // "abcdedcba" is palindrome

        if (string == null || string.isEmpty()){
            return true;
        }

        int start = 0;
        int end = string.length() - 1;
        while (start <= end){
            if (string.charAt(start) != string.charAt(end)){
                return false;
            } else {
                start ++;
                end --;
            }
        }
        // If the return statement in the while loop does not get executed then that means the string is a palindrome.
        // return true
        return true;
    }
}