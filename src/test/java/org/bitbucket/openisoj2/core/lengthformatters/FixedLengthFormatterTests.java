package org.bitbucket.openisoj2.core.lengthformatters;

import static org.junit.Assert.*;

import org.junit.Test;

public class FixedLengthFormatterTests {
	private FixedLengthFormatter formatter = new FixedLengthFormatter(8);

	@Test
	public void lengthOfField() {
		byte[] data = new byte[14];
		int length = formatter.getLengthOfField(data, 7);
		assertEquals(8, length);
	}

	@Test
	public void lengthOfLengthIndicator() {
		assertEquals(0, formatter.getLengthOfLengthIndicator());
	}

	@Test
	public void packLength() {
		byte[] data = new byte[4];
		int offset = formatter.pack(data, 8, 2);
		assertEquals(2, offset);
		assertArrayEquals(new byte[4], data);
	}

	@Test
	public void validity() {
		assertFalse(this.formatter.isValidLength(0));
		assertFalse(this.formatter.isValidLength(7));
		assertFalse(this.formatter.isValidLength(9));
		assertTrue(this.formatter.isValidLength(8));
	}
}
