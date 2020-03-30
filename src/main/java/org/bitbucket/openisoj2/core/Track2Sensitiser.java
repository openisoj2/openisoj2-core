package org.bitbucket.openisoj2.core;

public class Track2Sensitiser implements Sensitiser {
	private static final Sensitiser instance = new Track2Sensitiser();

	public static Sensitiser getInstance() {
		return instance;
	}

	private Track2Sensitiser() {
	}

	public String sensitise(String data) {
		if (data == null)
			return null;

		Sensitiser panSenistiser = PanSensitiser.getInstance();
		StringBuilder sb = new StringBuilder();

		String delim = "=";
		if (data.contains("D"))
			delim = "D";

		Track2 track = new Track2(data);
		String pan = track.getPan();
		String expiry = track.getExpiry();
		String src = track.getServiceRestrictionCode();
		String dD = track.getDiscretionaryData();

		if (expiry == null && src == null && dD == null) {
			sb.append(panSenistiser.sensitise(pan));
			int remaining = data.length() - pan.length();
			sb.append(data.substring(data.length() - remaining));
		} else {
			sb.append(panSenistiser.sensitise(pan)).append(delim);
			sb.append(Utils.isNullOrEmpty(expiry) ? delim : expiry);
			sb.append(Utils.isNullOrEmpty(src) ? delim : src);
			if (Utils.isNullOrEmpty(dD) != true) {
				int length = dD.length();
				sb.append(Utils.padRight("", length, '*'));
			}
		}

		// When some retarded banks don't have a SRC or delimiter, the above method will insert
		// a delimiter. This is some horrible code that will stop the delimiter appearing in the
		// sensitised data.
		return sb.toString().substring(0, data.length());

	}
}
