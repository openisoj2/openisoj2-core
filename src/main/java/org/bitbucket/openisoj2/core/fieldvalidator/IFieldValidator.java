package org.bitbucket.openisoj2.core.fieldvalidator;

public interface IFieldValidator {
	public String getDescription();

	public boolean isValid(String value);
}
