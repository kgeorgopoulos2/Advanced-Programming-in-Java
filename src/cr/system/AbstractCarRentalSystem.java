package cr.system;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import cr.cars.Drivable;
import cr.cars.RegistrationNumber;
import cr.persons.DrivingLicence;
import cr.persons.Person;

/**
 * This class provides a skeletal implementation of the {@code CarRentalSystem}
 * interface, to minimize the effort required to implement this interface.
 */
public abstract class AbstractCarRentalSystem implements CarRentalSystem {

	protected List<Drivable> totalAvailableCars;
	protected Map<String, Drivable> currentlyRentedCars;

	public int availableCars(String carType) {
		int count = 0;
		for (Drivable car : totalAvailableCars) {
			if (car.getType().equals(carType) && car.isActive()) {
				count++;
			}
		}
		return count;
	}

	public Collection<Drivable> getRentedCars() {
		return currentlyRentedCars.values();
	}

	public Drivable getCar(Person person) {
		return currentlyRentedCars.get(person.toString());
	}

	public abstract void issueCar(Person person, DrivingLicence licence, String carType);

	public abstract int terminateRental(Person person);

	public abstract Drivable createCar(String carType, RegistrationNumber carRegistrationNumber);

}
