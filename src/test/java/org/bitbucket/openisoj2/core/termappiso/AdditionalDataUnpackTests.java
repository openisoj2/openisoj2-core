package org.bitbucket.openisoj2.core.termappiso;

import org.bitbucket.openisoj2.core.Iso8583TermApp;
import org.bitbucket.openisoj2.core.formatter.Formatters;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AdditionalDataUnpackTests {

    @Test
    public void testUnpack() throws Exception {
        AdditionalData addData = new AdditionalData();
        byte[] msgData = Formatters.getBinary().getBytes("30313433f0008cc20132303230323032303030303034373838383838303054616953726320202020202053696d536e6b202020202020303030303437303030303437446562697447726f7570202030303635323138506f7374696c696f6e3a4d657461446174613234313233355465726d4170702e49534f3a5265636f6e63696c696174696f6e496e64696361746f72313131");
        int offset = addData.unpack(msgData, 0);
        assertEquals(msgData.length, offset);
        assertEquals("2020202000004788888", addData.get(AdditionalData.Field.PosData));
    }

    @Test
    public void testAdminMessageUnpack() throws Exception {
        String msgStr = "4231363134723000100AC58000313632303038333831323334353637383930393130303030303030303030303030303030303132303039303330333030303031373134303132303131303330333133313032393030303030303030333530333030303838373737373132383837373737312020202020202020303638303034303443303030303030303030303030303030304430303030303030303030303031343034433030303030303030303030303030303044303030303030303030303030303738F0004BD20038383737373731323030303031372020202020313135303031546169537263202020202020416662536E6B20202020202030303030313730303332343341666247726F757020202020343034";
        byte[] msgData = Formatters.getBinary().getBytes(msgStr);
        Iso8583TermApp msg = new Iso8583TermApp(msgData);
        assertTrue(msg.isFieldSet(Iso8583TermApp.Bit._048_PRIVATE_ADDITIONAL_DATA));
        AdditionalData addData = msg.getAdditionalData();
        assertNotNull(addData);
        assertEquals("5001", addData.get(AdditionalData.Field.ExtendedTranType));
    }
}
