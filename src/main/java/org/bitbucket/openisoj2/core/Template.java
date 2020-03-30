package org.bitbucket.openisoj2.core;

import java.util.HashMap;

import org.bitbucket.openisoj2.core.formatter.Formatters;
import org.bitbucket.openisoj2.core.formatter.IFormatter;

public class Template extends HashMap<Integer, IFieldDescriptor> implements Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IFormatter _msgTypeFormatter;
	private IFormatter _bitmapFormatter;

	public Template() {
		_msgTypeFormatter = Formatters.getAscii();
		_bitmapFormatter = Formatters.getBinary();
	}

	@Override
	public Object clone() {
		return super.clone();
	}

	public String describePacking() throws Exception {
		StringBuilder sb = new StringBuilder();

		for (java.util.Map.Entry<Integer, IFieldDescriptor> entry : entrySet()) {
			int field = entry.getKey();
			IFieldDescriptor descriptor = entry.getValue();
			sb.append(descriptor.display("", field, null));
		}

		return sb.toString();
	}

	public IFormatter getBitmapFormatter() {
		return _bitmapFormatter;
	}

	public IFormatter getMsgTypeFormatter() {
		return _msgTypeFormatter;
	}

	public void setBitmapFormatter(IFormatter _bitmapFormatter) {
		this._bitmapFormatter = _bitmapFormatter;
	}

	public void setMsgTypeFormatter(IFormatter _msgTypeFormatter) {
		this._msgTypeFormatter = _msgTypeFormatter;
	}
}
