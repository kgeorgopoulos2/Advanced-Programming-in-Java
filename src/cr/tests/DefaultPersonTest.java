package cr.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import cr.persons.DefaultPerson;

public class DefaultPersonTest extends MyTest {

	@Test
	public void testEquals() {
		DefaultPerson person = createPerson("John", "Doe", new MyDate(30, 12, 1992));
		DefaultPerson otherPerson = createPerson("John", "Doe", new MyDate(29, 12, 1992));

		assertNotEquals(person, otherPerson);
	}

	@Test
	public void testCorrectStringRepresentation() {
		DefaultPerson person = createPerson("John", "Doe", new MyDate(30, 12, 1992));

		assertEquals("John-Doe-30/12/1992", person.toString());
	}

	@Test
	public void testWrongStringRepresentation() {
		DefaultPerson person = createPerson("John", "Doe", new MyDate(30, 12, 1992));

		assertNotEquals("John-Doe-30/12/1993", person.toString());
		assertNotEquals("Jane-Doe-30/12/1992", person.toString());
	}

}
