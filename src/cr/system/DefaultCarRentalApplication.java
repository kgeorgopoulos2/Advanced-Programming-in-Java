package cr.system;

import java.util.ArrayList;
import java.util.HashMap;

import cr.cars.Car;
import cr.cars.Drivable;
import cr.cars.LargeCar;
import cr.cars.RegistrationNumber;
import cr.cars.SmallCar;
import cr.persons.DrivingLicence;
import cr.persons.Person;
import cr.util.Utility;

/**
 * {@code DefaultCarRentalApplication} is an implementation of the car rental
 * system interface, as it extends {@code AbstractCarRentalSystem}. It provides
 * the functionality of the simple car rental system described in the System
 * overview section.
 */
public class DefaultCarRentalApplication extends AbstractCarRentalSystem {

	private int smallCarsRemaining = 20;
	private int largeCarsRemaining = 10;

	public DefaultCarRentalApplication() {
		totalAvailableCars = new ArrayList<Drivable>();
		currentlyRentedCars = new HashMap<String, Drivable>();
	}

	public void issueCar(Person person, DrivingLicence licence, String carType) {
		Car eligibleCar = null;
		if (availableCars(carType) == 0) {
			System.out.println("Cannot issue car.");
			return;
		}

		for (Drivable car : totalAvailableCars) {
			if (car.getType().equals(carType) && car.isActive()) {
				eligibleCar = (Car) car;
			}
		}

		if (eligibleCar == null) {
			System.out.println("Cannot issue car.");
			return;
		}

		if (!licence.isLicenceFull()) {
			System.out.println("Cannot issue car.");
			return;
		}

		if (currentlyRentedCars.get(person.toString()) != null) {
			System.out.println("Cannot issue car.");
			return;
		}

		int yearsOld = Utility.calculateAge(person.getDateOfBirth());
		int yearsDriver = Utility.calculateAge(licence.getDateOfIssue());

		if (carType.equals("small")) {
			if (yearsOld < 20 || yearsDriver < 1) {
				System.out.println("Cannot issue car.");
				return;
			}
		} else if (carType.equals("large")) {
			if (yearsOld < 25 || yearsDriver < 5) {
				System.out.println("Cannot issue car.");
				return;
			}
		}

		this.currentlyRentedCars.put(person.toString(), eligibleCar);
		eligibleCar.deactivate();
		System.out.println("Rental contract issued for " + person.toString());
		eligibleCar.addFuel(eligibleCar.getTotalFuelCapacity());

	}

	public int terminateRental(Person person) {
		Car car = (Car) currentlyRentedCars.remove(person.toString());
		int litresRequiredToFillTank = 0;
		if (car != null) {
			car.activate();
			if (car.getCurrentFuelCapacity() >= 0) {
				litresRequiredToFillTank = car.getTotalFuelCapacity() - car.getCurrentFuelCapacity();
			} else {
				litresRequiredToFillTank = car.getTotalFuelCapacity();
			}
			System.out.println("Rental contract terminated for " + person.toString());
			System.out.println("Litres required to fill the fuel tank: " + litresRequiredToFillTank);
		}
		return litresRequiredToFillTank;
	}

	@Override
	public Drivable createCar(String carType, RegistrationNumber carRegistrationNumber) {
		if (carRegistrationNumber != null) {
			if (carType.equals("small")) {
				return new SmallCar(carRegistrationNumber);
			} else if (carType.equals("large")) {
				return new LargeCar(carRegistrationNumber);
			}
		}
		return null;
	}

	/**
	 * This method will add a car to the list of available cars to rent. In
	 * order for the application to function correctly, created cars need to be
	 * added using this method.
	 * <p>
	 * Since this class implements the car rental system for the car rental
	 * company described in the system overview section, this method restricts
	 * the total number of small and large cars that can be added to the
	 * application to 20 and 10 respectively.
	 * </p>
	 * 
	 * @param car
	 *            the car to add to the list of available cars.
	 * 
	 */
	public void addCar(Drivable car) {
		if (car != null) {
			if (car.getType().equals("small")) {
				if (smallCarsRemaining > 0) {
					totalAvailableCars.add(car);
					smallCarsRemaining--;
				} else {
					System.out.println("Small car limit of 20 cars reached.");
				}
			} else if (car.getType().equals("large")) {
				if (largeCarsRemaining > 0) {
					totalAvailableCars.add(car);
					largeCarsRemaining--;
				} else {
					System.out.println("Large car limit of 10 cars reached.");
				}
			}
		} else {
			System.out.println("Car is not instantiated, can't add it to list of available cars.");
		}
	}
}
