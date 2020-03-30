package org.bitbucket.openisoj2.core;

public class PadLeftSetAdjuster extends Adjuster {

	private int _length;
	private char _padChar;

	public PadLeftSetAdjuster(int length, char padChar) {
		_length = length;
	}

	@Override
	protected String set(String value) {
		String val = value;
		if (value == null)
			val = "";

		return Utils.padLeft(val, _length, _padChar);
	}
}
