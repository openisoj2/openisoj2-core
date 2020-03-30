package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import java.util.Hashtable;
import java.util.List;

import org.bitbucket.openisoj2.core.Ministatement.Tag;
import org.junit.Test;

public class MinistatementTests {
	@Test
	public void testUnpack() {
		String msStr = "DATE_TIME|SEQ_NR|TRAN_TYPE|TRAN_AMOUNT|CURR_CODE~20121104120000|000000|01|005|840~20121104120000|000000|01|013|840~20121104120000|000000|42|5000|840~";
		Ministatement ms = new Ministatement();
		ms.parse(msStr);
		List<String> tags = ms.getTags();
		List<Hashtable<String, String>> lines = ms.getLines();
		assertEquals(5, tags.size());
		String[] expectedTags = { "DATE_TIME", "SEQ_NR", "TRAN_TYPE", "TRAN_AMOUNT", "CURR_CODE" };
		assertArrayEquals(expectedTags, tags.toArray());

		assertEquals(3, lines.size());
		Hashtable<String, String> line = lines.get(0);
		assertEquals("20121104120000", line.get(Tag.DATE_TIME));
		assertEquals("840", line.get(Tag.CURR_CODE));
	}
}
