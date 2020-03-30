package org.bitbucket.openisoj2.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Track2Tests {
	private Track2 track2;

	@Before
	public void before() {
		track2 = new Track2("1234560000000000991=12075260000");
	}

    @Test
    public void testPaddedT2(){
        Track2 t2 = new Track2("1234560000000000991f=12075260000");
        assertEquals("1234560000000000991", t2.getPan());
    }

	@Test
	public void testGetDiscretionaryData() {
		String expected = "0000";
		String actual = track2.getDiscretionaryData();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetExpiry() {
		String expected = "1207";
		String actual = track2.getExpiry();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetPan() {
		String expected = "1234560000000000991";
		String actual = track2.getPan();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetServiceRestrictionCode() {
		String expected = "526";
		String actual = track2.getServiceRestrictionCode();
		assertEquals(expected, actual);
	}

	@Test
	public void testInvalidTrack2() {
		try {
			new Track2("1234560000000000991");
			fail("Expected illegal argument exception");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testMissingData() {
		Track2 t2 = new Track2("123456001234=");
		assertNull(t2.getServiceRestrictionCode());
		assertNull(t2.getDiscretionaryData());
		assertNull(t2.getExpiry());
		assertEquals("123456001234", t2.getPan());
	}

	@Test
	public void testMissingSrc() {
		Track2 t2 = new Track2("123456001234=1503");
		assertNull(t2.getServiceRestrictionCode());
		assertNull(t2.getDiscretionaryData());
		assertEquals("1503", t2.getExpiry());
		assertEquals("123456001234", t2.getPan());
	}

	@Test
	public void testToString() {
		String expected = "1234560000000000991=12075260000";
		String actual = track2.toString();
		assertEquals(expected, actual);
	}
}
