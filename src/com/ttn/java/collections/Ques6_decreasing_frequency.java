package com.ttn.java.collections;

/**
 * 6. Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.
 */

import java.util.*;

public class Ques6_decreasing_frequency {
    public static LinkedHashMap<Integer, Integer> sortByValues( LinkedHashMap<Integer, Integer> hashMap){

        List<Map.Entry<Integer, Integer>> listOfEntries = new LinkedList<>(hashMap.entrySet());

        Collections.sort(listOfEntries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -(o1.getValue().compareTo(o2.getValue()));
            }
        });

        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<Integer, Integer> entry : listOfEntries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of Array: ");
        int size = scan.nextInt();
        int num;
        System.out.println("Enter the elements: ");
        LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
        for(int i = 0 ; i < size; i++){
            num = scan.nextInt();
            if(hm.containsKey(num)){
                hm.put(num, hm.get(num) + 1);
            }
            else{
                hm.put(num, 1);
            }
        }

        HashMap<Integer, Integer> sortedMap = sortByValues(hm);

        System.out.println("Sorted Map: " + sortedMap);

    }
}
