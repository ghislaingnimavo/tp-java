package com.ghislaingnimavo.exercice12;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

public class Exercice12 {

	public static void main(String[] args) {

		IsVoyelle voyelle = new IsVoyelle();
		List<String> words = new ArrayList<>(Arrays.asList(
				"one",
				"two",
				"three",
				"four",
				"five",
				"six",
				"seven",
				"eight",
				"nine",
				"ten",
				"eleven",
				"twelve"));

		words.forEach(System.out::println);

		Iterator<String> iterator = words.iterator();

		while (iterator.hasNext()) {
			String word = iterator.next();
			if (word.length() % 2 == 0) {
				iterator.remove();
			}
		}

		words.forEach((String word) -> {
			if (voyelle.test(word)) {
				word = word.substring(0, 1).toUpperCase() + word.substring(1,word.length());
			}
			System.out.println(word);
		});

		Comparator<String> c1= (String s1, 
				String s2)-> s1.length()-s2.length();
				words.sort((c1.reversed()));
				System.out.println("tri des mots: ");
				words.forEach(s -> 
				System.out.println(s));
		
		Comparator <String> c2 = (String s1, String s2)->
				{
					if(s1.length() == s2.length())
					{
						return s1.compareTo(s2); 
					}
					else 
					{
						return c1.compare(s1, s2); 
					}
				};

	}

}
