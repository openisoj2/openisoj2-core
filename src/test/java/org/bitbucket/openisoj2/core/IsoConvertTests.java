package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsoConvertTests {
	@Test
	public void fromIntToMsgType() {
		String res = IsoConvert.fromIntToMsgType(0x200);
		assertEquals("0200", res);
	}

	@Test
	public void fromMsgTypeToInt() {
		int res = IsoConvert.fromMsgTypeToInt("0200");
		assertEquals(0x200, res);
	}
}
