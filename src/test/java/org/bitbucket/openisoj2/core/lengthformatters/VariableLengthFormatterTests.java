package org.bitbucket.openisoj2.core.lengthformatters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VariableLengthFormatterTests {
	private VariableLengthFormatter _formatter;

	@Before
	public void setup() throws Exception {
		_formatter = new VariableLengthFormatter(2, 12);
	}

	@Test
	public void TestLengthOfField() throws Exception {
		byte[] data = new byte[14];
		data[7] = (byte) '1';
		data[8] = (byte) '0';
		int length = _formatter.getLengthOfField(data, 7);
		assertEquals(10, length);
	}

	@Test
	public void TestLengthOfLengthIndicator() {
		assertEquals(2, _formatter.getLengthOfLengthIndicator());
	}

	@Test
	public void TestPackLength() throws Exception {
		byte[] data = new byte[14];
		int offset = _formatter.pack(data, 8, 2);
		assertEquals(4, offset);
		assertEquals((byte) '0', data[2]);
		assertEquals((byte) '8', data[3]);

	}

	@Test
	public void TestValidity() {
		assertTrue(_formatter.isValidLength(0));
		assertTrue(_formatter.isValidLength(8));
		assertTrue(_formatter.isValidLength(12));
		assertFalse(_formatter.isValidLength(13));
	}
}
