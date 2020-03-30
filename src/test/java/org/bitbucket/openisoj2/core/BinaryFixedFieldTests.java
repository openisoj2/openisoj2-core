package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.bitbucket.openisoj2.core.exceptions.FieldFormatException;
import org.junit.Test;

public class BinaryFixedFieldTests {
	@Test
	public void correctLengthPack() throws Exception {
		Field f = new Field(2, FieldDescriptor.getBinaryFixed(3));
		f.setValue("123456");
		byte[] expected = new byte[3];
		expected[0] = 0x12;
		expected[1] = 0x34;
		expected[2] = 0x56;

		byte[] msg = f.toMsg();

		assertArrayEquals(expected, msg);
	}

	@Test
	public void implementsValidatorPack() throws Exception {
		Field f = new Field(2, FieldDescriptor.getBinaryFixed(3));

		try {
			f.setValue("abcdr5");
			f.toMsg();
			fail("Expected FieldFormatException");
		} catch (FieldFormatException e) {
		}
	}

	@Test
	public void pack() throws Exception {
		Field field = new Field(2, FieldDescriptor.getBinaryFixed(4));
		field.setValue("31323334");
		byte[] expected = new byte[4];
		expected[0] = 0x31;
		expected[1] = 0x32;
		expected[2] = 0x33;
		expected[3] = 0x34;

		byte[] msg = field.toMsg();

		assertArrayEquals(expected, msg);
	}

	@Test
	public void packedLength() throws Exception {
		Field f = new Field(2, FieldDescriptor.getBinaryFixed(4));
		f.setValue("12345678");
		assertEquals(4, f.getPackedLength());
	}

	@Test
	public void tooLongPack() throws Exception {
		Field f = new Field(2, FieldDescriptor.getBinaryFixed(3));
		f.setValue("12345678");
		try {
			f.toMsg();
			fail("Expected FieldLengthException");
		} catch (FieldFormatException e) {
		}
	}

	@Test
	public void tooShortPack() throws Exception {
		Field f = new Field(2, FieldDescriptor.getBinaryFixed(5));
		f.setValue("12345678");
		try {
			f.toMsg();
			fail("Expected FieldLengthException");
		} catch (FieldFormatException e) {
		}
	}

	@Test
	public void unpack() throws Exception {
		Field field = new Field(2, FieldDescriptor.getBinaryFixed(2));
		byte[] msg = new byte[8];
		msg[0] = 65;
		msg[1] = 65;
		msg[2] = 65;
		msg[3] = 65;
		msg[4] = 65;
		msg[5] = 65;
		msg[6] = 65;
		msg[7] = 65;

		int offset = field.unpack(msg, 2);
		assertEquals(4, offset);
		assertEquals("4141", field.getValue());
	}

}
