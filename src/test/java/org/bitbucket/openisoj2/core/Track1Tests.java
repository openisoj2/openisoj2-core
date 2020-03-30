package org.bitbucket.openisoj2.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class Track1Tests {
    @Test
    public void testValid() {
        String t1 = "B1234567895343547^PETER/OXLEY JOHN ROBERT   ^1907101235725416835357357186210";
        Track1 track1 = new Track1(t1);
        assertEquals("1234567895343547", track1.getPan());
        assertEquals("PETER/OXLEY JOHN ROBERT   ", track1.getName());
        assertEquals("1907", track1.getExpiry());
        assertEquals("101", track1.getSrc());
        assertEquals("235725416835357357186210", track1.getDiscretionaryData());
        assertEquals(t1, track1.toString());
    }
}
