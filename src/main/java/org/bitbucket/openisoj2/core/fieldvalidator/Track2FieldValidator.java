package org.bitbucket.openisoj2.core.fieldvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Track2FieldValidator implements IFieldValidator {

	private static final Pattern _pattern = Pattern.compile("^\\d{10,19}[=D]([=D]|\\d{4})?([=D]|\\d{3})?\\d*$");

	public String getDescription() {
		return "z";
	}

	public boolean isValid(String value) {
		Matcher matcher = _pattern.matcher(value);
		return matcher.find();
	}

}
