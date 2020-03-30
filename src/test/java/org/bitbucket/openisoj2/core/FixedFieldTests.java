package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.bitbucket.openisoj2.core.exceptions.FieldFormatException;
import org.junit.Test;

public class FixedFieldTests {
	@Test
	public void implementsValidatorPack() throws Exception {
		// Going to create a numeric field and assign valid length but invalid
		// data to it
		// We're only testing that it implements the validator. All validators
		// are checked
		// in the various tests for them
		Field f = new Field(2, FieldDescriptor.getAsciiN(6));
		f.setValue("12345a");
		try {
			f.toMsg();
			fail("Expected FieldFormatException");
		} catch (FieldFormatException e) {
		}
	}

	@Test
	public void implementsValidatorUnpack() throws Exception {
		// have a look at the comment inside
		// TestFixedFieldImplementsValidatorPack
		byte[] data = new byte[6];
		data[0] = 0x31;
		data[1] = 0x32;
		data[2] = 0x33;
		data[3] = 0x34;
		data[4] = 0x35;
		data[5] = 0x65;
		Field f = new Field(2, FieldDescriptor.getAsciiN(6));
		try {
			f.unpack(data, 0);
			fail("Expected FieldFormatException");
		} catch (FieldFormatException e) {
		}
	}

	@Test
	public void pack() throws Exception {
		Field f = new Field(2, FieldDescriptor.getAsciiAns(6));
		f.setValue("123456");
		byte[] data = f.toMsg();
		byte[] expected = new byte[6];
		expected[0] = 0x31;
		expected[1] = 0x32;
		expected[2] = 0x33;
		expected[3] = 0x34;
		expected[4] = 0x35;
		expected[5] = 0x36;
		assertArrayEquals(expected, data);
	}

	@Test
	public void tooLongPack() throws Exception {
		Field f = new Field(2, FieldDescriptor.getAsciiAns(6));
		f.setValue("1234567");
		try {
			f.toMsg();
			fail("Expected FieldLengthException");
		} catch (FieldFormatException e) {
		}
	}

	@Test
	public void tooShortPack() throws Exception {
		Field f = new Field(2, FieldDescriptor.getAsciiAns(6));
		f.setValue("12345");
		try {
			f.toMsg();
			fail("Expected FieldLengthException");
		} catch (FieldFormatException e) {
		}
	}

	@Test
	public void unpack() throws Exception {
		Field field = new Field(2, FieldDescriptor.getAsciiAns(6));
		byte[] msg = new byte[10];
		msg[0] = 44;
		msg[1] = 45;
		msg[2] = 65;
		msg[3] = 65;
		msg[4] = 65;
		msg[5] = 65;
		msg[6] = 65;
		msg[7] = 65;

		int offset = field.unpack(msg, 2);
		assertEquals(8, offset);
		assertEquals("AAAAAA", field.getValue());
	}
}
