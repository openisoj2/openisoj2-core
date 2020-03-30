package org.bitbucket.openisoj2.core.termappiso;

import static org.junit.Assert.*;

import org.bitbucket.openisoj2.core.HashtableMessage;
import org.bitbucket.openisoj2.core.Iso8583TermApp;
import org.junit.Test;

public class StructuredDataTests {
	@Test
	public void testField48NoF16() throws Exception {
		Iso8583TermApp msg = new Iso8583TermApp();
		AdditionalData addData = new AdditionalData();
		addData.put(AdditionalData.Field.PosData, "123456");
		msg.putAdditionalData(addData);
		assertTrue(msg.isFieldSet(Iso8583TermApp.Bit._048_PRIVATE_ADDITIONAL_DATA));
		assertNull(msg.getStructuredData());
	}

	@Test
	public void testGetStructuredData() throws Exception {
		Iso8583TermApp msg = new Iso8583TermApp();
		AdditionalData addData = new AdditionalData();
		addData.put(AdditionalData.Field.StructuredData, "13PSI11V");
		msg.putAdditionalData(addData);
		assertTrue(msg.isFieldSet(Iso8583TermApp.Bit._048_PRIVATE_ADDITIONAL_DATA));
		assertNotNull(msg.getStructuredData());
		assertEquals("V", msg.getStructuredData().get("PSI"));
	}

	@Test
	public void testNoField48() throws Exception {
		Iso8583TermApp msg = new Iso8583TermApp();
		assertFalse(msg.isFieldSet(Iso8583TermApp.Bit._048_PRIVATE_ADDITIONAL_DATA));
		assertNull(msg.getStructuredData());
	}

	@Test
	public void testPutStructuredDataEmtpy() throws Exception {
		Iso8583TermApp msg = new Iso8583TermApp();
		HashtableMessage sd = new HashtableMessage();
		sd.put("PSI", "V");
		msg.putStructuredData(sd);
		AdditionalData addData = msg.getAdditionalData();
		assertEquals("13PSI11V", addData.get(AdditionalData.Field.StructuredData));
	}

	@Test
	public void testPutStructuredDataExistingAddData() throws Exception {
		Iso8583TermApp msg = new Iso8583TermApp();
		AdditionalData addData = new AdditionalData();
		addData.put(AdditionalData.Field.PosData, "FieldData");
		msg.putAdditionalData(addData);
		HashtableMessage sd = new HashtableMessage();
		sd.put("ABC", "1234");
		msg.putStructuredData(sd);

		HashtableMessage checkSd = msg.getStructuredData();
		assertNotSame(sd, checkSd);
		assertTrue(checkSd.containsKey("ABC"));

		AdditionalData checkData = msg.getAdditionalData();
		assertEquals(checkData.get(AdditionalData.Field.PosData), "FieldData");
	}

	@Test
	public void testPutStructuredDataExistingSd() throws Exception {
		Iso8583TermApp msg = new Iso8583TermApp();
		AdditionalData addData = new AdditionalData();
		addData.put(AdditionalData.Field.StructuredData, "13PSI11V");
		msg.putAdditionalData(addData);
		HashtableMessage sd = new HashtableMessage();
		sd.put("ABC", "1234");
		msg.putStructuredData(sd);

		HashtableMessage checkSd = msg.getStructuredData();
		assertNotSame(sd, checkSd);
		assertTrue(checkSd.containsKey("ABC"));
		assertFalse(checkSd.containsKey("PSI"));
	}
}
