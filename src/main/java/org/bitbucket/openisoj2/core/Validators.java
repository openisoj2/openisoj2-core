package org.bitbucket.openisoj2.core;

import org.bitbucket.openisoj2.core.fieldvalidator.HexFieldValidator;
import org.bitbucket.openisoj2.core.fieldvalidator.NumericFieldValidator;

public class Validators {
	public static boolean isHex(String value) {
		HexFieldValidator validator = new HexFieldValidator();
		return validator.isValid(value);
	}

	public static boolean isNumeric(String value) {
		NumericFieldValidator validator = new NumericFieldValidator();
		return validator.isValid(value);
	}
}
