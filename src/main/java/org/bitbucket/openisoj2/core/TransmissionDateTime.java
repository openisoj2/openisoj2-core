package org.bitbucket.openisoj2.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.bitbucket.openisoj2.core.exceptions.UnknownFieldException;

public class TransmissionDateTime {
	private AMessage _message;

	public TransmissionDateTime(AMessage message) {
		_message = message;
	}

	public void setNow() throws UnknownFieldException {
		SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date now = new Date();
		_message.setFieldValue(Iso8583.Bit._007_TRAN_DATE_TIME, format.format(now));
	}
}
