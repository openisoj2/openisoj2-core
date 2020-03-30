package org.bitbucket.openisoj2.core.exceptions;

public class FieldFormatException extends RuntimeException {
	private String fieldNr;
	private String fieldMessage;

	public FieldFormatException(String fieldNr, String message) {
		super("Field (" + fieldNr + "): " + message);
		this.fieldMessage = message;
		this.fieldNr = fieldNr;
	}

	public String getFieldNr() {
		return fieldNr;
	}

	public void setFieldNr(String fieldNr) {
		this.fieldNr = fieldNr;
	}

	public String getFieldMessage() {
		return fieldMessage;
	}
}
