package com.ghislaingnimavo.exercice13;

import java.util.*;

public class Exercice13 {

	public static void main(String[] args) {
		Map<Integer, String> immutableMap =
                Map.ofEntries(
                        Map.entry(3,"one"),
                        Map.entry(4,"four"),
                        Map.entry(5,"three"),
                        Map.entry(6,"eleven")
                );

        Map<Integer,String> map = new HashMap<>(immutableMap);
        map.replaceAll((key, value) -> value.toUpperCase());
        map.forEach((key,value)->System.out.println(key+" = "+value));
        System.out.println("========================================");


        List<Integer> keys = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        // Question 2:  altering the map value with map.putIfAbsent
        System.out.println("Map using map.putIfAbsent:");
        for(int key: keys) {
            map.putIfAbsent(key,"");
            System.out.println(key + " = "+map.get(key));
        }

        // Question 3: without altering the map
        System.out.println("==========================================");
        System.out.println("Map using map.getOrDefault:");
        for(int key: keys) {
            System.out.println(key + " = "+map.getOrDefault(key,""));
        }
        System.out.println("==========================================");



        // Question 4
        List<String> words = List.of(
                "one","two","three","four","five","six","seven",
                "eight","nine","ten","eleven","twelve"
        );
        Map<Integer,List<String>> newMap = new HashMap<>();

        for (String value : words) {
            int key = value.length();

            List<String> list = newMap.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(value);
        }
        System.out.println("new map created with words:");
        newMap.forEach((key,value)->System.out.println(key+" = "+value));
        System.out.println("============================================");


        Map<Integer, String> mergeMap = new HashMap<>();
        for (String word:words) {
            int key = word.length();
            mergeMap.merge(key,word,
                    (exitingValue,newValue) ->exitingValue + ", " +newValue);
        }
        System.out.println("Merged map");
        mergeMap.forEach((key,value)->System.out.println(key+" = "+value));
        System.out.println("==============================================");

    }
}