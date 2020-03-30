package org.bitbucket.openisoj2.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Track2DelimiterDTests {
	private Track2 track2;

	@Before
	public void before() {
		track2 = new Track2("1234560000000000991D12075260000");
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
	public void testToString() {
		String expected = "1234560000000000991D12075260000";
		String actual = track2.toString();
		assertEquals(expected, actual);
	}
}
