package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.bitbucket.openisoj2.core.exceptions.FieldDescriptorException;
import org.bitbucket.openisoj2.core.fieldvalidator.FieldValidators;
import org.bitbucket.openisoj2.core.formatter.Formatters;
import org.bitbucket.openisoj2.core.lengthformatters.FixedLengthFormatter;
import org.bitbucket.openisoj2.core.lengthformatters.VariableLengthFormatter;
import org.junit.Test;

public class FieldDescriptorTests {
	@Test
	public void binaryFieldMustHaveHexValidator() throws Exception {
		try {
			new FieldDescriptor(new FixedLengthFormatter(8), FieldValidators.getNone(), Formatters.getBinary(), null,
					null);
			fail("Binary formatter must have hex validator");
		} catch (FieldDescriptorException e) {
		}
	}

	@Test
	public void testDisplayFixed() throws Exception {
		IFieldDescriptor fd = FieldDescriptor.getAsciiFixed(10, FieldValidators.getN());
		String result = fd.display("   ", 7, "0321164153");
		String expected = "   [Fixed  n      10 010] 007 [0321164153]";
		assertEquals(expected, result);
	}

	@Test
	public void testDisplayFixedAns() throws Exception {
		IFieldDescriptor fd = FieldDescriptor.getAsciiFixed(8, FieldValidators.getAns());
		String result = fd.display("   ", 41, "20202020");
		String expected = "   [Fixed  ans     8 008] 041 [20202020]";
		assertEquals(expected, result);
	}

	@Test
	public void testDisplayLLVarN() throws Exception {
		IFieldDescriptor fd = FieldDescriptor.getAsciiVar(2, 11, FieldValidators.getN());
		String result = fd.display("", 100, "333333");
		String expected = "[L2Var  n    ..11 006] 100 [333333]";
		assertEquals(expected, result);
	}

	@Test
	public void testBinaryVar() throws Exception {
		FieldDescriptor fd = new FieldDescriptor(new VariableLengthFormatter(1, 9, Formatters.getAscii()),
				FieldValidators.getHex(), Formatters.getBinary(), null, null);

		byte[] actual = fd.pack(2, "1234");
		byte[] expected = { 0x32, 0x12, 0x34 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testBinaryVarOddLength() throws Exception {
		FieldDescriptor fd = new FieldDescriptor(new VariableLengthFormatter(1, 9, Formatters.getAscii()),
				FieldValidators.getHex(), Formatters.getBinary(), null, null);

		byte[] actual = fd.pack(2, "91234");
		byte[] expected = { 0x33, 0x09, 0x12, 0x34 };
		assertArrayEquals(expected, actual);
	}
}
