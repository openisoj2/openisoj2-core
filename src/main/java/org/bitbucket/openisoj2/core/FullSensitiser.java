package org.bitbucket.openisoj2.core;

/**
 * Sensitise everything
 * 
 * @author John Oxley &lt;john.oxley@gmail.com&gt;
 */
public class FullSensitiser implements Sensitiser {
	private static FullSensitiser instance = new FullSensitiser();

	public static FullSensitiser getInstance() {
		return instance;
	}

	private FullSensitiser() {
	}

	public String sensitise(String data) {
		if (data == null)
			return null;
		return Utils.padLeft("", data.length(), '*');
	}
}
