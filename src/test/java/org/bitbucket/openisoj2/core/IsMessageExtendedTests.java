package org.bitbucket.openisoj2.core;

import org.bitbucket.openisoj2.core.exceptions.UnknownFieldException;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by John Oxley
 */
public class IsMessageExtendedTests {
    @Test
    public void notExtended() throws UnknownFieldException {
        assertFalse((new Iso8583()).isExtended());
        Iso8583 msg = new Iso8583();
        msg.set(Iso8583.Bit._002_PAN, "345678765");
        msg.set(Iso8583.Bit._059_ECHO_DATA, "345678765");
        assertFalse(msg.isExtended());
    }

    @Test
    public void testExtended() throws Exception {
        Iso8583 msg = new Iso8583();
        msg.set(Iso8583.Bit._066_SETTLEMENT_CODE, "5");
        assertTrue(msg.isExtended());
    }
}
