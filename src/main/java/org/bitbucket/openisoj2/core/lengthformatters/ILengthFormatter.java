package org.bitbucket.openisoj2.core.lengthformatters;

public interface ILengthFormatter {
	public String getDescription();

	public int getLengthOfField(byte[] msg, int offset) throws Exception;

	public int getLengthOfLengthIndicator();

	public String getMaxLength();

	public boolean isValidLength(int packedLength);

	public int pack(byte[] msg, int length, int offset) throws Exception;
}
