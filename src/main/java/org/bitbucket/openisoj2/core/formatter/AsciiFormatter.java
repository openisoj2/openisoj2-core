package org.bitbucket.openisoj2.core.formatter;

public class AsciiFormatter implements IFormatter {

	public byte[] getBytes(String value) throws Exception {
		return value.getBytes();
	}

	public int getPackedLength(int unpackedLength) throws Exception {
		return unpackedLength;
	}

	public String getString(byte[] data) throws Exception {
		return new String(data);
	}

}
