package cr.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cr.cars.Drivable;
import cr.persons.DrivingLicence;
import cr.persons.Person;
import cr.system.DefaultCarRentalApplication;

public class DefaultCarRentalApplicationTest extends MyTest {

	private DefaultCarRentalApplication application = new DefaultCarRentalApplication();

	@Test
	public void testAvailableCars() {
		assertEquals(0, application.availableCars("small"));
		assertEquals(0, application.availableCars("large"));
		Drivable car = application.createCar("small", createRegistrationNumber("NG57 HXE"));
		application.addCar(car);
		assertEquals(1, application.availableCars("small"));
		car = application.createCar("small", createRegistrationNumber("NG58 HXE"));
		application.addCar(car);
		car = application.createCar("large", createRegistrationNumber("NG59 HXE"));
		application.addCar(car);
		assertEquals(2, application.availableCars("small"));
		assertEquals(1, application.availableCars("large"));
	}

	@Test
	public void testGetCar() {
		Drivable car = application.createCar("small", createRegistrationNumber("NG60 HXE"));
		application.addCar(car);
		Person person = createPerson("John", "Doe", new MyDate(30, 12, 1992));
		DrivingLicence licence = createLicence(person, new MyDate(30, 12, 2010), true);
		// test getCar before issuing rent contract.
		car = application.getCar(person);
		assertNull(car);
		application.issueCar(person, licence, "small");
		// test getCar after issuing rent contract.
		car = application.getCar(person);
		assertNotNull(car);
	}

	@Test
	public void testIssueCar() {
		Drivable car = application.createCar("small", createRegistrationNumber("NG61 HXE"));
		application.addCar(car);
		Person person = createPerson("John", "Doe", new MyDate(30, 12, 1992));
		DrivingLicence licence = createLicence(person, new MyDate(30, 12, 2010), false);
		// testing isueCar without full driving licence
		application.issueCar(person, licence, "small");
		// if getCar for the person is not null, issueCar did not work
		assertNull(application.getCar(person));

		person = createPerson("John", "Doe", new MyDate(30, 12, 1992));
		licence = createLicence(person, new MyDate(30, 12, 2010), true);
		application.issueCar(person, licence, "small");
		// person is at least 20 years old and has been driving for at least 1
		// years, he is able to rent a small car
		assertNotNull(application.getCar(person));

		car = application.createCar("small", createRegistrationNumber("NG62 HXE"));
		application.addCar(car);
		// trying to issue other car before terminating rental
		application.issueCar(person, licence, "small");
		car = application.getCar(person);
		assertNotEquals("NG62 HXE", car.getRegistrationNumber().toString());
		assertEquals("NG61 HXE", car.getRegistrationNumber().toString());
		application.terminateRental(person);

		person = createPerson("John", "Doe", new MyDate(30, 12, 1992));
		licence = createLicence(person, new MyDate(30, 12, 2015), true);
		// person has not been driving for at least 1 year, can't rent small
		// car.
		application.issueCar(person, licence, "small");
		assertNull(application.getCar(person));

		person = createPerson("John", "Doe", new MyDate(30, 12, 1996));
		licence = createLicence(person, new MyDate(30, 12, 2014), true);
		// person is not 20 years old, can't rent small car
		application.issueCar(person, licence, "small");
		assertNull(application.getCar(person));

		// adding large car
		car = application.createCar("large", createRegistrationNumber("NG63 HXE"));
		application.addCar(car);

		person = createPerson("John", "Doe", new MyDate(30, 12, 1990));
		licence = createLicence(person, new MyDate(30, 12, 2015), true);
		// person has not been driving for at least 5 year, can't rent large
		// car.
		application.issueCar(person, licence, "large");
		assertNull(application.getCar(person));

		person = createPerson("John", "Doe", new MyDate(30, 12, 1992));
		licence = createLicence(person, new MyDate(30, 12, 2010), true);
		// person is not 25 years old, can't rent large car
		application.issueCar(person, licence, "large");
		assertNull(application.getCar(person));

		person = createPerson("John", "Doe", new MyDate(30, 12, 1990));
		licence = createLicence(person, new MyDate(30, 12, 2010), true);
		// person is at least 25 years old and has been driving for at least 5
		// years, he is able to rent a large car
		application.issueCar(person, licence, "large");
		assertNotNull(application.getCar(person));
	}

	@Test
	public void testTerminateRental() {
		Drivable car = application.createCar("small", createRegistrationNumber("NG64 HXE"));
		application.addCar(car);
		Person person = createPerson("John", "Doe", new MyDate(30, 12, 1990));
		DrivingLicence licence = createLicence(person, new MyDate(30, 12, 2010), true);
		application.issueCar(person, licence, "small");
		car = application.getCar(person);
		assertEquals(0, application.terminateRental(person));

		application.issueCar(person, licence, "small");
		car = application.getCar(person);
		car.drive(100);
		assertNotEquals(0, application.terminateRental(person));
	}
}
