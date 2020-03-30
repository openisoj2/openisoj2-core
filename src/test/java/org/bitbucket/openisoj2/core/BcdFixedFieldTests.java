package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.bitbucket.openisoj2.core.exceptions.FieldDescriptorException;
import org.bitbucket.openisoj2.core.fieldvalidator.FieldValidators;
import org.bitbucket.openisoj2.core.formatter.Formatters;
import org.bitbucket.openisoj2.core.lengthformatters.FixedLengthFormatter;
import org.junit.Test;

public class BcdFixedFieldTests {
	@Test
	public void bcdHasNumericValidator() throws Exception {
		try {
			new FieldDescriptor(new FixedLengthFormatter(8), FieldValidators.getAns(), Formatters.getBcd(), null, null);
			fail("Expected FieldDescriptorException");
		} catch (FieldDescriptorException e) {
		}
	}

	@Test
	public void packedLength() throws Exception {
		Field field = new Field(2, FieldDescriptor.getBcdFixed(4));
		field.setValue("12345678");
		int actual = field.getPackedLength();
		assertEquals(4, actual);
	}

	@Test
	public void packTest() throws Exception {
		Field field = new Field(2, FieldDescriptor.getBcdFixed(2));
		field.setValue("0012");
		byte[] actual = field.toMsg();
		byte[] expected = new byte[] { 0x00, 0x12 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void unpackTest() throws Exception {
		Field field = new Field(2, FieldDescriptor.getBcdFixed(4));
		byte[] msg = new byte[] { 0x00, 0x12 };
		field.unpack(msg, 0);
		String actual = field.getValue();
		String expected = "0012";
		assertEquals(expected, actual);
	}
}
