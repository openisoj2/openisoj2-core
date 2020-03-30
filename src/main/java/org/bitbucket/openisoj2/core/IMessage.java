package org.bitbucket.openisoj2.core;

public interface IMessage {
	public byte[] toMsg() throws Exception;

	public int unpack(byte[] msg, int offset) throws Exception;
}
