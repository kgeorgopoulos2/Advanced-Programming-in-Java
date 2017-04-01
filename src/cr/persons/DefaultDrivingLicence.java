package cr.persons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * {@code DefaultDrivingLicence} is an implementation of a driving licence, that
 * has three components. It extends the {@code DrivingLicence} class.
 * <p>
 * The first component is the concatenation of the initial of the first name of
 * the driver with the initial of the last name of the driver. The second
 * component is the year of issue of the licence. The third component is an
 * arbitrary serial number. For example, the string representation of the
 * licence number for a licence issued to Mark Smith in 1990 would have the
 * form:
 * <ul>
 * <li>MS-1990-10</li>
 * </ul>
 * where the 10 is a serial number that, with the initials and year, guarantees
 * the uniqueness of the licence number as a whole.
 * </p>
 */
public class DefaultDrivingLicence extends DrivingLicence {

	private static DateFormat dateFormat = new SimpleDateFormat("yyyy");
	private static Random rnd = new Random();

	/**
	 * Constructor.
	 * 
	 * @param person
	 *            The owner of this driving licence.
	 * @param dateOfIssue
	 *            The date that the driving licence was issued.
	 * @param fullLicence
	 *            Whether the licence is a full driving licence or not.
	 */
	public DefaultDrivingLicence(Person person, Date dateOfIssue, boolean fullLicence) {
		components = new String[3];
		String firstNameInitial = person.getFirstName().substring(0, 1);
		String lastNameInitial = person.getLastName().substring(0, 1);
		this.dateOfIssue = dateOfIssue;
		this.fullLicence = fullLicence;
		this.components[0] = firstNameInitial + lastNameInitial;
		this.components[1] = dateFormat.format(dateOfIssue);
		this.components[2] = String.valueOf(rnd.nextInt(Integer.MAX_VALUE));
		while (uniqueDrivingLicences.get(this.toString()) != null) {
			this.components[2] = String.valueOf(rnd.nextInt(Integer.MAX_VALUE));
		}
		uniqueDrivingLicences.put(this.toString(), this);
	}

	/**
	 * This method overrides the {@code toString()} method in {@code Object}.
	 * <p>
	 * This method is used to provide a string representation of the driving
	 * licence. It seperates the components with a "-" character.
	 * 
	 * @return a string representation of the driving licence.
	 */
	public String toString() {
		return components[0] + "-" + components[1] + "-" + components[2];
	}
}
