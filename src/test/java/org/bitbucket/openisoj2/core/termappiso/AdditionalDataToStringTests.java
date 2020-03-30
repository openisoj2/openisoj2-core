package org.bitbucket.openisoj2.core.termappiso;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdditionalDataToStringTests {
	@Test
	public void testPosData() throws Exception {
		AdditionalData data = new AdditionalData();
		data.put(AdditionalData.Field.PosData, "123456");
		String actual = data.toString("    ");
		String expected = "    [Additional Data     ] 048.001 [123456]";
		assertEquals(expected, actual);
	}

	@Test
	public void testTwoFields() throws Exception {
		String newline = System.getProperty("line.separator");
		AdditionalData data = new AdditionalData();
		data.put(AdditionalData.Field.PosData, "123456");
		data.put(AdditionalData.Field.BankDetails, "654321");
		String actual = data.toString("    ");
		String expected = "    [Additional Data     ] 048.001 [123456]" + newline
				+ "    [Additional Data     ] 048.013 [654321]";
		assertEquals(expected, actual);
	}
}
