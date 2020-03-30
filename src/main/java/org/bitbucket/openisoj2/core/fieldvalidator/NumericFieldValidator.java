package org.bitbucket.openisoj2.core.fieldvalidator;

public class NumericFieldValidator implements IFieldValidator {

	public String getDescription() {
		return "n";
	}

	public boolean isValid(String value) {
		byte[] valueBytes = value.getBytes();
		for (byte b : valueBytes) {
			if (b < 48)
				return false;
			if (b > 57)
				return false;
		}
		return true;
	}

}
