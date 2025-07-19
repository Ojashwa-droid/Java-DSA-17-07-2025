package com.ojas.dsa.searching.linear;

public class StringLinearSearchDemo {
    public static void main(String[] args) {
        String name = "Ojashwa Tripathi";
        char target = 't';
        System.out.println(StringLinearSearchDemo.linearSearch(name, target));
        System.out.println(StringLinearSearchDemo.linearSearchWithForEach(name, target));

        char[] charArray = name.toCharArray();
        System.out.println(charArray);
    }

    public static boolean linearSearch(String name, char target) {

        if (name.isEmpty())
            return false;

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == target)
                return true;
        }

        return false;
    }

    public static boolean linearSearchWithForEach(String name, char target) {

        if (name.isEmpty())
            return false;

        for (char character: name.toCharArray()){
            if (character == target)
                return true;
        }

        return false;
    }
}