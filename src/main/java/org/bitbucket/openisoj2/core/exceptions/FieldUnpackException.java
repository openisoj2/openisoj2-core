package org.bitbucket.openisoj2.core.exceptions;

public class FieldUnpackException extends RuntimeException {
    private static final long serialVersionUID = 5501621930297316445L;
    private final String fieldNumber;
    private final byte[] data;

    private final int offset;

    public FieldUnpackException(String fieldNumber, byte[] data, int offset, Throwable cause) {
        super("Unable to unpack field " + fieldNumber + " at offset " + offset, cause);
        this.fieldNumber = fieldNumber;
        this.data = data;
        this.offset = offset;
    }

    public byte[] getData() {
        return data;
    }

    public String getFieldNumber() {
        return fieldNumber;
    }

    public int getOffset() {
        return offset;
    }
}
