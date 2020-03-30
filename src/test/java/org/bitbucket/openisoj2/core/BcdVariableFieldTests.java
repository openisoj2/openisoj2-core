package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class BcdVariableFieldTests {
	@Test
	public void pack() throws Exception {
		Field f = new Field(2, FieldDescriptor.getBcdVar(2, 15));
		f.setValue("77");
		byte[] actual = f.toMsg();
		byte[] expected = { 0x01, 0x77 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void unpack() throws Exception {
		Field f = new Field(2, FieldDescriptor.getBcdVar(2, 15));

		byte[] msg = new byte[2];
		msg[0] = 0x02;
		msg[1] = 0x77;
		f.unpack(msg, 0);
		String actual = f.getValue();
		String expected = "77";
		assertEquals(expected, actual);
	}
}
