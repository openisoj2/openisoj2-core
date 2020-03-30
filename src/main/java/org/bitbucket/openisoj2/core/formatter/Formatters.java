package org.bitbucket.openisoj2.core.formatter;

public class Formatters {
	public static IFormatter getAscii() {
		return new AsciiFormatter();
	}

	public static IFormatter getBcd() {
		return new BcdFormatter();
	}

	public static IFormatter getBinary() {
		return new BinaryFormatter();
	}
}
