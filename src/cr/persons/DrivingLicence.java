package cr.persons;

import java.util.Date;
import java.util.HashMap;

/**
 * {@code DrivingLicence} is an abstract class that is used to implement driving
 * licences for the people or customers of the car rental system.
 * <p>
 * A driving licence is composed by a number of {@code String} components.
 * </p>
 * All {@code DrivingLicence} objects hold a {@code static} reference to a
 * {@code HashMap} collection, that is used to keep track of the created
 * {@code DrivingLicence} objects, to ensure that all of them are unique.
 */
public abstract class DrivingLicence {

	protected static HashMap<String, DrivingLicence> uniqueDrivingLicences = new HashMap<String, DrivingLicence>();
	protected String[] components;
	protected Date dateOfIssue;
	protected boolean fullLicence;

	/**
	 * This method returns the driving licence's components.
	 * 
	 * @return an array of the {@code String} components that the driving
	 *         licence is composed of.
	 */
	public String[] getComponents() {
		return components;
	}

	/**
	 * This method returns driving licence's date of issue.
	 * 
	 * @return The driving licence's date of issue.
	 */
	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	/**
	 * This method returns whether the licence is a full driving licence or not.
	 * 
	 * @return {@code true} if the licence is a full driving licence, or
	 *         <p>
	 *         {@code false} if not.
	 */
	public boolean isLicenceFull() {
		return fullLicence;
	}

	public abstract String toString();
}
