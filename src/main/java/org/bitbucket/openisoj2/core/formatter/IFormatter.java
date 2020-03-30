package org.bitbucket.openisoj2.core.formatter;

public interface IFormatter {
	/**
	 * Format the String and return as an encoded byte array
	 * 
	 * @param value
	 *            value to format
	 * @return Encoded byte array
	 */
	public byte[] getBytes(String value) throws Exception;

	/**
	 * Gets the packed length of the data given the unpacked length
	 * 
	 * @param unpackedLength
	 *            Unpacked Length
	 * @return Packet length of the data
	 */
	int getPackedLength(int unpackedLength) throws Exception;

	/**
	 * Takes the byte array and converts it to a String for use
	 * 
	 * @param data
	 *            Data to convert
	 * @return Converted data
	 */
	public String getString(byte[] data) throws Exception;
}
