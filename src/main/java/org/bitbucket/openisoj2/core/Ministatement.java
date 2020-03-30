package org.bitbucket.openisoj2.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Parse and pack a ministatement data field
 * 
 * @author John Oxley &lt;john.oxley@gmail.com&gt;
 */
public class Ministatement extends LinkedHashMap<String, String> {
	private static final long serialVersionUID = 3969336608201219681L;

	public static class Tag {
		public static final String SEQ_NR = "SEQ_NR";
		public static final String DATE_TIME = "DATE_TIME";
		public static final String TERM_ID = "TERM_ID";
		public static final String TRAN_TYPE = "TRAN_TYPE";
		public static final String FROM_ACC = "FROM_ACC";
		public static final String TO_ACC = "TO_ACC";
		public static final String TRAN_AMOUNT = "TRAN_AMOUNT";
		public static final String ACC_ID1 = "ACC_ID1";
		public static final String ACC_ID2 = "ACC_ID2";
		public static final String AUTH_ID = "AUTH_ID";
		public static final String CURR_CODE = "CURR_CODE";
		public static final String SURCHARGE = "SURCHARGE";

		private Tag() {
		}
	}

	private List<String> tags;
	private List<Hashtable<String, String>> lines;

	public void parse(String str) {
		lines = new ArrayList<Hashtable<String, String>>();

		String[] recs = str.split("~");
		String header = recs[0];
		tags = Arrays.asList(header.split("\\|"));

		for (int i = 1; i < recs.length; i++) {
			Hashtable<String, String> line = new Hashtable<String, String>();
			String[] parts = recs[i].split("\\|");
			for (int h = 0; h < tags.size(); h++) {
				String key = tags.get(h);
				String value = parts[h];
				line.put(key, value);
			}
			lines.add(line);
		}
	}

	public List<String> getTags() {
		return tags;
	}

	public List<Hashtable<String, String>> getLines() {
		return lines;
	}
}
