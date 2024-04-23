package part01;

/**
 * This class represents:
 * @author Michael Herron (40403863)
 * @version V1.0
 */

public class Date {
	private int day; // day of the date
	private int month; // month of the date
	private int year; // year of the date

	/**
	 * Constructor for the class
	 * @param day
	 * @param month
	 * @param year
	 */
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * if the day is less than 10 (eg. 7) it will return that number to fit the format of dd-mm-yyyy (eg. 07)
	 * @return - the day of the date
	 */
	public String getDay() {
		if (this.day < 10) {
			return "0" + this.day; // matching to format of dd-mm-yyyy
		} else
			return String.valueOf(this.day);
	}
	
	/**
	 * if the month is less than 10 (eg. 4) it will return that number to fit the format of dd-mm-yyyy (eg. 04)
	 * @return - the month of the date
	 */
	public String getMonth() {
		if (this.month < 10) {
			return "0" + this.month; // matching to format of dd-mm-yyyy
		} else
			return String.valueOf(this.month);
	}
	
	/**
	 * @return - the year of the date
	 */
	public String getYear() {
		return String.valueOf(this.year);
	}
	
	public boolean isAfter(Date date) {
		
		if (date.year < this.year) {
			return true;
		} else if (date.year == this.year && date.month < this.month) {
			return true;
		} else if (date.year == this.year && date.month == this.month && date.day < this.day) {
			return true;
		}
		return false;
	}

	/**
	 * @return - the date in the format of dd-mm-yyyy
	 */
	public String toString() {
		return this.getDay() + "-" + this.getMonth() + "-" + this.year; 
	}
}
