package cr.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import cr.persons.DefaultDrivingLicence;
import cr.persons.DefaultPerson;

public class DefaultDrivingLicenceTest extends MyTest {

	@Test
	public void testCorrectStringRepresentation() {
		DefaultPerson person = createPerson("John", "Doe", new MyDate(30, 12, 1992));
		DefaultDrivingLicence licence = createLicence(person, new MyDate(30, 12, 2010), true);

		DefaultPerson otherPerson = createPerson("Jane", "Doe", new MyDate(1, 1, 1990));
		DefaultDrivingLicence otherLicence = createLicence(otherPerson, new MyDate(29, 12, 2010), false);
		// checking if arbitrary number is not the same
		assertNotEquals(licence.toString(), otherLicence.toString());
	}

	@Test
	public void testGetComponents() {
		DefaultPerson person = createPerson("John", "Doe", new MyDate(30, 12, 1990));
		DefaultDrivingLicence licence = createLicence(person, new MyDate(30, 12, 2009), true);

		assertEquals(3, licence.getComponents().length);
		assertEquals("JD", licence.getComponents()[0]);
		assertEquals(String.valueOf(2009), licence.getComponents()[1]);
	}

}
