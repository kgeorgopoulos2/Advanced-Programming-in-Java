package cr.cars;

/**
 * The {@code LargeCar} class is an implementation of the {@code Drivable}
 * interface and is used for the simple car rental system that is implemented in
 * the {@code DefaultCarRentalApplication} class.
 */
public class LargeCar extends Car {

	/**
	 * {@code LargeCar}'s constructor. Sets the vehicle's type as "large".
	 * 
	 * @param carRegistrationNumber
	 *            A reference to a RegistrationNumber object.
	 */
	public LargeCar(RegistrationNumber carRegistrationNumber) {
		super(carRegistrationNumber);
		this.type = "large";
	}

	public int getTotalFuelCapacity() {
		return 60;
	}

	protected int startJourney(int kilometres) {
		double consumedFuel = 0;
		double startingConsumptionRate = 1 / 10.0;
		double changedConsumptionRate = 1 / 15.0;

		if (kilometres <= 50) {
			consumedFuel = (kilometres * startingConsumptionRate);
		} else {
			consumedFuel = (50 * startingConsumptionRate);
			consumedFuel += ((kilometres - 50) * changedConsumptionRate);
		}
		consumedFuel = Math.ceil(consumedFuel);
		return (int) consumedFuel;
	}

}
