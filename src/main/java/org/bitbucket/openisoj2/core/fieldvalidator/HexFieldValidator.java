package org.bitbucket.openisoj2.core.fieldvalidator;

public class HexFieldValidator implements IFieldValidator {

	public String getDescription() {
		return "hex";
	}

	public boolean isValid(String value) {
		byte[] valueBytes = value.getBytes();
		for (byte b : valueBytes)
			if (b < 48 || b > 57 && b < 65 || b > 70 && b < 97 || b > 102)
				return false;
		return true;
	}

}
