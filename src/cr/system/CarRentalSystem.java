package cr.system;

import java.util.Collection;

import cr.cars.Drivable;
import cr.cars.RegistrationNumber;
import cr.persons.DrivingLicence;
import cr.persons.Person;

/**
 * The interface {@code CarRentalSystem} provides a car rental system's
 * functionality.
 * <p>
 * There's also the abstract class {@code AbstractCarRentalSystem} that provides
 * a skeletal implementation for some of the interface's functionality, and a
 * simple car rental system is implemented on the
 * {@code CarRentalDefaultApplication} class.
 * </p>
 */
public interface CarRentalSystem {

	/**
	 * This method returns the number of cars of the specified type that are
	 * available to rent.
	 * 
	 * @param carType
	 *            The type of car.
	 * @return The number of cars that the {@code carType} argument specifies
	 *         that are available to rent.
	 */
	public int availableCars(String carType);

	/**
	 * This method returns a collection of all the cars currently rented out.
	 * 
	 * @return A {@code Collection} of {@code Drivable} objects.
	 */
	public Collection<Drivable> getRentedCars();

	/**
	 * This method returns the car that a {@code Person} is currently renting.
	 * 
	 * @param person
	 *            The person that rented the car.
	 * @return The car that the person is currently renting.
	 *         <p>
	 *         Otherwise returns {@code null} if the person is not renting a
	 *         car.
	 *         </p>
	 */
	public Drivable getCar(Person person);

	/**
	 * This method determines whether a person is eligible to rent a car of the
	 * specified type and if there is a car of that type available, issues it
	 * for rent.
	 * 
	 * @param person
	 *            The person that wants to rent the car.
	 * @param licence
	 *            The person's {@code DrivingLicence}.
	 * @param carType
	 *            The type of car.
	 */
	public void issueCar(Person person, DrivingLicence licence, String carType);

	/**
	 * This method terminates the given person's rental contract. If the given
	 * person has no current rental contract, this method does nothing.
	 * 
	 * @param person
	 *            The person that rented the car.
	 * @return the amount of fuel in Litres required to fill the car's tank.
	 */
	public int terminateRental(Person person);

	/**
	 * This is a factory method that is used to create car objects.
	 * 
	 * @param carType
	 *            The type of car to instantiate.
	 * @param carRegistrationNumber
	 *            An instance to a {@code CarRegistrationNumber} object.
	 * @return A car object.
	 */
	public Drivable createCar(String carType, RegistrationNumber carRegistrationNumber);
}
