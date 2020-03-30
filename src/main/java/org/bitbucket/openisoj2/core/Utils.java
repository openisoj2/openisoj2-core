package org.bitbucket.openisoj2.core;

public class Utils {
	/**
	 * Converts a byte array into a hex string.
	 * 
	 * @param byteArray
	 *            the byte array source
	 * @return a hex string representing the byte array
	 */
	public static String byteArrayToHexString(final byte[] byteArray) {
		if (byteArray == null) {
			// return "" instead?
			throw new IllegalArgumentException("Argument 'byteArray' cannot be null");
		}
		int readBytes = byteArray.length;
		StringBuilder hexData = new StringBuilder();
		int onebyte;
		for (int i = 0; i < readBytes; i++) {
			onebyte = (0x000000ff & byteArray[i]) | 0xffffff00;
			hexData.append(Integer.toHexString(onebyte).substring(6));
		}
		return hexData.toString().toUpperCase();
	}

	public static int getRequestMsgType(int msgType) {
		return msgType & 0xffef;
	}

	public static byte[] hexToByteArray(final String hex) {
		String value = hex;
		int length = value.length();
		if (length % 2 != 0) {
			length++;
			value = padLeft(value, length, '0');
		}

		int numberChars = value.length();
		byte[] bytes = new byte[numberChars / 2];

		for (int i = 0; i < numberChars; i += 2) {
			bytes[i / 2] = (byte) Integer.valueOf(value.substring(i, i + 2), 16).intValue();
		}
		return bytes;
	}

	public static boolean isNullOrEmpty(String data) {
		if (data == null)
			return true;
		if (data.length() == 0)
			return true;

		return false;
	}

	public static boolean isNullOrWhitespace(String data) {
		if (isNullOrEmpty(data))
			return true;
		if (data.trim().length() == 0)
			return true;
		return false;
	}

	public static String maskPan(String pan) {
		if (pan == null)
			return null;

		final int frontLength = 6;
		final int endLength = 4;
		final int unmaskedLength = frontLength + endLength;

		int totalLength = pan.length();

		if (totalLength <= unmaskedLength)
			return pan;

		StringBuilder sb = new StringBuilder(totalLength);
		sb.append(pan.substring(0, frontLength));
		sb.append(Utils.padLeft("", totalLength - unmaskedLength, '*'));
		sb.append(pan.substring((totalLength - endLength), totalLength));
		return sb.toString();
	}

	public static int msgTypeToInt(String msgType) {
		return Integer.parseInt(msgType, 16);
	}

	public static String msgTypeToString(int msgType) {
		return padLeft(Integer.toHexString(msgType), 4, '0');
	}

	public static String padLeft(String data, int length, char padChar) {

		int remaining = length - data.length();

		String newData = data;
		for (int i = 0; i < remaining; i++)
			newData = padChar + newData;
		return newData;
	}

	public static String padRight(String data, int length, char padChar) {

		int remaining = length - data.length();

		String newData = data;

		for (int i = 0; i < remaining; i++)
			newData = newData + padChar;

		return newData;
	}
}
