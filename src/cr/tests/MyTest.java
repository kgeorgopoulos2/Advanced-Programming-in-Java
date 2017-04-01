package cr.tests;

import java.util.Date;
import java.util.GregorianCalendar;

import cr.cars.DefaultCarRegistrationNumber;
import cr.persons.DefaultDrivingLicence;
import cr.persons.DefaultPerson;
import cr.persons.Person;

public abstract class MyTest {

	/**
	 * Helper class that stores a date. Used in unit testing classes for
	 * instantiation of {@code Calendar} objects.
	 */
	protected static class MyDate {
		private final int day;
		private final int month;
		private final int year;

		/**
		 * Constructor.
		 * 
		 * @param day
		 *            Day of the month to store. (1-31)
		 * @param month
		 *            Month to store. (1-12)
		 * @param year
		 *            Year to store.
		 */
		public MyDate(int day, int month, int year) {
			this.day = day;
			this.month = month - 1;
			this.year = year;
		}

		/**
		 * Returns the day stored.
		 * 
		 * @return day stored (1-31).
		 */
		public int getDay() {
			return day;
		}

		/**
		 * Returns the month stored.
		 * 
		 * @return month stored (0-11).
		 */
		public int getMonth() {
			return month;
		}

		/**
		 * Returns the year stored.
		 * 
		 * @return year stored.
		 */
		public int getYear() {
			return year;
		}
	}

	/**
	 * Helper method used in unit testing classes, to instantiate
	 * {@code DefaultPerson} objects.
	 * 
	 * @param firstName
	 *            person's first name.
	 * @param lastName
	 *            person's last name.
	 * @param date
	 *            {@code MyDate} date.
	 * @return {@code DefaultPerson} object.
	 */
	protected DefaultPerson createPerson(String firstName, String lastName, MyDate date) {
		Date dateOfBirth = new GregorianCalendar(date.getYear(), date.getMonth(), date.getDay()).getTime();
		DefaultPerson person = new DefaultPerson(firstName, lastName, dateOfBirth);
		return person;
	}

	/**
	 * Helper method used in unit testing classes, to instantiate
	 * {@code DefaultDrivingLicence} objects.
	 * 
	 * @param person
	 *            {@code Person} object.
	 * @param date
	 *            {@code MyDate} date.
	 * @param full
	 *            Whether licence is full or not.
	 * @return {@code DefaultDrivingLicence} object.
	 */
	protected DefaultDrivingLicence createLicence(Person person, MyDate date, boolean full) {
		Date dateOfIssue = new GregorianCalendar(date.getYear(), date.getMonth(), date.getDay()).getTime();
		DefaultDrivingLicence licence = new DefaultDrivingLicence(person, dateOfIssue, full);
		return licence;
	}

	/**
	 * Helper method used in unit testing classes, to instantiate
	 * {@code DefaultCarRegistrationNumber} objects.
	 * 
	 * @param registrationNumber
	 *            a registration number string representation.
	 * @return {@code DefaultCarRegistrationNumber} object.
	 */
	protected DefaultCarRegistrationNumber createRegistrationNumber(String registrationNumber) {
		return DefaultCarRegistrationNumber.valueOf(registrationNumber);
	}

}
