package org.bitbucket.openisoj2.core.fieldvalidator;

public class AlphaFieldValidator implements IFieldValidator {

	public String getDescription() {
		return "a";
	}

	public boolean isValid(String value) {
		byte[] valueBytes = value.getBytes();
		for (byte b : valueBytes)
			if (b < 65 || b > 90 && b < 97 || b > 122)
				return false;
		return true;
	}

}
