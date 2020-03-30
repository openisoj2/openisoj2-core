package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.bitbucket.openisoj2.core.formatter.BinaryFormatter;
import org.junit.Test;

public class BinaryFormatterTests {
	@Test
	public void getBytesTest() throws Exception {
		BinaryFormatter target = new BinaryFormatter();
		String value = "0245";
		byte[] expected = new byte[2];
		expected[0] = 0x02;
		expected[1] = 0x45;
		byte[] actual = target.getBytes(value);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void getStringForHighValueByte() {
		BinaryFormatter formatter = new BinaryFormatter();
		byte[] data = new byte[1];
		data[0] = -64;
		String actual = formatter.getString(data);
		assertEquals("C0", actual);
	}

	@Test
	public void getStringLong() throws Exception {
		BinaryFormatter formatter = new BinaryFormatter();
		byte[] data = new byte[8];
		data[0] = 64;
		data[7] = 1;
		String actual = formatter.getString(data);
		assertEquals("4000000000000001", actual);
	}

	@Test
	public void getStringShort() throws Exception {
		BinaryFormatter formatter = new BinaryFormatter();
		byte[] data = new byte[1];
		data[0] = 0x02;
		String val = formatter.getString(data);
		assertEquals("02", val);
	}

	@Test
	public void packedLength() throws Exception {
		BinaryFormatter formatter = new BinaryFormatter();
		int actual = formatter.getPackedLength(8);
		assertEquals(4, actual);
	}

	@Test
	public void unpack() throws Exception {
		BinaryFormatter formatter = new BinaryFormatter();
		byte[] data = new byte[2];
		data[0] = 0x02;
		data[1] = 0x45;
		String actual = formatter.getString(data);
		assertEquals("0245", actual);
	}

	@Test
	public void testPackOddNumber() throws Exception {
		BinaryFormatter formatter = new BinaryFormatter();
		byte[] actual = formatter.getBytes("360");
		byte[] expected = { 0x03, 0x60 };
		assertArrayEquals(expected, actual);
	}
}
