package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Track2NoExpiry {
	private Track2 track2;

	@Before
	public void before() {
		track2 = new Track2("12345651788462551===12345");
	}

	@Test
	public void testExpiryNoResCode() {
		Track2 t2 = new Track2("12345651788462551=1207=12345");
		assertEquals("12345651788462551", t2.getPan());
		assertEquals("1207", t2.getExpiry());
		assertNull(t2.getServiceRestrictionCode());
		assertEquals("12345", t2.getDiscretionaryData());
	}

	@Test
	public void testGetDiscretionaryData() {
		assertEquals("12345", track2.getDiscretionaryData());
	}

	@Test
	public void testGetExpiry() {
		assertNull(track2.getExpiry());
	}

	@Test
	public void testGetPan() {
		String expected = "12345651788462551";
		String actual = track2.getPan();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetServiceRestrictionCode() {
		assertNull(track2.getServiceRestrictionCode());
	}

	@Test
	public void testNoExpiryResCode() {
		Track2 t2 = new Track2("12345651788462551==54012345");
		assertEquals("12345651788462551", t2.getPan());
		assertNull(t2.getExpiry());
		assertEquals("540", t2.getServiceRestrictionCode());
		assertEquals("12345", t2.getDiscretionaryData());
	}

	@Test
	public void testToString() {
		String expected = "12345651788462551===12345";
		String actual = track2.toString();
		assertEquals(expected, actual);
	}
}
