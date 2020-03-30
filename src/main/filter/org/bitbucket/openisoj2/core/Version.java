package org.bitbucket.openisoj2.core;

public final class Version {
	public static final String VERSION = "${project.version}";

	private Version() {
	}

	/**
	 * Main
	 * 
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		System.out.println(VERSION);
	}
}
