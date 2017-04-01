package cr.cars;

import java.util.HashMap;

/**
 * {@code RegistrationNumber} is an abstract class that is used to implement
 * registration numbers for the vehicles of the car rental system.
 * <p>
 * A registration number is composed by a number of {@code String} components.
 * </p>
 * All {@code RegistrationNumber} objects hold a {@code static} reference to a
 * {@code HashMap} collection, that is used to keep track of the created
 * {@code RegistrationNumber} objects, to ensure that all of them are unique.
 */
public abstract class RegistrationNumber {

	protected static HashMap<String, RegistrationNumber> uniqueCarRegistrationNumbers = new HashMap<String, RegistrationNumber>();
	protected String[] components;

	/**
	 * This method returns the registration number's components.
	 * 
	 * @return an array of the {@code String} components that the registration
	 *         number is composed of.
	 */
	public String[] getComponents() {
		return components;
	}

	public abstract String toString();

}
