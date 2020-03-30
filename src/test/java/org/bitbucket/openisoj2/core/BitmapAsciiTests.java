package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.bitbucket.openisoj2.core.formatter.AsciiFormatter;
import org.bitbucket.openisoj2.core.formatter.Formatters;
import org.junit.Before;
import org.junit.Test;

public class BitmapAsciiTests {
	private Bitmap bitmap;

	@Test
	public void actualAsciiBitmap() throws Exception {
		byte[] msg = "0230000002C00000".getBytes();
		bitmap = new Bitmap(Formatters.getAscii());
		bitmap.unpack(msg, 0);
		assertFalse(bitmap.isExtendedBitmap());
		assertTrue(bitmap.isFieldSet(7));
		assertTrue(bitmap.isFieldSet(11));
		assertTrue(bitmap.isFieldSet(12));
		assertTrue(bitmap.isFieldSet(39));
		assertTrue(bitmap.isFieldSet(41));
		assertTrue(bitmap.isFieldSet(42));
	}

	@Test
	public void extendedBitmapLength() throws Exception {
		bitmap.setField(2, true);
		bitmap.setField(64, true);
		bitmap.setField(65, true);
		assertEquals(32, bitmap.getPackedLength());
	}

	@Test
	public void extendedToMsg() throws Exception {
		bitmap.setField(2, true);
		bitmap.setField(64, true);
		bitmap.setField(65, true);
		bitmap.setField(128, true);
		byte[] data = bitmap.toMsg();
		byte[] expected = new byte[data.length];
		for (int i = 0; i < expected.length; i++) {
			expected[i] = 0x30; // Make sure it's all padded with zero's
		}

		expected[0] = 67;
		expected[15] = 49;
		expected[16] = 56;
		expected[31] = 49;
		assertArrayEquals(expected, data);
	}

	@Test
	public void newBitmapNotExtended() {
		bitmap.setField(2, true);
		bitmap.setField(64, true);
		assertFalse(bitmap.isExtendedBitmap());
	}

	@Test
	public void newBitmapThatIsExtendedAndThenUnextended() {
		bitmap.setField(2, true);
		bitmap.setField(64, true);
		bitmap.setField(65, true);
		bitmap.setField(65, false);
		assertFalse(bitmap.isExtendedBitmap());
	}

	@Test
	public void newBitmapThenExtended() {
		bitmap.setField(2, true);
		bitmap.setField(64, true);
		bitmap.setField(65, true);
		assertTrue(bitmap.isExtendedBitmap());
	}

	@Test
	public void notExtendedBitmapLength() throws Exception {
		bitmap.setField(2, true);
		bitmap.setField(64, true);
		assertEquals(16, bitmap.getPackedLength());
	}

	@Before
	public void setup() {
		bitmap = new Bitmap(new AsciiFormatter());
	}

	@Test
	public void toMsg() throws Exception {
		bitmap.setField(2, true);
		bitmap.setField(64, true);
		byte[] data = bitmap.toMsg();
		byte[] expected = new byte[data.length];
		for (int i = 0; i < expected.length; i++) {
			expected[i] = 0x30;
		}

		expected[0] = 0x34;
		expected[15] = 0x31;
		assertArrayEquals(expected, data);
	}

	@Test
	public void unpackBitmapExtended() throws Exception {
		byte[] input = new byte[36];
		for (int i = 0; i < input.length; i++) {
			input[i] = 0x30;
		}

		input[4] = 0x43;
		input[4 + 15] = 0x31; // 49
		input[4 + 16] = 0x38; // 56
		input[4 + 31] = 0x31;
		int offset = bitmap.unpack(input, 4);
		assertEquals(36, offset);
		assertTrue(bitmap.isFieldSet(2));
		assertTrue(bitmap.isFieldSet(64));
		assertTrue(bitmap.isFieldSet(65));
		assertTrue(bitmap.isFieldSet(128));
		assertTrue(bitmap.isExtendedBitmap());
		assertFalse(bitmap.isFieldSet(63));
	}

	@Test
	public void unpackBitmapNotExtended() throws Exception {
		byte[] input = new byte[36];
		for (int i = 0; i < input.length; i++) {
			input[i] = 0x30;
		}

		input[4] = 0x34;
		input[4 + 15] = 0x31;
		int offset = bitmap.unpack(input, 4);
		assertEquals(20, offset);
		assertTrue(bitmap.isFieldSet(2));
		assertTrue(bitmap.isFieldSet(64));
		assertFalse(bitmap.isFieldSet(65));
		assertFalse(bitmap.isFieldSet(128));
		assertFalse(bitmap.isExtendedBitmap());
		assertFalse(bitmap.isFieldSet(63));
	}
}
