package cr.cars;

/**
 * The {@code Car} class provides a skeletal implementation of the
 * {@code Drivable} interface, to minimize the effort required to implement this
 * interface.
 */
public abstract class Car implements Drivable {

	protected RegistrationNumber carRegistrationNumber;
	protected int currentFuelCapacity;
	protected String type;
	protected boolean active;

	protected Car(RegistrationNumber carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
		this.active = true;
	}

	public RegistrationNumber getRegistrationNumber() {
		return carRegistrationNumber;
	}

	public boolean isTankFull() {
		return (getCurrentFuelCapacity() == getTotalFuelCapacity());
	}

	public int getCurrentFuelCapacity() {
		return currentFuelCapacity;
	}

	public int addFuel(int fuel) {
		int addedFuel = 0;
		if (currentFuelCapacity + fuel > getTotalFuelCapacity()) {
			addedFuel = (getTotalFuelCapacity() - currentFuelCapacity);
			currentFuelCapacity = getTotalFuelCapacity();
		} else {
			currentFuelCapacity += fuel;
			addedFuel = fuel;
		}
		if (addedFuel >= 0) {
			System.out.println("Added " + addedFuel + " Litres of fuel.");
		} else {
			System.out.println("Removed " + Math.abs(addedFuel) + " Litres of fuel.");
		}
		return addedFuel;
	}

	public int drive(int kilometres) {
		if (!shouldBeDriving()) {
			System.out.println("Can't drive car.");
			kilometres = 0;
		}
		int consumedFuel = startJourney(kilometres);
		this.addFuel(-consumedFuel);
		return consumedFuel;
	}

	private boolean shouldBeDriving() {
		if (isActive() || getCurrentFuelCapacity() <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * This method is used to implement the vehicle specific consumption rate of
	 * fuel, given a number of Kilometres and returns the total fuel consumed by
	 * the journey.
	 * 
	 * @param kilometres
	 *            the number of whole Kilometres that the vehicle has to drive.
	 * @return the amount of whole Litres of fuel consumed during the vehicle's
	 *         journey.
	 */
	protected abstract int startJourney(int kilometres);

	public boolean isActive() {
		return active;
	}

	public void activate() {
		this.active = true;
	}

	public void deactivate() {
		this.active = false;
	}

	public String getType() {
		return type;
	}

	public String toString() {
		return getType() + "_" + getRegistrationNumber().toString();
	}

}
