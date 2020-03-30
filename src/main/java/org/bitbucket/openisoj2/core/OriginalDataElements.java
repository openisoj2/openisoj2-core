package org.bitbucket.openisoj2.core;

public class OriginalDataElements {
	private String msgType;
	private String stan;
	private String datetime;
	private String acqInst;

	public OriginalDataElements(String ode) {
		unpack(ode);
	}

	public String getAcqInst() {
		return acqInst;
	}

	public String getDatetime() {
		return datetime;
	}

	public String getMsgType() {
		return msgType;
	}

	public String getStan() {
		return stan;
	}

	public void setAcqInst(String acqInst) {
		this.acqInst = acqInst;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	private void unpack(String ode) {
		this.msgType = ode.substring(0, 4);
		this.stan = ode.substring(4, 10);
		this.datetime = ode.substring(10, 20);
		this.acqInst = ode.substring(20, 31);
	}
}
