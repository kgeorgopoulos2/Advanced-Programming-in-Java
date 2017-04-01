package cr.persons;

import java.util.Date;

/**
 * This is the interface that describes the person or customer.
 */
public interface Person {
	/**
	 * This method returns the person's first name.
	 * 
	 * @return the person's first name.
	 */
	public String getFirstName();

	/**
	 * This method returns the person's last name.
	 * 
	 * @return the person's last name.
	 */
	public String getLastName();

	/**
	 * This method returns the person's date of birth.
	 * 
	 * @return the person's date of birth.
	 */
	public Date getDateOfBirth();

	/**
	 * This method overrides the {@code toString()} method in {@code Object}.
	 * <p>
	 * This method is used to provide a string representation for a person. A
	 * way to do that is returning the person's full name, followed by the date
	 * of birth.
	 * </p>
	 * <p>
	 * This method can and should be used to provide keys for {@code Collection}
	 * objects, since it returns a string representation for a person.
	 * </p>
	 * 
	 * @return a string representation of the person.
	 */
	public String toString();

}
