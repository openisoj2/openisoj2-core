package org.bitbucket.openisoj2.core.fieldvalidator;

public class NoneFieldValidator implements IFieldValidator {

	public String getDescription() {
		return "none";
	}

	public boolean isValid(String value) {
		return true;
	}

}
