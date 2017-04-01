package cr.cars;

/**
 * {@code DefaultCarRegistrationNumber} is a simple car registration number,
 * that has two components. It extends the {@code RegistrationNumber} class.
 * <p>
 * The first component is two letters followed by two digits. The second
 * component is three letters. For example:
 * <ul>
 * <li>NG57 HXE</li>
 * </ul>
 * </p>
 * <p>
 * Instances of this class are created by using the
 * {@code public static DefaultCarRegistrationNumber valueOf(String registrationNumber)}
 * method.
 * </p>
 */
public class DefaultCarRegistrationNumber extends RegistrationNumber {

	private DefaultCarRegistrationNumber(String firstComponent, String secondComponent) {
		components = new String[2];
		components[0] = firstComponent;
		components[1] = secondComponent;
	}

	/**
	 * This is a static factory method that is used to create
	 * {@code DefaultCarRegistrationNumber} objects.
	 * 
	 * @param registrationNumber
	 *            The string representation of the registration number. It
	 *            should be composed of two components, that follows this
	 *            format:
	 *            <p>
	 *            The first component is two letters followed by two digits. The
	 *            second component is three letters. For example:
	 *            <ul>
	 *            <li>NG57 HXE</li>
	 *            </ul>
	 *            </p>
	 * @return a {@code DefaultCarRegistrationNumber} object, if the string
	 *         representation followed the format described above, and if the
	 *         registration number has not been previously created, since all
	 *         registration numbers are unique.
	 *         <p>
	 *         returns {@code null} otherwise.
	 *         </p>
	 */
	public static DefaultCarRegistrationNumber valueOf(String registrationNumber) {
		DefaultCarRegistrationNumber obj = null;
		String[] parts = registrationNumber.split(" ");

		if (!registrationNumber.matches("^[A-Z]{2}\\d{2} [A-Z]{3}")) {
			System.out.println("Invalid Car registration format.");
			return null;
		}

		if (uniqueCarRegistrationNumbers.get(registrationNumber) != null) {
			System.out.println("Car registration number already exists.");
			return null;
		}
		obj = new DefaultCarRegistrationNumber(parts[0], parts[1]);
		uniqueCarRegistrationNumbers.put(registrationNumber, obj);
		return obj;
	}

	/**
	 * This method overrides the {@code toString()} method in {@code Object}.
	 * <p>
	 * This method is used to provide a string representation of the
	 * registration number. It seperates the components with a space character.
	 * 
	 * @return a string representation of the registration number.
	 */
	public String toString() {
		return components[0] + " " + components[1];
	}

}
