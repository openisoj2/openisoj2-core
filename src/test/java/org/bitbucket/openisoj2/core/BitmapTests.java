package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitmapTests {
	@Test
	public void extendedToMsg() throws Exception {
		Bitmap bitmap = new Bitmap();
		bitmap.setField(2, true);
		bitmap.setField(64, true);
		bitmap.setField(65, true);
		bitmap.setField(128, true);
		byte[] data = bitmap.toMsg();
		byte[] expected = new byte[data.length];
		expected[0] = (byte) 0xC0;
		expected[7] = 0x01;
		expected[8] = (byte) 0x80;
		expected[15] = 0x01;
		assertArrayEquals(expected, data);
	}

	@Test
	public void newBitmapNotExtended() {
		Bitmap bitmap = new Bitmap();
		bitmap.setField(2, true);
		bitmap.setField(64, true);
		assertFalse(bitmap.isExtendedBitmap());
	}

	@Test
	public void newBitmapThatIsExtendedAndThenUnextended() {
		Bitmap bitmap = new Bitmap();
		bitmap.setField(2, true);
		bitmap.setField(64, true);
		bitmap.setField(65, true);
		bitmap.setField(65, false);
		assertFalse(bitmap.isExtendedBitmap());
	}

	@Test
	public void newBitmapThenExtended() {
		Bitmap bitmap = new Bitmap();
		bitmap.setField(2, true);
		bitmap.setField(64, true);
		bitmap.setField(65, true);
		assertTrue(bitmap.isExtendedBitmap());
	}

	@Test
	public void toMsg() throws Exception {
		Bitmap bitmap = new Bitmap();
		bitmap.setField(2, true);
		bitmap.setField(64, true);
		byte[] data = bitmap.toMsg();
		byte[] expected = new byte[data.length];
		expected[0] = 64;
		expected[7] = 1;
		assertArrayEquals(expected, data);
	}

	@Test
	public void unpackBitmapExtended() throws Exception {
		Bitmap bitmap = new Bitmap();
		byte[] input = new byte[22];
		input[4] = (byte) 192;
		input[11] = 1;
		input[12] = (byte) 128;
		input[19] = 1;
		int offset = bitmap.unpack(input, 4);
		assertEquals(20, offset);
		assertTrue(bitmap.isFieldSet(2));
		assertTrue(bitmap.isFieldSet(64));
		assertTrue(bitmap.isFieldSet(65));
		assertTrue(bitmap.isFieldSet(128));
		assertTrue(bitmap.isExtendedBitmap());
		assertFalse(bitmap.isFieldSet(63));
	}

	@Test
	public void unpackBitmapNotExtended() throws Exception {
		Bitmap bitmap = new Bitmap();
		byte[] input = new byte[16];
		input[4] = 64;
		input[11] = 1;
		int offset = bitmap.unpack(input, 4);
		assertEquals(12, offset);
		assertTrue(bitmap.isFieldSet(2));
		assertTrue(bitmap.isFieldSet(64));
		assertFalse(bitmap.isFieldSet(65));
		assertFalse(bitmap.isFieldSet(128));
		assertFalse(bitmap.isExtendedBitmap());
		assertFalse(bitmap.isFieldSet(63));
	}
}
