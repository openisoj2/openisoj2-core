package org.bitbucket.openisoj2.core.formatter;

import org.bitbucket.openisoj2.core.Utils;

public class BcdFormatter implements IFormatter {

	public byte[] getBytes(String value) throws Exception {
		if (value.length() % 2 == 1) {
            value = Utils.padLeft(value, value.length() + 1, '0');
        }

		char[] chars = value.toCharArray();
		int length = chars.length / 2;

		byte[] bytes = new byte[length];

		for (int i = 0; i < length; i++) {
			byte highNibble = Byte.parseByte(String.valueOf(chars[2 * i]));
			byte lowNibble = Byte.parseByte(String.valueOf(chars[2 * i + 1]));

			bytes[i] = (byte) ((byte) (highNibble << 4) | lowNibble);
		}

		return bytes;
	}

	public int getPackedLength(int unpackedLength) throws Exception {
		return unpackedLength / 2;
	}

	public String getString(byte[] data) throws Exception {
		StringBuffer sb = new StringBuffer();
		for (byte b : data) {
			byte highNibble = (byte) ((b & 0xF0) >> 4);
			byte lowNibble = (byte) (b & 0x0F);
			sb.append(highNibble);
			sb.append(lowNibble);
		}

		return sb.toString();
	}

}
