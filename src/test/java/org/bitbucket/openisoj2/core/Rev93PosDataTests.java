package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Rev93PosDataTests {
	@Test
	public void testConstruct() {
		String expected = "810101211148101";
		Iso8583Rev93.PosDataCode pdc = new Iso8583Rev93.PosDataCode();
		pdc.setCardDataInputCapability(Iso8583Rev93.PosDataCode.CardDataInputCapability._8_MAGSTRIPE_ICC);
		pdc.setCardholderAuthCapability(Iso8583Rev93.PosDataCode.CardholderAuthCapability._1_PIN);
		pdc.setCardCaptureCapability(Iso8583Rev93.PosDataCode.CardCaptureCapability._0_NONE);
		pdc.setOperatingEnvironment(Iso8583Rev93.PosDataCode.OperatingEnvironment._1_ATTENDED_ON_ACCEPTOR_PREMISES);
		pdc.setCardholderPresent(Iso8583Rev93.PosDataCode.CardholderPresent._0_PRESENT);
		pdc.setCardPresent(Iso8583Rev93.PosDataCode.CardPresent._1_PRESENT);
		pdc.setCardDataInputMode(Iso8583Rev93.PosDataCode.CardDataInputMode._2_MAGSTRIPE);
		pdc.setCardholderAuthMethod(Iso8583Rev93.PosDataCode.CardholderAuthMethod._1_PIN);
		pdc.setCardholderAuthEntity(Iso8583Rev93.PosDataCode.CardholderAuthEntity._1_ICC);
		pdc.setCardDataOutputCapability(Iso8583Rev93.PosDataCode.CardDataOutputCapability._1_NONE);
		pdc.setTerminalOutputCapability(Iso8583Rev93.PosDataCode.TerminalOutputCapability._4_PRINTING_AND_DISPLAY);
		pdc.setPinCaptureCapability(Iso8583Rev93.PosDataCode.PinCaptureCapability._8_EIGHT);
		pdc.setTerminalOperator(Iso8583Rev93.PosDataCode.TerminalOperator._1_CARD_ACCEPTOR_OPERATED);
		pdc.setTerminalType(Iso8583Rev93.PosDataCode.TerminalType._01_POS);

		assertEquals(expected, pdc.toString());
	}

	@Test
	public void testUnpack() {
		String msg = "810101211148101";
		Iso8583Rev93.PosDataCode pdc = new Iso8583Rev93.PosDataCode(msg);
		Assert.assertEquals(Iso8583Rev93.PosDataCode.CardDataInputCapability._8_MAGSTRIPE_ICC, pdc.getCardDataInputCapability());
		Assert.assertEquals(Iso8583Rev93.PosDataCode.CardholderAuthCapability._1_PIN, pdc.getCardholderAuthCapability());
		Assert.assertEquals(Iso8583Rev93.PosDataCode.CardCaptureCapability._0_NONE, pdc.getCardCaptureCapability());
		Assert.assertEquals(Iso8583Rev93.PosDataCode.OperatingEnvironment._1_ATTENDED_ON_ACCEPTOR_PREMISES, pdc.getOperatingEnvironment());
		Assert.assertEquals(Iso8583Rev93.PosDataCode.CardholderPresent._0_PRESENT, pdc.getCardholderPresent());
		Assert.assertEquals(Iso8583Rev93.PosDataCode.CardPresent._1_PRESENT, pdc.getCardPresent());
		Assert.assertEquals(Iso8583Rev93.PosDataCode.CardDataInputMode._2_MAGSTRIPE, pdc.getCardDataInputMode());
		Assert.assertEquals(Iso8583Rev93.PosDataCode.CardholderAuthMethod._1_PIN, pdc.getCardholderAuthMethod());
		Assert.assertEquals(Iso8583Rev93.PosDataCode.CardholderAuthEntity._1_ICC, pdc.getCardholderAuthEntity());
		Assert.assertEquals(Iso8583Rev93.PosDataCode.CardDataOutputCapability._1_NONE, pdc.getCardDataOutputCapability());
		Assert.assertEquals(Iso8583Rev93.PosDataCode.TerminalOutputCapability._4_PRINTING_AND_DISPLAY, pdc.getTerminalOutputCapability());
		Assert.assertEquals(Iso8583Rev93.PosDataCode.PinCaptureCapability._8_EIGHT, pdc.getPinCaptureCapability());
		Assert.assertEquals(Iso8583Rev93.PosDataCode.TerminalOperator._1_CARD_ACCEPTOR_OPERATED, pdc.getTerminalOperator());
		Assert.assertEquals(Iso8583Rev93.PosDataCode.TerminalType._01_POS, pdc.getTerminalType());
	}
}
