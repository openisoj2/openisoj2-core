package org.bitbucket.openisoj2.core;

import org.bitbucket.openisoj2.core.fieldvalidator.IFieldValidator;

public class Field implements IField {

    public static IField getAsciiVar(int fieldNr, int lengthIdnicator, int maxLength, IFieldValidator validator)
            throws Exception {
        return new Field(fieldNr, FieldDescriptor.getAsciiVar(lengthIdnicator, maxLength, validator));
    }

    public static IField getBinFixed(int fieldNr, int packedLength) throws Exception {
        return new Field(fieldNr, FieldDescriptor.getBinaryFixed(packedLength));
    }

    protected IFieldDescriptor _fieldDescriptor;
    private int _fieldNr;
    private String _value;

    public Field(int fieldNumber, IFieldDescriptor fieldDescriptor) {
        _fieldNr = fieldNumber;
        _fieldDescriptor = fieldDescriptor;
    }

    public int getFieldNr() {
        return _fieldNr;
    }

    public int getPackedLength() throws Exception {
        return _fieldDescriptor.getPackedLenghth(_value);
    }

    public String getValue() {
        return _fieldDescriptor.getAdjuster() == null ? _value : _fieldDescriptor.getAdjuster().get(_value);
    }

    public void setValue(String value) {
        _value = _fieldDescriptor.getAdjuster() == null ? value : _fieldDescriptor.getAdjuster().set(value);

    }

    public byte[] toMsg() throws Exception {
        return _fieldDescriptor.pack(_fieldNr, _value);
    }

    @Override
    public String toString() {
        try {
            return toString("");
        } catch (Exception e) {
            return "ERROR IN DISPLAY!";
        }
    }

    public String toString(String prefix) throws Exception {
        return _fieldDescriptor.display(prefix, _fieldNr, _value);
    }

    public int unpack(byte[] msg, int offset) {
        UnpackObject obj = _fieldDescriptor.unpack(_fieldNr, msg, offset);
        _value = obj.data;
        return obj.offset;
    }

}
