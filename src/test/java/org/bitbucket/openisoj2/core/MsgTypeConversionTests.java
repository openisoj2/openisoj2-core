package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class MsgTypeConversionTests {
	@Test
	public void test0200() {
		int rsp = Iso8583.MsgType.getResponse(0x200);
		assertEquals(0x210, rsp);
	}

	@Test
	public void test0201() {
		int rsp = Iso8583.MsgType.getResponse(0x201);
		assertEquals(0x210, rsp);
	}

	@Test
	public void test1804() {
		int rsp = Iso8583.MsgType.getResponse(0x1804);
		assertEquals(0x1814, rsp);
	}

	@Test
	public void test0210toOrig() {
		int orig = Iso8583.MsgType.getOriginal(0x210);
		assertEquals(0x200, orig);
	}

	@Test
	public void test0430toOrig() {
		int orig = Iso8583.MsgType.getOriginal(0x430);
		assertEquals(0x420, orig);
	}

	@Test
	public void test1814toOrig() {
		int orig = Iso8583.MsgType.getOriginal(0x1814);
		assertEquals(0x1804, orig);
	}
}
