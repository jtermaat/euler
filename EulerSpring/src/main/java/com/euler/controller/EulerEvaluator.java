package com.euler.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EulerEvaluator {


	public static Integer getEulerSolution(Integer seed) {
		return getAmicableSum(seed);
	}
	
	private static Set<Integer> getDivisors(Integer input) {
		Set<Integer> divisors = new HashSet<Integer>();
		// Only need search up to sqrt to find paired divisors
		for (int i = 1;i<(int)(Math.sqrt((double)input));i++) {
			if (input % i == 0) {
				divisors.add(i);
				Integer otherDivisor = (int)((double)input / (double)i);
				if (!otherDivisor.equals(input)) {
					divisors.add(otherDivisor);
				}
			}
		}
		return divisors;
	}
	
	private static Integer getSumOfDivisors(Integer input) {
		Set<Integer> divisors = getDivisors(input);
		Integer sum = 0;
		for (Integer divisor : divisors) {
			sum += divisor;
		}
		return sum;
	}
	
	private static Set<Integer> getAmicableNumbers(Integer upperLimit) {
		Map<Integer, Integer> divisorSumsMap = new HashMap<Integer, Integer>();
		Set<Integer> amicables = new HashSet<Integer>();
		for (int i = 0;i<upperLimit;i++) {
			divisorSumsMap.put(i, getSumOfDivisors(i));
		}
		for (int i = 0;i<upperLimit;i++) {
			Integer divisorSum = getSumOfDivisors(i);
			if (divisorSumsMap.get(divisorSum) != null && divisorSumsMap.get(divisorSum).equals(i)) {
				if (!divisorSum.equals(i)) {
					amicables.add(i);
					amicables.add(divisorSum);
				}
			}
		}
		return amicables;
	}
	
	private static Integer getAmicableSum(Integer upperLimit) {
		Set<Integer> amicableNumbers = getAmicableNumbers(upperLimit);
		Integer sum = 0;
		for (Integer amicable : amicableNumbers) {
			sum += amicable;
		}
		return sum;
		
	}
}
