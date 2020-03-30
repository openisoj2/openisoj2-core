package org.bitbucket.openisoj2.core.fieldvalidator;

public class AlphaNumericFieldValidator implements IFieldValidator {

	public String getDescription() {
		return "an";
	}

	public boolean isValid(String value) {
		byte[] valueBytes = value.getBytes();
		for (byte b : valueBytes)
			if (b < 48 || b > 57 && b < 65 || b > 90 && b < 97 || b > 122)
				return false;
		return true;
	}

}
