package com.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class NumberToText {

	public static void main(String args[]) throws Exception {
		initialize();
		System.out.println(convertNumberToText(-1));
		System.out.println(convertNumberToText(199999999));
		System.out.println(convertNumberToText(8984));
		System.out.println(convertNumberToText(56551));
		System.out.println(convertNumberToText(0));
		System.out.println(convertNumberToText(10));
		System.out.println(convertNumberToText(15));
		System.out.println(convertNumberToText(50));
		System.out.println(convertNumberToText(99));
		System.out.println(convertNumberToText(990));
		System.out.println(convertNumberToText(100));
		System.out.println(convertNumberToText(1000));
		System.out.println(convertNumberToText(10000));
		System.out.println(convertNumberToText(100000));
		System.out.println(convertNumberToText(1000000));
		System.out.println(convertNumberToText(10000000));
		System.out.println(convertNumberToText(100000000));
		System.out.println(convertNumberToText(999999));
		System.out.println(convertNumberToText(9999874));
		System.out.println(convertNumberToText(1999999999));
	}

	static final HashMap<String, String> singleDigitNames = new HashMap<String, String>();
	static final HashMap<String, String> twoDigitNames = new HashMap<String, String>();
	static final HashMap<String, String> otherDigitNames = new HashMap<String, String>();

	public static void initialize() {
		initSingleDigitNumbers();
		initDoubleDigitNumbers();
		initOtherDigitNumbers();
	}

	private static void initSingleDigitNumbers() {
		singleDigitNames.clear();
		singleDigitNames.put("0", "");
		singleDigitNames.put("1", "one");
		singleDigitNames.put("2", "two");
		singleDigitNames.put("3", "three");
		singleDigitNames.put("4", "four");
		singleDigitNames.put("5", "five");
		singleDigitNames.put("6", "six");
		singleDigitNames.put("7", "seven");
		singleDigitNames.put("8", "eight");
		singleDigitNames.put("9", "nine");
		singleDigitNames.put("10", "ten");
	}

	private static void initDoubleDigitNumbers() {
		twoDigitNames.clear();
		twoDigitNames.put("10", "ten");
		twoDigitNames.put("11", "eleven");
		twoDigitNames.put("12", "twelve");
		twoDigitNames.put("13", "thirteen");
		twoDigitNames.put("14", "fourteen");
		twoDigitNames.put("15", "fifteen");
		twoDigitNames.put("16", "sixteen");
		twoDigitNames.put("17", "seventeen");
		twoDigitNames.put("18", "eighteen");
		twoDigitNames.put("19", "nineteen");
		twoDigitNames.put("2", "twenty");
		twoDigitNames.put("3", "thirty");
		twoDigitNames.put("4", "forty");
		twoDigitNames.put("5", "fifty");
		twoDigitNames.put("6", "sixty");
		twoDigitNames.put("7", "seventy");
		twoDigitNames.put("8", "eighty");
		twoDigitNames.put("9", "ninety");
		twoDigitNames.put("100", "hundred");
		twoDigitNames.put("1000", "thousand");
	}

	private static void initOtherDigitNumbers() {
		otherDigitNames.clear();
		otherDigitNames.put("0", "");
		otherDigitNames.put("1", "thousand");
		otherDigitNames.put("2", "million");
	}

	private static ArrayList<String> getNumbersFromNumber(int number) {
		ArrayList<String> numbers = new ArrayList<String>();
		while (number > 9) {
			int value = number % 10;
			numbers.add(String.valueOf(value));
			number = number / 10;
		}
		numbers.add(String.valueOf(number));
		return numbers;
	}

	private static String getTwoDigits(String secondNumber, String firstNumber, String previousString) {

		String twoDigitString = "";
		if((secondNumber.equals("0")) && (firstNumber.equals("0"))){
			twoDigitString = "";
		}else if((secondNumber.equals("0")) && (!firstNumber.equals("0"))){
			twoDigitString = " and " + previousString;
		}else if ((!secondNumber.equals("1")) && (!firstNumber.equals("0"))) {
			twoDigitString = twoDigitNames.get(secondNumber) + " " + previousString;
		}else if ((!secondNumber.equals("1")) && (firstNumber.equals("0"))) {
			twoDigitString = twoDigitNames.get(secondNumber);
		}else
			twoDigitString = twoDigitNames.get(secondNumber + firstNumber);
		return twoDigitString;
	}

	private static String getNumberToText(ArrayList<String> numbersList) {
		String iteratorString = "", finalString = "", firstDigitString = "",tempString = "";
		int i = 0, j = 0;
		Iterator numberIterator = numbersList.iterator();
		while (numberIterator.hasNext()) {
			switch (i) {
			case 0:
				firstDigitString = (String) numberIterator.next();
				iteratorString = singleDigitNames.get(firstDigitString) + " " + iteratorString;
				break;
			case 1:
				iteratorString = getTwoDigits((String) numberIterator.next(), firstDigitString, iteratorString);
				break;
			case 2:
				tempString = (String)numberIterator.next();
				if(!tempString.equals("0") && !iteratorString.equals(""))
					iteratorString = singleDigitNames.get(tempString) + " hundred and " + iteratorString;
				else if(!tempString.equals("0"))
					iteratorString = singleDigitNames.get(tempString) + " hundred" + iteratorString;
				break;
			}
			i++;

			if (i == 3) {
				if(!iteratorString.equals(""))
					finalString = iteratorString + " " +otherDigitNames.get(String.valueOf(j)) + " " + finalString;
				iteratorString = "";
				i = 0;
				j++;
			}
		}
		if ((i >= 1) && (i < 3)){
				finalString = iteratorString + " " +otherDigitNames.get(String.valueOf(j)) + " " +finalString;
		}

		return finalString.trim();
	}

	public static String convertNumberToText(int number) {

		String returnString = "Number Invalid / Not in range";
		if ((number < 1) || (number > 999999999))
			return returnString;

		returnString = getNumberToText(getNumbersFromNumber(number));

		return returnString;
	}
}
