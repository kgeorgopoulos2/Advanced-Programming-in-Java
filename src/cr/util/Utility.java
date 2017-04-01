package cr.util;

import java.util.Calendar;
import java.util.Date;

/**
 * This class provides helpful utility methods.
 */
public class Utility {

	/**
	 * This method calculates the years passed between the given date and the
	 * current date.
	 * 
	 * @param startDate
	 *            The start date.
	 * @return The years passed.
	 */
	public static int calculateAge(Date startDate) {
		int age = 0;
		int ageDelta = 0;
		int monthDelta = 0;
		int dayDelta = 0;
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();

		ageDelta = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		monthDelta = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
		dayDelta = end.get(Calendar.DATE) - start.get(Calendar.DATE);

		if (monthDelta < 0) {
			age = ageDelta - 1;
		} else if (monthDelta == 0) {
			if (dayDelta < 0) {
				age = ageDelta - 1;
			} else {
				age = ageDelta;
			}
		} else {
			age = ageDelta;
		}
		return age;
	}

}
