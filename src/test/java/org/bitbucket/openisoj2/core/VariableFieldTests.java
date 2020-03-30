package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.bitbucket.openisoj2.core.exceptions.FieldFormatException;
import org.bitbucket.openisoj2.core.fieldvalidator.FieldValidators;
import org.junit.Test;

public class VariableFieldTests {
	@Test
	public void implementsValidatorPack() throws Exception {
		// Going to create a numeric field and assign valid length but invalid
		// data to it
		// We're only testing that it implements the validator. All validators
		// are checked
		// in the various tests for them
		Field f = new Field(2, FieldDescriptor.getAsciiVar(2, 7, FieldValidators.getN()));
		f.setValue("12345a");
		try {
			f.toMsg();
			fail("Expected FieldFormatException");
		} catch (FieldFormatException e) {
		}
	}

	@Test
	public void implementsValidatorUnpack() throws Exception {
		byte[] data = "0612345a".getBytes();
		Field f = new Field(2, FieldDescriptor.getAsciiVar(2, 7, FieldValidators.getN()));
		try {
			f.unpack(data, 0);
			fail("Expected FieldFormatException");
		} catch (FieldFormatException e) {
		}
	}

	@Test
	public void pack() throws Exception {
		Field field = new Field(2, FieldDescriptor.getAsciiVar(2, 20, FieldValidators.getAns()));
		field.setValue("Hello dear bobbit");
		byte[] expected = "17Hello dear bobbit".getBytes();

		byte[] actual = field.toMsg();

		assertArrayEquals(expected, actual);
	}

	@Test
	public void packedLength() throws Exception {
		Field field = new Field(2, FieldDescriptor.getAsciiVar(2, 19, FieldValidators.getN()));
		field.setValue("58889212344567886");
		assertEquals(19, field.getPackedLength());
	}

	@Test
	public void tooLongPack() throws Exception {
		Field field = new Field(2, FieldDescriptor.getAsciiVar(2, 16, FieldValidators.getAns()));
		field.setValue("Hello dear bobbit");

		try {
			field.toMsg();
			fail("Expecting FieldLengthException");
		} catch (FieldFormatException e) {
		}
	}

	@Test
	public void tooLongUnpack() throws Exception {
		byte[] msg = "05hello".getBytes();
		Field field = new Field(2, FieldDescriptor.getAsciiVar(2, 4, FieldValidators.getAns()));
		try {
			field.unpack(msg, 0);
			fail("Expected FieldLengthException");
		} catch (FieldFormatException e) {
		}
	}

	@Test
	public void unpack() throws Exception {
		Field field = new Field(2, FieldDescriptor.getAsciiVar(2, 20, FieldValidators.getAns()));
		byte[] msg = "xxxxx17Hello dear bobbityyyyyyy".getBytes();

		int offset = field.unpack(msg, 5);
		assertEquals(24, offset);
		assertEquals("Hello dear bobbit", field.getValue());
	}

}
