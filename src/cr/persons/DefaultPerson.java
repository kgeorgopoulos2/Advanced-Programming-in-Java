package cr.persons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is an implementation of the {@code Person} interface.
 */
public class DefaultPerson implements Person {

	private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private String firstName;
	private String lastName;
	private Date dateOfBirth;

	/**
	 * Constructor.
	 * 
	 * @param firstName
	 *            The person's first name.
	 * @param lastName
	 *            The person's last name.
	 * @param dateOfBirth
	 *            The person's date of birth.
	 */
	public DefaultPerson(String firstName, String lastName, Date dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * This method overrides the {@code equals(Object obj)} method in
	 * {@code Object} since there's the need for logical equivalence. Two people
	 * are considered to be the same if they have the same name and the same
	 * date of birth.
	 * 
	 * @param obj
	 *            The object to compare for logical equivalence.
	 * 
	 * @return {@code true} if compared object and this are logical equivalent,
	 *         <p>
	 *         {@code false} otherwise.
	 *         </p>
	 */
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof DefaultPerson)) {
			return false;
		}
		DefaultPerson person = (DefaultPerson) obj;
		boolean checkDateOfBirth = dateOfBirth.equals(person.dateOfBirth);
		boolean checkFirstName = (firstName == null ? person.firstName == null : firstName.equals(person.firstName));
		boolean checkLastName = (lastName == null ? person.lastName == null : lastName.equals(person.lastName));
		return (checkDateOfBirth && checkFirstName && checkLastName);
	}

	public int hashCode() {
		int hashCode = 7;
		hashCode = 13 * hashCode + (firstName == null ? 0 : firstName.hashCode());
		hashCode = 13 * hashCode + (lastName == null ? 0 : lastName.hashCode());
		hashCode = 13 * hashCode + (dateOfBirth == null ? 0 : dateOfBirth.hashCode());
		return hashCode;
	}

	public String toString() {
		String dateFormatted = dateFormat.format(dateOfBirth);
		return (firstName + "-" + lastName + "-" + dateFormatted);
	}
}
