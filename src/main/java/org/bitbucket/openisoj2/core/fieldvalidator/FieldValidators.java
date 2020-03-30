package org.bitbucket.openisoj2.core.fieldvalidator;

public class FieldValidators {
	public static IFieldValidator getA() {
		return getAlpha();
	}

	public static IFieldValidator getAlpha() {
		return new AlphaFieldValidator();
	}

	public static IFieldValidator getAlphaNumeric() {
		return new AlphaNumericFieldValidator();
	}

	public static IFieldValidator getAlphaNumericAndSpace() {
		return new AlphaNumericAndSpaceFieldValidator();
	}

	public static IFieldValidator getAlphaNumericPrintable() {
		return new AlphaNumericPrintableFieldValidator();
	}

	public static IFieldValidator getAlphaNumericSpecial() {
		return new AlphaNumericSpecialFieldValidator();
	}

	public static IFieldValidator getAn() {
		return getAlphaNumeric();
	}

	public static IFieldValidator getAnp() {
		return getAlphaNumericPrintable();
	}

	public static IFieldValidator getAns() {
		return getAlphaNumericSpecial();
	}

	public static IFieldValidator getAnsp() {
		return getAlphaNumericAndSpace();
	}

	public static IFieldValidator getHex() {
		return new HexFieldValidator();
	}

	public static IFieldValidator getN() {
		return getNumeric();
	}

	public static IFieldValidator getNone() {
		return new NoneFieldValidator();
	}

	public static IFieldValidator getNumeric() {
		return new NumericFieldValidator();
	}

	public static IFieldValidator getRev87Amount() {
		return new Rev87AmountFieldValidator();
	}

	public static IFieldValidator getTrack2() {
		return new Track2FieldValidator();
	}
}
