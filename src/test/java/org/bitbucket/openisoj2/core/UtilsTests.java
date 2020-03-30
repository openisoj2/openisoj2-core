package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTests {
	@Test
	public void maskPan() {
		String pan = "1234567890123456";
		String expected = "123456******3456";
		String actual = Utils.maskPan(pan);
		assertEquals(expected, actual);
	}

	@Test
	public void maskPanShort() {
		String shortPan = "1234567890";
		String actualShort = Utils.maskPan(shortPan);
		assertEquals(shortPan, actualShort);
	}

	@Test
	public void msgTypeToInt() {
		assertEquals(0x200, Utils.msgTypeToInt("0200"));
		assertEquals(0x1200, Utils.msgTypeToInt("1200"));
		assertEquals(0x1804, Utils.msgTypeToInt("1804"));
		assertEquals(0x9430, Utils.msgTypeToInt("9430"));
	}

	@Test
	public void msgTypeToString() {
		assertEquals("0200", Utils.msgTypeToString(0x200));
		assertEquals("1200", Utils.msgTypeToString(0x1200));
		assertEquals("1804", Utils.msgTypeToString(0x1804));
		assertEquals("9430", Utils.msgTypeToString(0x9430));
	}

	@Test
	public void testGetRequestMsgType() {
		assertEquals(0x200, Utils.getRequestMsgType(0x200));
		assertEquals(0x200, Utils.getRequestMsgType(0x210));
		assertEquals(0x420, Utils.getRequestMsgType(0x420));
		assertEquals(0x420, Utils.getRequestMsgType(0x430));
	}
}
