package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class Iso8583Rev93Tests {
	@Test
	public void TestMessagePackLength() throws Exception {
		Iso8583Rev93 msg = new Iso8583Rev93();
		msg.set(2, "58889212354567816");
		msg.set(3, "270010");
		msg.set(102, "9012273811");
		msg.setMsgType(Iso8583Rev93.MsgType._1200_TRAN_REQ);

		int actual = msg.getPackedLength();

		assertEquals(57, actual);
	}

}
