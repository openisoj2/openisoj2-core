package org.bitbucket.openisoj2.core;

import org.bitbucket.openisoj2.core.exceptions.UnknownFieldException;

import java.util.HashMap;
import java.util.Map;

public abstract class AMessage implements Cloneable {
    protected Bitmap bitmap;
    protected HashMap<Integer, IField> fields;
    protected Template template;

    public AMessage(Template template) {
        this.template = template;
        fields = new HashMap<Integer, IField>();
        bitmap = new Bitmap(template.getBitmapFormatter());
    }

    public void clearField(int field) {
        bitmap.setField(field, false);
        fields.remove(field);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        AMessage msg;
        try {
            msg = this.getClass().newInstance();

            for (int i = 2; i < 128; i++) {
                msg.set(i, this.get(i));
            }

        } catch (InstantiationException e) {
            throw new CloneNotSupportedException();
        } catch (IllegalAccessException e) {
            throw new CloneNotSupportedException();
        } catch (UnknownFieldException e) {
            throw new CloneNotSupportedException();
        }
        return msg;
    }

    protected abstract IField createField(int field) throws UnknownFieldException;

    protected String describePacking() throws Exception {
        return template.describePacking();
    }

    public String get(int field) {
        return getFieldValue(field);
    }

    private int getBasePackedLength() throws Exception {
        int length = bitmap.getPackedLength();
        for (int i = 2; i <= 128; i++) {
            if (bitmap.isFieldSet(i)) {
                IField field = fields.get(i);
                length += field.getPackedLength();
            }
        }

        return length;
    }

    protected IField getField(int field) throws UnknownFieldException {
        if (!bitmap.isFieldSet(field) || !fields.containsKey(field)) {
            fields.put(field, createField(field));
            bitmap.setField(field, true);
        }

        return fields.get(field);
    }

    public String getFieldValue(int field) {
        return bitmap.isFieldSet(field) ? fields.get(field).getValue() : null;
    }

    public int getPackedLength() throws Exception {
        return getBasePackedLength();
    }

    public ProcessingCode getProcessingCode() throws Exception {
        return new ProcessingCode(fields.get(3).getValue());
    }

    public boolean isFieldSet(int field) {
        return bitmap.isFieldSet(field);
    }

    public boolean isExtended() {
        for (Map.Entry<Integer, IField> fieldEntry : fields.entrySet()) {
            if (fieldEntry.getKey() > 64) {
                return true;
            }
        }
        return false;
    }

    public void putProcessingCode(ProcessingCode procCode) throws UnknownFieldException {
        set(Iso8583.Bit._003_PROC_CODE, procCode.toString());
    }

    public void set(int field, String value) throws UnknownFieldException {
        setFieldValue(field, value);
    }

    protected void setFieldValue(int field, String value) throws UnknownFieldException {
        if (value == null) {
            clearField(field);
            return;
        }

        getField(field).setValue(value);
    }

    protected byte[] toMsg() throws Exception {
        int packedLen = getBasePackedLength();
        byte[] data = new byte[packedLen];

        int offset = 0;

        byte[] bmap = bitmap.toMsg();
        System.arraycopy(bmap, 0, data, offset, bitmap.getPackedLength());
        offset += bitmap.getPackedLength();

        for (int i = 2; i <= 128; i++) {
            offset += toMsg(data, offset, i);
        }

        return data;
    }

    protected int toMsg(byte[] data, int offset, int fld) throws Exception {
        if (bitmap.isFieldSet(fld)) {
            IField field = fields.get(fld);
            System.arraycopy(field.toMsg(), 0, data, offset, field.getPackedLength());
            return field.getPackedLength();
        }
        return 0;
    }

    @Override
    public String toString() {
        try {
            return toString("");
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR GENERATING STRING";
        }
    }

    protected String toString(int field, String prefix) throws Exception {
        return fields.get(field).toString(prefix + "   ");
    }

    protected String toString(String prefix) throws Exception {
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= 128; i++) {
            if (bitmap.isFieldSet(i)) {
                sb.append(System.getProperty("line.separator")).append(toString(i, prefix));
            }
        }

        return sb.toString().substring(System.getProperty("line.separator").length());
    }

    protected int unpack(byte[] msg, int startingOffset) throws Exception {
        int offset = startingOffset;

        offset = bitmap.unpack(msg, offset);

        for (int i = 2; i <= 128; i++) {
            if (bitmap.isFieldSet(i)) {
                IField field = getField(i);
                offset = field.unpack(msg, offset);
            }
        }

        return offset;
    }

    public final class AccountType {
        public static final String _00_DEFAULT = "00";
        public static final String _10_SAVINGS = "10";
        public static final String _20_CHECK = "20";
        public static final String _30_CREDIT = "30";
        public static final String _40_UNIVERSAL = "40";
        public static final String _50_INVESTMENT = "50";
        public static final String _60_ELECTRONIC_PURSE_DEFAULT = "60";

        private AccountType() {
        }
    }

    public final class AmountType {
        public static final String _01_LEDGER_BALANCE = "01";
        public static final String _02_AVAILABLE_BALANCE = "02";
        public static final String _03_OWING = "03";
        public static final String _04_DUE = "04";
        public static final String _20_REMAINING_THIS_CYCLE = "20";
        public static final String _40_CASH = "40";
        public static final String _41_GOODS_SERVICES = "41";
        public static final String _53_APPROVED = "53";
        public static final String _56_TIP = "56";
        public static final String _90_AVAILABLE_CREDIT = "90";
        public static final String _91_CREDIT_LIMIT = "91";

        private AmountType() {
        }
    }
}
