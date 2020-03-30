package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdditionalAmountTests {
	@Test
	public void amountPads() {
		AdditionalAmount amount = new AdditionalAmount();
		amount.setAmount("200");
		assertEquals("000000000200", amount.getAmount());
	}

	@Test
	public void constructorTooLong() {

		try {
			String input = "1001840C0000000220000";
			new AdditionalAmount(input);
			fail("Expected ArgumentException");
		} catch (Exception e) {
		}
	}

	@Test
	public void constructorTooShort() {
		String input = "1001840C00000002200";
		try {
			new AdditionalAmount(input);
			fail("Expected ArgumentException");
		} catch (Exception e) {
		}
	}

	@Test
	public void testToString() {
		AdditionalAmount amount = new AdditionalAmount();

		amount.setAccountType("10");
		amount.setAmount("200");
		amount.setAmountType("01");
		amount.setCurrencyCode("840");
		amount.setSign("C");

		String actual = amount.toString();
		String expected = "1001840C000000000200";
		assertEquals(expected, actual);
	}

	@Test
	public void TestValuePropagatesNegative() {
		AdditionalAmount amount = new AdditionalAmount();
		amount.setValue(-2245);
		assertEquals("D", amount.getSign());
		assertEquals("000000002245", amount.getAmount());
	}

	@Test
	public void TestValuePropagatesPositive() {
		AdditionalAmount amount = new AdditionalAmount();
		amount.setValue(2245);
		assertEquals("C", amount.getSign());
		assertEquals("000000002245", amount.getAmount());
	}

	@Test
	public void validConstructor() throws Exception {
		String input = "1001840C000000022000";
		AdditionalAmount amount = new AdditionalAmount(input);
		assertEquals("AccountType", "10", amount.getAccountType());
		assertEquals("AmountType", "01", amount.getAmountType());
		assertEquals("CurrencyCode", "840", amount.getCurrencyCode());
		assertEquals("Sign", "C", amount.getSign());
		assertEquals("Amount", "000000022000", amount.getAmount());
		assertEquals("Value", 22000, amount.getValue());
	}

	@Test
	public void valueNegative() {
		AdditionalAmount amount = new AdditionalAmount();
		amount.setSign("D");
		amount.setAmount("000002000000");
		long expected = -2000000;
		long actual = amount.getValue();
		assertEquals(expected, actual);
	}

	@Test
	public void valuePositive() {
		AdditionalAmount amount = new AdditionalAmount();
		amount.setSign("C");
		amount.setAmount("000002000000");
		long expected = 2000000;
		long actual = amount.getValue();
		assertEquals(expected, actual);
	}
}
