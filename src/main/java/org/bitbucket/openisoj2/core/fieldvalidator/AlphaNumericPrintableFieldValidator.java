package org.bitbucket.openisoj2.core.fieldvalidator;

public class AlphaNumericPrintableFieldValidator implements IFieldValidator {

	public String getDescription() {
		return "anp";
	}

	public boolean isValid(String value) {
		byte[] valueBytes = value.getBytes();
		for (byte b : valueBytes)
			if (b < 32)
				return false;
		return true;
	}

}
