package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.bitbucket.openisoj2.core.formatter.BcdFormatter;
import org.junit.Test;

public class BcdFormatterTests {
	@Test
	public void getBytesTest() throws Exception {
		BcdFormatter target = new BcdFormatter();
		String value = "0245";
		byte[] expected = new byte[2];
		expected[0] = 0x02;
		expected[1] = 0x45;
		byte[] actual = target.getBytes(value);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void getStringShort() throws Exception {
		BcdFormatter formatter = new BcdFormatter();
		byte[] data = new byte[1];
		data[0] = 0x02;
		String val = formatter.getString(data);
		assertEquals("02", val);
	}

	@Test
	public void packedLength() throws Exception {
		BcdFormatter formatter = new BcdFormatter();
		int actual = formatter.getPackedLength(8);
		assertEquals(4, actual);
	}

	@Test
	public void unpack() throws Exception {
		BcdFormatter formatter = new BcdFormatter();
		byte[] data = new byte[2];
		data[0] = 0x02;
		data[1] = 0x45;
		String actual = formatter.getString(data);
		assertEquals("0245", actual);
	}
}
