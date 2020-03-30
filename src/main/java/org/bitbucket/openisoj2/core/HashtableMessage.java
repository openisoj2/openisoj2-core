package org.bitbucket.openisoj2.core;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class HashtableMessage extends LinkedHashMap<String, String> {
	private static final long serialVersionUID = -6291908065706959931L;

	/**
	 * Parses the string into the hashtable
	 * 
	 * @param message
	 */
	public void fromMessageString(String message) {
		int offset = 0;

		if (message == null)
			return;

		while (offset < message.length()) {
			int keyLengthIndicator = Integer.parseInt(message.substring(offset, offset + 1));
			offset++;
			int keyLength = Integer.parseInt(message.substring(offset, offset + keyLengthIndicator));
			offset += keyLengthIndicator;
			String key = message.substring(offset, offset + keyLength);
			offset += keyLength;

			int valueLengthIndicator = Integer.parseInt(message.substring(offset, offset + 1));
			offset++;
			int valueLength = Integer.parseInt(message.substring(offset, offset + valueLengthIndicator));
			offset += valueLengthIndicator;
			String value = message.substring(offset, offset + valueLength);
			offset += valueLength;

			put(key, value);
		}
	}

	public String toMessageString() {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, String> entry : this.entrySet()) {
			String value = entry.getValue();
			int keyLength = entry.getKey().length();
			int keyLengthIndicator = ("" + keyLength).length();
			sb.append(keyLengthIndicator);
			sb.append(keyLength);
			sb.append(entry.getKey());

			int valueLength = value.length();
			int valueLengthIndicator = ("" + valueLength).length();
			sb.append(valueLengthIndicator);
			sb.append(valueLength);
			sb.append(value);

		}
		return sb.toString();
	}
}
