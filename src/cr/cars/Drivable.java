package cr.cars;

/**
 * The {@code Drivable} interface describes the car (or any drivable vehicle)
 * functionality that is to be used with the {@code CarRentalSystem} interface.
 */
public interface Drivable {

	/**
	 * This method returns the vehicle's registration number.
	 * 
	 * @return The vehicle's {@code RegistrationNumber} object.
	 */
	public RegistrationNumber getRegistrationNumber();

	/**
	 * This method returns the capacity of the vehicle's fuel tank in whole
	 * Litres.
	 * 
	 * @return the capacity of the vehicle's fuel tank in whole Litres.
	 */
	public int getTotalFuelCapacity();

	/**
	 * This method returns the current capacity of the vehicle's fuel tank in
	 * whole Litres.
	 * 
	 * @return the current capacity of the vehicle's fuel tank in whole Litres.
	 */
	public int getCurrentFuelCapacity();

	/**
	 * This method indicates whether the vehicle's fuel tank is full or not.
	 * 
	 * @return {@code true}, if the vehicle's fuel tank is full or
	 *         <p>
	 *         {@code false}, if not. </>
	 */
	public boolean isTankFull();

	/**
	 * This method, given a number of whole Litres, will add that number to the
	 * vehicle's fuel tank (up to the tank's capacity), and indicates how much
	 * fuel was added to the tank.
	 * 
	 * @param fuel
	 *            The amount of fuel in whole Litres to add to the fuel tank.
	 *            Using a negative value will result in removing fuel from the
	 *            fuel tank.
	 * @return the amount of fuel in whole Litres that was added.
	 */
	public int addFuel(int fuel);

	/**
	 * This method is used to "drive" the vehicle for a given a number of whole
	 * Kilometres and then returns the number of whole Litres of fuel consumed
	 * during the journey.
	 * 
	 * @param kilometres
	 *            the number of whole Kilometres that the vehicle has to drive.
	 * @return the amount of whole Litres of fuel consumed during the vehicle's
	 *         journey. If for some reason the vehicle can't be driven, this
	 *         method returns 0.
	 */
	public int drive(int kilometres);

	/**
	 * This method returns the vehicle's "type", which is a {@code String}
	 * representation of that specific vehicle.
	 * 
	 * @return the vehicle type.
	 */
	public String getType();

	/**
	 * This method returns whether the vehicle is active or not. Only vehicle's
	 * that are active can be rented.
	 * 
	 * @return {@code true} if a vehicle is active, or
	 *         <p>
	 *         {@code false} if a vehicle is deactivated.
	 *         </p>
	 */
	public boolean isActive();

	/**
	 * This method overrides the {@code toString()} method in {@code Object}.
	 * <p>
	 * This method is used to provide a unique string representation of the
	 * vehicle. A simple way to do that is to return the vehicle type, followed
	 * by the string representation of the vehicle's registration number:
	 * <ul>
	 * <li>{@code getType() + "_" + getRegistrationNumber().toString()}</li>
	 * </ul>
	 * </p>
	 * 
	 * @return a unique string representation of the vehicle.
	 */
	public String toString();

}
