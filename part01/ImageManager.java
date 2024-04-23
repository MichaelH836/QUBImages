package part01;

import javax.swing.ImageIcon;

import console.Console;

/**
 * This class represents:
 * 
 * @author Michael Herron (40403863)
 * @version V1.0
 */

public class ImageManager {

	private ImageAlbum album; // image album for each instance of an image manager
	private Console console;
	/**
	 * Constructor for the class
	 */
	public ImageManager(ImageAlbum album) {
		this.album = album;
		this.console = null;
	}
	
	/**
	 * Constructor with console
	 */
	public ImageManager(Console console, ImageAlbum album) {
		this.album = album;
		this.console = console;
	}
	/**
	 * adds a new image record to the album
	 * @param record - the record being added
	 */
	public void add(ImageRecord record) {
		this.album.addRecord(record);
	}
	
	/**
	 * prints a record from the album
	 * @param record
	 */
	public void print(ImageRecord record) {
		if (this.console != null) {
			console.print(record); // printing the data of the record
			String userdir = System.getProperty("user.dir"); // specifying user directory
			String path = userdir + "/Images/" + record.getThumbnail(); // specifying location
			ImageIcon image = new ImageIcon(path); // creating image to print
			console.print(image); // printing image
			console.println();
			console.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			console.println();
		} else {
			System.out.println(record);
		}
	}
	/**
	 * displays each record that exists in the album
	 */
	public void displayAll() {
		if (this.album.getRecords().size() > 0) {
			for (ImageRecord record : this.album.getRecords()) {
				this.print(record);
			}
		}
	}

	/**
	 * returns the record with the unique id entered
	 * @param ID - id being search
	 */
	public void searchId(int ID) {
		for (ImageRecord record : this.album.getRecords()) {
			if (record.getID() == ID) {
				this.print(record);
			}
		}
	}

	/**
	 * returns any record with the title entered
	 * @param title - title being searched
	 */
	public void searchTitle(String title) {
		for (ImageRecord record : this.album.getRecords()) {
			if (record.getTitle().equals(title)) {
				this.print(record);
			}
		}
	}

	/**
	 * returns any record with the description entered
	 * @param description - description being search
	 */
	public void searchDescription(String description) {
		for (ImageRecord record : this.album.getRecords()) {
			if (record.getDescription().equals(description)) {
				this.print(record);
			}
		}
	}

	/**
	 * returns any record of a certain type
	 * @param type - the type being searched
	 */
	public void searchGenre(ImageType type) {
		for (ImageRecord record : this.album.getRecords()) {
			if (record.getType().equals(type)) {
				this.print(record);
			}
			
		}
	}
	
	/**
	 * returns any record in which the date lies between the two dates entered
	 * @param dateOne - lower bound date
	 * @param dateTwo - upper bound date
	 */
	public void searchByDateRange(String dateOne[], String dateTwo[]) {
		int yearOne = Integer.valueOf(dateOne[2]); // value of the first year
		int yearTwo = Integer.valueOf(dateTwo[2]); // value of the second year
		int monthOne = Integer.valueOf(dateOne[1]); // value of the first month
		int monthTwo = Integer.valueOf(dateTwo[1]); // value of the second month
		int dayOne = Integer.valueOf(dateOne[0]); // value of the first day
		int dayTwo = Integer.valueOf(dateTwo[0]); // value of the second day
		
		for (ImageRecord record : this.album.getRecords()) {
			int recordYear = Integer.valueOf(record.getDate().getYear()); // value of the record year
			int recordMonth = Integer.valueOf(record.getDate().getMonth()); // value of the record month
			int recordDay = Integer.valueOf(record.getDate().getDay()); // value of the record day

			if (recordYear > yearOne && recordYear < yearTwo) {
				this.print(record);
			} else if (recordYear == yearOne) {
				if ((recordMonth > monthOne) || (recordMonth == monthOne && recordDay >= dayOne)) {
					this.print(record);
				}
			} else if (recordYear == yearTwo) {
				if ((recordMonth < monthTwo) || (recordMonth == monthTwo && recordDay <= dayTwo)) {
					this.print(record);
				}
			}
		}
	}
}
