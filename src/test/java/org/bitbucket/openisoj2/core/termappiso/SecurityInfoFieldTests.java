package org.bitbucket.openisoj2.core.termappiso;

import org.bitbucket.openisoj2.core.FieldDescriptor;
import org.bitbucket.openisoj2.core.IFieldDescriptor;
import org.bitbucket.openisoj2.core.Iso8583TermApp;
import org.bitbucket.openisoj2.core.Utils;
import org.bitbucket.openisoj2.core.fieldvalidator.FieldValidators;
import org.bitbucket.openisoj2.core.formatter.BinaryFormatter;
import org.bitbucket.openisoj2.core.lengthformatters.VariableLengthFormatter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Basically field 53 from Iso8583TermApp
 *
 * @author John
 */
public class SecurityInfoFieldTests {
    @Test
    public void testFieldDescriptor() throws Exception {
        IFieldDescriptor fd = new FieldDescriptor(new VariableLengthFormatter(2, 96), FieldValidators.getHex(), new BinaryFormatter(),
                null, null);
        String expected = "3038FFFFDDDDEEEECCCC";
        byte[] packed = fd.pack(53, "FFFFDDDDEEEECCCC");
        String packedString = Utils.byteArrayToHexString(packed);
        assertEquals(expected, packedString);
    }

    @Test
    public void testMessagePack() throws Exception {
        String expected = "423132303000000000020008003636363038FFFFDDDDEEEECCCC";
        Iso8583TermApp msg = new Iso8583TermApp();
        msg.setMsgType(Iso8583TermApp.MsgType._1200_TRAN_REQ);
        msg.set(Iso8583TermApp.Bit._039_ACTION_CODE, "666");
        msg.set(Iso8583TermApp.Bit._053_SECURITY_INFO, "FFFFDDDDEEEECCCC");
        byte[] bytes = msg.toMsg();
        String actual = Utils.byteArrayToHexString(bytes);
        assertEquals(expected, actual);
    }

    @Test
    public void testMessagePackWithPin() throws Exception {
        String expected = "423132303000000000020018003636366327CE1BB15D7B9530380039997139E00006";
        Iso8583TermApp msg = new Iso8583TermApp();
        msg.setMsgType(Iso8583TermApp.MsgType._1200_TRAN_REQ);
        msg.set(Iso8583TermApp.Bit._039_ACTION_CODE, "666");
        msg.set(Iso8583TermApp.Bit._052_PIN_DATA, "6327CE1BB15D7B95");
        msg.set(Iso8583TermApp.Bit._053_SECURITY_INFO, "0039997139E00006");
        byte[] bytes = msg.toMsg();
        String actual = Utils.byteArrayToHexString(bytes);
        assertEquals(expected, actual);
    }
}
