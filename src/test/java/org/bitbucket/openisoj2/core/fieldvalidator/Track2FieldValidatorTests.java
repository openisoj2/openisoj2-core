package org.bitbucket.openisoj2.core.fieldvalidator;

import static org.junit.Assert.*;

import org.junit.Test;

public class Track2FieldValidatorTests {
	private static final Track2FieldValidator validator = new Track2FieldValidator();

	private void testIsValid(String track2) {
		assertTrue(validator.isValid(track2));
	}

	private void testIsNotValid(String track2) {
		assertFalse(validator.isValid(track2));
	}

	@Test
	public void testValid() {
		testIsValid("123456001234===");
		testIsValid("123456001234=");
		testIsValid("123456001234=1503=");
		testIsValid("123456001234==501");
		testIsValid("123456001234=1503501");
		testIsValid("123456001234===987654");
		testIsValid("123456001234=1503=987654");
		testIsValid("123456001234==501987654");
		testIsValid("123456001234=1503501987654");

		// For retarted banks that don't create proper track 2 data
		testIsValid("123456001234=1503");
		testIsValid("123456001234=");

		testIsValid("123456001234DDD");
		testIsValid("123456001234D");
		testIsValid("123456001234D1503D");
		testIsValid("123456001234DD501");
		testIsValid("123456001234D1503501");
		testIsValid("123456001234DDD987654");
		testIsValid("123456001234D1503D987654");
		testIsValid("123456001234DD501987654");
		testIsValid("123456001234D1503501987654");

		// For retarted banks that don't create proper track 2 data
		testIsValid("123456001234D1503");
		testIsValid("123456001234D");
	}

	@Test
	public void testInvalids() {
		testIsNotValid("123456001234E==");
		testIsNotValid("123456001a34=");
		testIsNotValid("123456001AS34=1503=");
		testIsNotValid("14==501");
		testIsNotValid("165473573573244968168135523456001234=1503501");
		testIsNotValid("123456001234=FF=987654");
	}

}
