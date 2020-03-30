package org.bitbucket.openisoj2.core;

public class IsoConvert {
	public static String fromIntToMsgType(int value) {
		return new String(fromIntToMsgTypeData(value));
	}

	public static byte[] fromIntToMsgTypeData(int value) {
		byte[] data = new byte[4];
		for (int i = 3; i >= 0; i--) {
			data[i] = (byte) getHexChar(value & 15);
			value >>= 4;
		}
		return data;
	}

	public static int fromMsgTypeDataToInt(byte[] data) {
		int val = 0;
		int len = data.length;
		for (int i = 0; i < len; i++)
			val = val << 4 | getHexNibble(data[i]);

		return val;
	}

	public static int fromMsgTypeToInt(String msgType) {
		return fromMsgTypeDataToInt(msgType.getBytes());
	}

	private static int getHexChar(int nibble) {
		if (nibble < 10)
			return nibble + 48;

		return nibble + 55;
	}

	private static byte getHexNibble(byte data) {
		if (data >= 48 && data <= 57)
			return (byte) (data & 15);
		if (data >= 65 && data <= 70)
			return (byte) (data - 55);
		if (data >= 97 && data <= 102)
			return (byte) (data - 87);

		return 0;
	}
}
