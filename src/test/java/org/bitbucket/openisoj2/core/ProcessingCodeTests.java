package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProcessingCodeTests {
	@Test
	public void tooLong() throws Exception {
		String data = "1234567";
		try {
			new ProcessingCode(data);
			fail("Failed length processing");
		} catch (Exception e) {
		}
	}

	@Test
	public void tooShort() throws Exception {
		String data = "12345";
		try {
			new ProcessingCode(data);
			fail("Failed length processing");
		} catch (Exception e) {
		}
	}

	@Test
	public void validConstructor() throws Exception {
		String data = "112233";
		ProcessingCode proc = new ProcessingCode(data);
		assertEquals("11", proc.getTranType());
		assertEquals("22", proc.getFromAccountType());
		assertEquals("33", proc.getToAccountType());
	}
}
