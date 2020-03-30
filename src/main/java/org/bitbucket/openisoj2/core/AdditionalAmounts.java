package org.bitbucket.openisoj2.core;

import java.util.ArrayList;

public class AdditionalAmounts extends ArrayList<AdditionalAmount> {
	private static final long serialVersionUID = -5065402045370980446L;

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (AdditionalAmount amount : this) {
			sb.append(amount);
		}

		return sb.toString();
	}
}
