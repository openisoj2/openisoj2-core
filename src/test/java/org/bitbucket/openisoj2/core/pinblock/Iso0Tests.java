package org.bitbucket.openisoj2.core.pinblock;

import static org.junit.Assert.*;

import org.bitbucket.openisoj2.core.formatter.Formatters;
import org.junit.Test;

public class Iso0Tests {
	@Test
	public void testPinBlockCreation() throws Exception {
		Iso0 iso = new Iso0();
		String clear = Formatters.getBinary().getString(iso.createPinBlock("4201672121493006", "4321"));
		assertEquals("0443378DEDEB6CFF", clear);
	}

	@Test
	public void testLongPin() throws Exception {
		Iso0 iso = new Iso0();
		String clear = Formatters.getBinary().getString(iso.createPinBlock("4201672121493006", "1234567"));
		assertEquals("071222246DEB6CFF", clear);
	}

	@Test
	public void testExtractAccountNumberPart() {
		String actual = Iso0.extractAccountNumberPart("4201672121493006");
		String expected = "167212149300";
		assertEquals(expected, actual);
	}

}
