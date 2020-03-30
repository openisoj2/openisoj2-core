package org.bitbucket.openisoj2.core.fieldvalidator;

public class Rev87AmountFieldValidator implements IFieldValidator {

	public String getDescription() {
		return "amt";
	}

	public boolean isValid(String value) {
		String sign = value.substring(0, 1);
		if ("C".equals(sign) != true && "D".equals(sign) != true)
			return false;

		NumericFieldValidator validator = new NumericFieldValidator();
		return validator.isValid(value.substring(1));
	}

}
