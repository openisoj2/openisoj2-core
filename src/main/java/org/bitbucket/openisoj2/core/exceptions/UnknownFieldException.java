package org.bitbucket.openisoj2.core.exceptions;

public class UnknownFieldException extends Exception {
	private String _fieldNumber;

	public UnknownFieldException(String fieldNumber) {
		super("Field " + fieldNumber + " is unknown");
		_fieldNumber = fieldNumber;
	}

	public String getFieldNumber() {
		return _fieldNumber;
	}

	public void setFieldNumber(String fieldNumber) {
		_fieldNumber = fieldNumber;
	}

}
