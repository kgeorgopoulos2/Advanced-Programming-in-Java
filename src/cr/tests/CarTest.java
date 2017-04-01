package cr.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import cr.cars.DefaultCarRegistrationNumber;
import cr.cars.Drivable;
import cr.cars.SmallCar;
import cr.system.DefaultCarRentalApplication;

public class CarTest extends MyTest {

	private DefaultCarRentalApplication application = new DefaultCarRentalApplication();

	@Test
	public void testCantDrive() {
		DefaultCarRegistrationNumber registrationNumber;
		registrationNumber = createRegistrationNumber("NG57 HXE");
		SmallCar car = (SmallCar) application.createCar("small", registrationNumber);
		int kilometres = 100;
		// set car as rented, but have no fuel in the fuel tank.
		car.deactivate();
		assertEquals(0, car.drive(kilometres));

		// set car as available to rent, add fuel to fuel tank.
		car.addFuel(49);
		car.activate();
		assertEquals(0, car.drive(kilometres));

		// set car as rented and then remove all fuel.
		car.deactivate();
		car.addFuel(-49);
		assertEquals(0, car.drive(kilometres));
	}

	@Test
	public void testCanDrive() {
		DefaultCarRegistrationNumber registrationNumber;
		registrationNumber = createRegistrationNumber("NG58 HXE");
		SmallCar car = (SmallCar) application.createCar("small", registrationNumber);
		int kilometres = 100;
		// set car as rented, add fuel to tank.
		car.addFuel(5);
		car.deactivate();
		int fuelConsumed = car.drive(kilometres);
		assertNotEquals(0, fuelConsumed);
		assertEquals(5, fuelConsumed);
	}

	@Test
	public void testCorrectStringRepresentation() {
		DefaultCarRegistrationNumber registrationNumber;
		registrationNumber = createRegistrationNumber("NG59 HXE");
		Drivable car = application.createCar("large", registrationNumber);

		assertEquals("large_NG59 HXE", car.toString());
	}

	@Test
	public void testWrongStringRepresentation() {
		DefaultCarRegistrationNumber registrationNumber;
		registrationNumber = createRegistrationNumber("NG60 HXE");
		Drivable car = application.createCar("small", registrationNumber);

		assertNotEquals("small-NG60 HXE", car.toString());
	}

	@Test
	public void testFullTank() {
		DefaultCarRegistrationNumber registrationNumber;
		registrationNumber = createRegistrationNumber("NG61 HXE");
		Drivable car = application.createCar("small", registrationNumber);

		car.addFuel(49);
		assertEquals(true, car.isTankFull());
	}

	@Test
	public void testNotFullTank() {
		DefaultCarRegistrationNumber registrationNumber;
		registrationNumber = createRegistrationNumber("NG62 HXE");
		Drivable car = application.createCar("small", registrationNumber);

		assertEquals(false, car.isTankFull());
		car.addFuel(48);
		assertEquals(false, car.isTankFull());
	}

	@Test
	public void testAddFuel() {
		DefaultCarRegistrationNumber registrationNumber;
		registrationNumber = createRegistrationNumber("NG63 HXE");
		SmallCar car = (SmallCar) application.createCar("small", registrationNumber);

		int addedFuel = car.addFuel(50);
		assertEquals(addedFuel, car.getTotalFuelCapacity());
		car.deactivate();
		car.drive(100);
		addedFuel = car.addFuel(1);
		assertEquals(45, car.getCurrentFuelCapacity());
	}

	@Test
	public void testCurrentTankCapacity() {
		DefaultCarRegistrationNumber registrationNumber;
		registrationNumber = createRegistrationNumber("NG64 HXE");
		SmallCar car = (SmallCar) application.createCar("small", registrationNumber);
		int kilometres = 100;
		// set car as rented, don't add fuel to tank, get current fuel tank
		// capacity.
		car.addFuel(0);
		car.deactivate();
		car.drive(kilometres);
		assertEquals(0, car.getCurrentFuelCapacity());
		// Add 1 Litre of fuel, then drive and consume 5 Litres. There should be
		// -4 remaining fuel.
		car.addFuel(1);
		car.drive(kilometres);
		assertEquals(-4, car.getCurrentFuelCapacity());

	}

}
