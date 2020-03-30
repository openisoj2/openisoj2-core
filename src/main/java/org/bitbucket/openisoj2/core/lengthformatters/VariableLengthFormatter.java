package org.bitbucket.openisoj2.core.lengthformatters;

import org.bitbucket.openisoj2.core.Utils;
import org.bitbucket.openisoj2.core.formatter.AsciiFormatter;
import org.bitbucket.openisoj2.core.formatter.IFormatter;

public class VariableLengthFormatter implements ILengthFormatter {

	private int _lengthIndicator;
	private int _maxLength;
	private IFormatter _lengthFormatter;

	private int _lengthOfLength;

	public VariableLengthFormatter(int lengthIndicator, int maxLength) throws Exception {
		this(lengthIndicator, maxLength, new AsciiFormatter());
	}

	public VariableLengthFormatter(int lengthIndicator, int maxLength, IFormatter lengthFormatter) throws Exception {
		_lengthIndicator = lengthIndicator;
		_maxLength = maxLength;
		_lengthFormatter = lengthFormatter;
		_lengthOfLength = _lengthFormatter.getPackedLength(_lengthIndicator);

	}

	public String getDescription() {
		int places = (int) Math.log10(_maxLength);
		return "L" + (1 + places) + "Var";
	}

	public int getLengthOfField(byte[] msg, int offset) throws Exception {
		int len = _lengthOfLength;
		byte[] lenData = new byte[len];
		System.arraycopy(msg, offset, lenData, 0, len);
		String lenStr = _lengthFormatter.getString(lenData);
		return Integer.parseInt(lenStr);
	}

	public int getLengthOfLengthIndicator() {
		return _lengthOfLength;
	}

	public String getMaxLength() {
		return ".." + _maxLength;
	}

	public boolean isValidLength(int packedLength) {
		return packedLength <= _maxLength;
	}

	public int pack(byte[] msg, int length, int offset) throws Exception {
		String lengthStr = Utils.padLeft(Integer.toString(length), getLengthOfLengthIndicator(), '0');

		byte[] header = _lengthFormatter.getBytes(lengthStr);
		System.arraycopy(header, 0, msg, offset, getLengthOfLengthIndicator());
		return offset + getLengthOfLengthIndicator();

	}

}
