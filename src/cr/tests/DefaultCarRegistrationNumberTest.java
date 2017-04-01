package cr.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import cr.cars.DefaultCarRegistrationNumber;

public class DefaultCarRegistrationNumberTest extends MyTest {
	
	/**
	 * Show two examples where registration number is correct, so we do
	 * assertNotNull to show its correct.
	 */
	@Test
	public void testCorrectInstantiation() {
		DefaultCarRegistrationNumber registrationNumber;
		registrationNumber = DefaultCarRegistrationNumber.valueOf("NG57 HXE");
		assertNotNull(registrationNumber);
		registrationNumber = DefaultCarRegistrationNumber.valueOf("AB00 CDE");
		assertNotNull(registrationNumber);
	}
	
	/**
	 * We check for what values we have wrong instantiation of the class, so
	 * we assertNull to show that we get null in the values.
	 */
	@Test
	public void testWrongInstantiation() {
		DefaultCarRegistrationNumber registrationNumber;
		// check for identifiers with the wrong format, for what values we have wrong instantiation of the class
		registrationNumber = DefaultCarRegistrationNumber.valueOf("test");
		assertNull(registrationNumber);
		registrationNumber = DefaultCarRegistrationNumber.valueOf("AA11BBB");
		assertNull(registrationNumber);
		registrationNumber = DefaultCarRegistrationNumber.valueOf("AA11 BBB C");
		assertNull(registrationNumber);
		registrationNumber = DefaultCarRegistrationNumber.valueOf("1A11 BBB");
		assertNull(registrationNumber);
		registrationNumber = DefaultCarRegistrationNumber.valueOf("A111 BBB");
		assertNull(registrationNumber);
		registrationNumber = DefaultCarRegistrationNumber.valueOf("AAA1 BBB");
		assertNull(registrationNumber);
		registrationNumber = DefaultCarRegistrationNumber.valueOf("AAAA BBB");
		assertNull(registrationNumber);
		registrationNumber = DefaultCarRegistrationNumber.valueOf("AA11 1BB");
		assertNull(registrationNumber);
		registrationNumber = DefaultCarRegistrationNumber.valueOf("AA11 B1B");
		assertNull(registrationNumber);
		registrationNumber = DefaultCarRegistrationNumber.valueOf("AA11 BB1");
		assertNull(registrationNumber);
		registrationNumber = DefaultCarRegistrationNumber.valueOf("aa11 bbb");
		assertNull(registrationNumber);
		// check for unique identifiers
		registrationNumber = DefaultCarRegistrationNumber.valueOf("AB11 CDE");
		registrationNumber = DefaultCarRegistrationNumber.valueOf("AB11 CDE");
		assertNull(registrationNumber);
	}

	@Test
	public void testGetComponents() {
		DefaultCarRegistrationNumber registrationNumber;
		String id = "NG58 HXE";
		registrationNumber = DefaultCarRegistrationNumber.valueOf(id);
		String[] parts = id.split(" ");
		assertEquals(parts[0], registrationNumber.getComponents()[0]);
		assertEquals(parts[1], registrationNumber.getComponents()[1]);
	}

	@Test
	public void testCorrectStringRepresentation() {
		DefaultCarRegistrationNumber registrationNumber;
		String id = "NG59 HXE";
		registrationNumber = DefaultCarRegistrationNumber.valueOf(id);
		assertEquals(id, registrationNumber.toString());
	}

}
