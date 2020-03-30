package org.bitbucket.openisoj2.core.termappiso;

import static org.junit.Assert.*;

import org.bitbucket.openisoj2.core.Iso8583TermApp;
import org.junit.Test;

public class AdditionalDataTests {
	@Test
	public void testPack() throws Exception {
		AdditionalData addData = new AdditionalData();
		addData.put(AdditionalData.Field.PosData, "2020202012345601234");
		byte[] actual = addData.toMsg();
		byte[] expected = { 0x30, 0x30, 0x32, 0x34, (byte) 0xf0, 0x00, 0x21, (byte) 0x80, 0x00, 0x32, 0x30, 0x32, 0x30,
				0x32, 0x30, 0x32, 0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x30, 0x31, 0x32, 0x33, 0x34 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testLength() throws Exception {
		AdditionalData addData = new AdditionalData();
		addData.put(AdditionalData.Field.PosData, "2020202012345601234");
		assertEquals(28, addData.getPackedLength());
	}

	@Test
	public void testAddDataInMsg() throws Exception {
		AdditionalData addData = new AdditionalData();
		addData.put(AdditionalData.Field.PosData, "2020202012345601234");
		Iso8583TermApp msg = new Iso8583TermApp();
		msg.putAdditionalData(addData);
		byte[] actual = msg.toMsg();
		byte[] expected = { 0x42, 0x30, 0x30, 0x30, 0x30, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x30, 0x30,
				0x32, 0x34, (byte) 0xf0, 0x00, 0x21, (byte) 0x80, 0x00, 0x32, 0x30, 0x32, 0x30, 0x32, 0x30, 0x32, 0x30,
				0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x30, 0x31, 0x32, 0x33, 0x34 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testAddNotData() throws Exception {
		AdditionalData addData = new AdditionalData();
		addData.put(AdditionalData.Field.AddNodeData, "Nwrk");
		addData.toMsg();
	}
}
