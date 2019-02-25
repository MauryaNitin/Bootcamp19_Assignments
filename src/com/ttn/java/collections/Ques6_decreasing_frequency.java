package com.ttn.java.collections;

/**
 * 6. Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.
 */

import java.util.*;

public class Ques6_decreasing_frequency {
    public static Map<Character, Integer> sortByValues( Map<Character, Integer> hashMap){

        List<Map.Entry<Character, Integer>> listOfEntries = new LinkedList<>(hashMap.entrySet());

        Collections.sort(listOfEntries, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return -(o1.getValue().compareTo(o2.getValue()));
            }
        });

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<Character, Integer> entry : listOfEntries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = scan.nextLine();

        char[] characters = str.replaceAll(" ", "").trim().toCharArray();
        Map<Character, Integer> hm = new LinkedHashMap<>();

        for(int i = 0 ; i < characters.length; i++){
            if(hm.containsKey(characters[i])){
                hm.put(characters[i], hm.get(characters[i]) + 1);
            }
            else{
                hm.put(characters[i], 1);
            }
        }

        Map<Character, Integer> sortedMap = sortByValues(hm);

        System.out.println("Sorted Map: " + sortedMap);

    }
}
