package com.ghislaingnimavo.exercice12;

import java.util.function.Predicate;


public class IsVoyelle <E> implements Predicate<String>{
	@Override
	public boolean test(String word) {
		return "eaiouyEAIOUY".indexOf(word.charAt(0)) >= 0;
	}
}