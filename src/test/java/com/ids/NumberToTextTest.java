package com.ids;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NumberToTextTest {

	@Before
	public void initEach(){
		NumberToText.initialize();
	}
	
	@Test
    public void validateNumber() {
		assertEquals("Number Invalid / Not in range", NumberToText.convertNumberToText(-1), "Number Invalid / Not in range");
		assertEquals("one hundred and ninety nine  million nine hundred and ninety nine  thousand nine hundred and ninety nine", NumberToText.convertNumberToText(199999999));
		assertEquals("eight  thousand nine hundred and eighty four", NumberToText.convertNumberToText(8984));
		assertEquals("fifty six  thousand five hundred and fifty one", NumberToText.convertNumberToText(56551));
		assertEquals("Number Invalid / Not in range", NumberToText.convertNumberToText(0));
		assertEquals("ten", NumberToText.convertNumberToText(10));
		assertEquals("fifteen", NumberToText.convertNumberToText(15));
		assertEquals("fifty", NumberToText.convertNumberToText(50));
		assertEquals("ninety nine", NumberToText.convertNumberToText(99));
		assertEquals("nine hundred and ninety", NumberToText.convertNumberToText(990));
		assertEquals("one hundred", NumberToText.convertNumberToText(100));
		assertEquals("one  thousand", NumberToText.convertNumberToText(1000));
		assertEquals("ten thousand", NumberToText.convertNumberToText(10000));
		assertEquals("one hundred thousand", NumberToText.convertNumberToText(100000));
		assertEquals("one  million", NumberToText.convertNumberToText(1000000));
		assertEquals("ten million", NumberToText.convertNumberToText(10000000));
		assertEquals("one hundred million", NumberToText.convertNumberToText(100000000));
		assertEquals("nine hundred and ninety nine  thousand nine hundred and ninety nine", NumberToText.convertNumberToText(999999));
		assertEquals("nine  million nine hundred and ninety nine  thousand eight hundred and seventy four",NumberToText.convertNumberToText(9999874));
		assertEquals("Number Invalid / Not in range", NumberToText.convertNumberToText(1999999999));
    }


}
