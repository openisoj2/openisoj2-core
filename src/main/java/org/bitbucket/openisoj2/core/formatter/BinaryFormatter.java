package org.bitbucket.openisoj2.core.formatter;

import org.bitbucket.openisoj2.core.Utils;
import org.bitbucket.openisoj2.core.Validators;
import org.bitbucket.openisoj2.core.exceptions.FormatException;

public class BinaryFormatter implements IFormatter {

	public byte[] getBytes(String value) throws Exception {
		if (!Validators.isHex(value)) {
            throw new FormatException("Value \"" + value + "\" is not valid HEX");
        }

		int length = value.length();
		if (length % 2 != 0) {
			length++;
			value = Utils.padLeft(value, length, '0');
		}

		int numberChars = value.length();
		byte[] bytes = new byte[numberChars / 2];

		for (int i = 0; i < numberChars; i += 2) {
            bytes[i / 2] = (byte) Integer.valueOf(value.substring(i, i + 2), 16).intValue();
        }
		return bytes;
	}

	public int getPackedLength(int unpackedLength) {
		if (unpackedLength % 2 != 0) {
            return (unpackedLength + 1) / 2;
        }
		return unpackedLength / 2;
	}

	public String getString(byte[] data) {
		StringBuilder sb = new StringBuilder();
		for (byte b : data) {
			byte highNibble = (byte) ((b & 0xF0) >> 4);
			byte lowNibble = (byte) (b & 0x0F);
			sb.append(Integer.toHexString(highNibble).toUpperCase());
			sb.append(Integer.toHexString(lowNibble).toUpperCase());
		}

		return sb.toString();
	}

}
