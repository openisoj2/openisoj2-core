package org.bitbucket.openisoj2.core;

public class ProcessingCode {
	private String tranType;
	private String fromAccountType;
	private String toAccountType;

	public ProcessingCode() {
	}

	public ProcessingCode(String data) throws Exception {
		if (data.length() != 6)
			throw new Exception("Incorrect legth for Processing Code!");

		setTranType(data.substring(0, 2));
		setFromAccountType(data.substring(2, 4));
		setToAccountType(data.substring(4, 6));
	}

	public String getFromAccountType() {
		return fromAccountType;
	}

	public String getToAccountType() {
		return toAccountType;
	}

	public String getTranType() {
		return tranType;
	}

	public void setFromAccountType(String fromAccountType) {
		this.fromAccountType = fromAccountType;
	}

	public void setToAccountType(String toAccountType) {
		this.toAccountType = toAccountType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	@Override
	public String toString() {
		return tranType + fromAccountType + toAccountType;
	}
}
