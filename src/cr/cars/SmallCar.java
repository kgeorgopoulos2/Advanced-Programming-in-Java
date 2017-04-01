package cr.cars;

/**
 * The {@code SmallCar} class is an implementation of the {@code Drivable}
 * interface and is used for the simple car rental system that is implemented in
 * the {@code DefaultCarRentalApplication} class.
 */
public class SmallCar extends Car {

	/**
	 * {@code SmallCar}'s constructor. Sets the vehicle's type as "small".
	 * 
	 * @param carRegistrationNumber
	 *            A reference to a RegistrationNumber object.
	 */
	public SmallCar(RegistrationNumber carRegistrationNumber) {
		super(carRegistrationNumber);
		this.type = "small";
	}

	@Override
	public int getTotalFuelCapacity() {
		return 49;
	}

	@Override
	protected int startJourney(int kilometres) {
		double consumedFuel = 0;
		double consumptionRate = 1 / 20.0;
		consumedFuel = (kilometres * consumptionRate);
		consumedFuel = Math.ceil(consumedFuel);
		return (int) consumedFuel;
	}
}
