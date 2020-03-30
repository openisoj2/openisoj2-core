package org.bitbucket.openisoj2.core.lengthformatters;

public class FixedLengthFormatter implements ILengthFormatter {

	private int _packedLength;

	public FixedLengthFormatter(int packedLength) {
		_packedLength = packedLength;
	}

	public String getDescription() {
		return "Fixed";
	}

	public int getLengthOfField(byte[] msg, int offset) {
		return _packedLength;
	}

	public int getLengthOfLengthIndicator() {
		return 0;
	}

	public String getMaxLength() {
		return Integer.toString(_packedLength);
	}

	public boolean isValidLength(int packedLength) {
		return packedLength == _packedLength;
	}

	public int pack(byte[] msg, int length, int offset) {
		return offset;
	}

}
