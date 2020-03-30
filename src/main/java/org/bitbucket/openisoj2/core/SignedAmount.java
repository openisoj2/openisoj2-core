package org.bitbucket.openisoj2.core;

public class SignedAmount {
	private long value;

	public SignedAmount(String packed) {
		boolean negative = packed.charAt(0) == 'D';
		value = Long.parseLong(packed.substring(1));
		if (negative)
			value = -value;
	}

	public SignedAmount(long value) {
		this.value = value;
	}

	public long getValue() {
		return value;
	}

	public String getSign() {
		return value < 0 ? "D" : "C";
	}

	public String getPacked(int length) {
		return getSign() + Utils.padLeft("" + Math.abs(value), length, '0');
	}
}
