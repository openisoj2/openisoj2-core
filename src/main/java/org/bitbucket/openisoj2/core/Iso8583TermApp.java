package org.bitbucket.openisoj2.core;

import org.bitbucket.openisoj2.core.exceptions.UnknownFieldException;
import org.bitbucket.openisoj2.core.fieldvalidator.FieldValidators;
import org.bitbucket.openisoj2.core.formatter.BinaryFormatter;
import org.bitbucket.openisoj2.core.formatter.Formatters;
import org.bitbucket.openisoj2.core.lengthformatters.VariableLengthFormatter;
import org.bitbucket.openisoj2.core.termappiso.AdditionalData;

public class Iso8583TermApp extends Iso8583Rev93 implements IMessage {
    private static Template template;

    static {
        template = getDefaultTemplate();
        template.remove(Bit._052_PIN_DATA);
        template.remove(Bit._053_SECURITY_INFO);
        template.remove(Bit._055_ICC_DATA);
        template.remove(Bit._064_MAC);
        template.remove(Bit._128_MAC);
        try {
            template.put(Bit._025_MSG_REASON_CODE, FieldDescriptor.getAsciiFixed(4, FieldValidators.getN()));
            template.put(Bit._052_PIN_DATA, FieldDescriptor.getBinaryFixed(8));
            template.put(Bit._053_SECURITY_INFO, new FieldDescriptor(new VariableLengthFormatter(2, 96),
                    FieldValidators.getHex(), new BinaryFormatter(), null, null));
            template.put(Bit._055_ICC_DATA, FieldDescriptor.getBinaryVar(3, 999, Formatters.getAscii()));
            template.put(Bit._064_MAC, FieldDescriptor.getAsciiFixed(16, FieldValidators.getNone()));
            template.put(Bit._128_MAC, FieldDescriptor.getAsciiFixed(16, FieldValidators.getNone()));
            // template.put(Bit._053_SECURITY_INFO, FieldDescriptor.getBinaryVar(2, 96, Formatters.getAscii()));
            // template.put(Bit._055_ICC_DATA, FieldDescriptor.getAsciiVar(3, 999, FieldValidators.getNone()));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private boolean ascii;
    private boolean unpacking = false;

    public Iso8583TermApp() {
        this(false);
    }

    public Iso8583TermApp(boolean ascii) {
        super(template);
        this.ascii = ascii;

        if (ascii)
            template.setBitmapFormatter(Formatters.getAscii());
        else
            template.setBitmapFormatter(Formatters.getBinary());

        bitmap.setFormatter(template.getBitmapFormatter());
    }

    public Iso8583TermApp(byte[] data) throws Exception {
        this(data[0] == 'A');
        unpack(data, 0);
    }

    @Override
    protected IField createField(int field) throws UnknownFieldException {
        if (field == Iso8583TermApp.Bit._048_PRIVATE_ADDITIONAL_DATA)
            return new AdditionalData();

        // I'm certain that TermApp.ISO in Postilion is broken when it comes to MACcing.  Using the 'B' format
        // when sending a message it has to be ASCII fixed 16, otherwise Postilion doesn't pick up the full MAC
        // However when Postilion replies, it packs the MAC in binary fixed 8
        if (unpacking && (field == Bit._064_MAC || field == Bit._128_MAC)) {
            return new Field(field, FieldDescriptor.getBinaryFixed(8));
        }

        return super.createField(field);
    }

    public AdditionalData getAdditionalData() throws Exception {
        if (isFieldSet(Bit._048_PRIVATE_ADDITIONAL_DATA)) {
            return (AdditionalData) getField(Bit._048_PRIVATE_ADDITIONAL_DATA);
        }
        return null;
    }

    /**
     * Get the structured data out of field 48.16
     *
     * @return Structured Data
     */
    public HashtableMessage getStructuredData() throws Exception {
        if (!isFieldSet(Bit._048_PRIVATE_ADDITIONAL_DATA))
            return null;
        AdditionalData addData = getAdditionalData();
        if (!addData.containsKey(AdditionalData.Field.StructuredData))
            return null;

        HashtableMessage sd = new HashtableMessage();
        sd.fromMessageString(addData.get(AdditionalData.Field.StructuredData));

        return sd;
    }

    public void putAdditionalData(AdditionalData addData) throws Exception {
        if (addData == null) {
            this.clearField(48);
        }
        bitmap.setField(Iso8583TermApp.Bit._048_PRIVATE_ADDITIONAL_DATA, addData != null);
        fields.put(48, addData);
    }

    /**
     * Put the structured data message into field 48.16
     *
     * @param data Structured Data
     */
    public void putStructuredData(HashtableMessage data) throws Exception {
        String sd = data.toMessageString();

        AdditionalData addData = getAdditionalData();
        if (addData == null)
            addData = new AdditionalData();

        addData.put(AdditionalData.Field.StructuredData, sd);
        putAdditionalData(addData);
    }

    @Override
    public byte[] toMsg() throws Exception {
        byte[] superMsg = super.toMsg();
        byte[] msg = new byte[superMsg.length + 1];

        if (ascii) {
            msg[0] = 'A';
        } else {
            msg[0] = 'B';
        }

        System.arraycopy(superMsg, 0, msg, 1, superMsg.length);

        return msg;
    }

    @Override
    public int unpack(byte[] msg, int startingOffset) throws Exception {
        ascii = msg[0] == 'A';
        if (msg[0] == 'A' || msg[0] == 'B')
            startingOffset++;
        if (ascii)
            template.setBitmapFormatter(Formatters.getAscii());
        else
            template.setBitmapFormatter(Formatters.getBinary());

        bitmap = new Bitmap(template.getBitmapFormatter());

        try {
            // Look at createField for why I'm doing this
            unpacking = true;
            return super.unpack(msg, startingOffset);
        } finally {
            unpacking = false;
        }
    }

    public class ActionCode extends Iso8583Rev93.ActionCode {
    }

    public class Bit extends Iso8583Rev93.Bit {
    }

    public class FuncCode extends Iso8583Rev93.FuncCode {
        public static final String _500_RECON = "500";
    }

    public class MsgType extends Iso8583Rev93.MsgType {
    }
}
