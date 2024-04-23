package part02;

import java.awt.Color;
import java.awt.Font;

import console.Console;
import part01.*;

/**
 * This class represents:
 * 
 * @author Michael Herron (40403863)
 * @version V1.0
 */

public class QUBMediaImages {

	private static boolean menuLoop = true; // loop for the main menu
	private static Console con = new Console(true); // console instance
	private static ImageAlbum album = new ImageAlbum();
	private static ImageManager manager = new ImageManager(con, album); // image manager instance

	private static Font titleFont = new Font("Arial Black", Font.BOLD, 50); // font and size for the titles
	private static Font baseFont = new Font("Arial", Font.BOLD, 25); // font and size for the rest of the text

	public static void main(String[] args) {
		basePhotos(); // loading the base photos into the manager

		con.setSize(1280, 720); // setting the size of the console
		con.setBgColour(Color.BLACK); // console background colour to black
		con.setVisible(true); // making the console visible on the screen

		while (menuLoop) {
			mainMenu();
		}
	}

	/**
	 * Runs main menu screen and runs whichever option the user inputs
	 */ 
	public static void mainMenu() {
		con.setColour(Color.yellow);
		con.setFont(titleFont);
		con.println(" QUB Photography\n~~~~~~~~~~~~~~~~"); // title text
		con.setColour(Color.white);
		con.setFont(baseFont); // regular text
		con.println("What would you like to do?: ");
		con.println();
		con.setColour(Color.pink);
		con.println("1. Add image");
		con.println("2. Search");
		con.println("3. Display All");
		con.println("4. Exit");
		con.println();
		con.print("Enter choice: ");
		int choice = Integer.valueOf(con.readLn()); // user choice
		con.clear(); // clearing the menu screen
		con.setColour(Color.yellow);
		con.setFont(titleFont); // setting the font to title for the next screen
		switch (choice) {
		case 1:
			addImage();
			break;
		case 2:
			search();
			break;
		case 3:
			displayAll();
			break;
		case 4:
			exit();
			break;
		}

	}

	/**
	 * Prompts user for details of an image and adds it to the image manager
	 */
	public static void addImage() {
		con.println(" Add Image\n~~~~~~~~~~");
		con.setColour(Color.white);
		con.setFont(baseFont);
		con.print("Title: ");
		String title = con.readLn(); // title input
		con.print("Description: ");
		String description = con.readLn(); // description input
		ImageType type = typeInput();
		String date[] = dateInput();
		int day = Integer.valueOf(date[0]); // day int (1-31)
		int month = Integer.valueOf(date[1]); // month int (1-12)
		int year = Integer.valueOf(date[2]); // year int

		con.print("Thumbnail: ");
		String thumbnail = con.readLn(); // thumbail file name input

		manager.add(new ImageRecord(title, description, type, day, month, year, thumbnail)); // adding image to album
		con.setColour(Color.white);
		con.println("To return to menu, press enter");
		con.readLn(); // stay until user specofoes
		con.clear();
	}

	/**
	 * Shows the search menu allowing the user to choose what they search by
	 * Runs whichever method the user selects
	 */
	public static void search() {
		con.println(" Search\n~~~~~~~");
		con.setColour(Color.white);
		con.setFont(baseFont);
		con.println("What would you like to search?: ");
		con.println();
		con.setColour(Color.pink);
		con.println("1. Record ID");
		con.println("2. Title");
		con.println("3. Description");
		con.println("4. Image ImageType");
		con.println("5. Date Range");
		con.println();
		con.print("Enter choice: ");
		int choice = Integer.valueOf(con.readLn()); // user choice
		con.clear();
		con.setColour(Color.yellow);
		con.setFont(titleFont);
		switch (choice) {
		case 1:
			searchID();
			break;
		case 2:
			searchTitle();
			break;
		case 3:
			searchDescription();
			break;
		case 4:
			searchImageType();
			break;
		case 5:
			searchDateRange();
			break;

		}
	}

	/**
	 * Prompts id input and returns matching records
	 */
	public static void searchID() {
		con.println(" ID Search\n~~~~~~~~~~~");
		con.setColour(Color.white);
		con.setFont(baseFont);
		con.print("Enter ID: ");
		int ID = Integer.valueOf(con.readLn()); // id to search
		con.println();
		manager.searchId(ID); // searches id entered and outputs images to console
		con.setColour(Color.white);
		con.println("To return to menu, press enter");
		con.readLn();
		con.clear();
	}

	/**
	 * Prompts title input and returns matching records
	 */
	public static void searchTitle() {
		con.println(" Title Search\n~~~~~~~~~~~");
		con.setColour(Color.white);
		con.setFont(baseFont);
		con.print("Enter Title: ");
		String title = con.readLn(); // title to search
		con.println();
		manager.searchTitle(title); // searches title entered and outputs images to console
		con.setColour(Color.white);
		con.println("To return to menu, press enter");
		con.readLn();
		con.clear();
	}

	/**
	 * Prompts description input and returns matching records
	 */
	public static void searchDescription() {
		con.println(" Description Search\n~~~~~~~~~~~~~~~~~~~~~");
		con.setColour(Color.white);
		con.setFont(baseFont);
		con.print("Enter Description: ");
		String description = con.readLn(); // description to search
		con.println();
		manager.searchDescription(description); // searches description entered and outputs images to console
		con.setColour(Color.white);
		con.println("To return to menu, press enter");
		con.readLn();
		con.clear();
	}

	/**
	 * Prompts image type input and returns matching records
	 */
	public static void searchImageType() {
		con.println(" Image ImageType Search\n~~~~~~~~~~~");
		con.setColour(Color.white);
		con.setFont(baseFont);
		ImageType type = typeInput(); // type to search
		con.println();
		manager.searchGenre(type); // searches type entered and outputs images to console
		con.setColour(Color.white);
		con.println("To return to menu, press enter");
		con.readLn();
		con.clear();
	}

	/**
	 * Prompts two date inputs and returns matching records
	 */
	public static void searchDateRange() {
		con.println(" Date Range Search\n~~~~~~~~~~~~~~~~~~~~~~");
		con.setColour(Color.white);
		con.setFont(baseFont);
		con.print("Enter date: ");
		String dateOne[] = dateInput(); // lower bound date array
		con.print("Enter Another Date: ");
		String dateTwo[] = dateInput(); // upper bound date array
		con.println();
		manager.searchByDateRange(dateOne, dateTwo); // searches date range entered and outputs images to console
		con.setColour(Color.white);
		con.println("To return to menu, press enter");
		con.readLn();
		con.clear();
	}

	/**
	 * returns all records in the manager
	 */
	public static void displayAll() {
		con.println("Display All\n~~~~~~~~~~~~~~");
		con.setColour(Color.white);
		con.setFont(baseFont);
		manager.displayAll();
		con.println();
		con.println("To return to menu, press enter");
		con.readLn();
		con.clear();
	}

	/**
	 * stops the loop
	 */
	public static void exit() {
		menuLoop = false;
		con.setVisible(false);
	}

	/**
	 * Allows the user to input image types and validates their existence
	 * @return the value of the image type input (if it exists)
	 */
	public static ImageType typeInput() {
		ImageType types[] = ImageType.values(); // array of all type names
		ImageType type = null; // type input instantiation
		while (true) {
			con.print("ImageType: ");
			String typeInput = con.readLn().toUpperCase(); // text input for type
			for (int i = 0; i < types.length; i++) {
				if (types[i].name().equals(typeInput)) { // if the type exists
					type = ImageType.valueOf(typeInput);
					return type;
				}
			}
			if (type == null) {
				con.setColour(Color.red);
				con.println("Our system does not have that type! Please try again.");
				con.setColour(Color.white);
			}
		}
	}

	/**
	 * Asks the user to input a date and splits this into day month and year
	 * @return array of [day, month, year]
	 */
	public static String[] dateInput() {
		String dmy[] = null; // array to split day month and year
		while (true) {
			con.println("Date Taken (dd-mm-yyyy): ");
			String date = con.readLn(); // date input
			dmy = date.split("-"); // date split
			if (Integer.valueOf(dmy[0]) >= 1 && Integer.valueOf(dmy[0]) <= 31 && Integer.valueOf(dmy[1]) >= 1
					&& Integer.valueOf(dmy[1]) <= 12) {
				return dmy;
			} else {
				con.setColour(Color.red);
				con.println("That is not a valid date. Please try again.");
				con.setColour(Color.white);
			}
		}
	}

	/**
	 * loads the manager with a range of images of various types
	 */
	public static void basePhotos() {
		manager.add(new ImageRecord("La Sagrada Familia", "Large building located in Barcelona", ImageType.ARCHITECTURE, 17,
				4, 2016, "SagradaFamilia.jpg")); // record for la sangrada familia
		manager.add(new ImageRecord("Mount Errigal", "The Mountain Errigal located in County Donegal, Ireland",
				ImageType.LANDSCAPE, 25, 8, 2021, "Errigal.jpg")); // record for errigal
		manager.add(new ImageRecord("Forest", "A beautiful forest clearing", ImageType.NATURE, 9, 10, 2012, "Forest.jpg")); // record for forest
		manager.add(new ImageRecord("Ice Cream", "A delicious selection of ice cream", ImageType.FOOD, 31, 1, 2024,
				"IceCream.jpg")); // record for ice cream
		manager.add(new ImageRecord("The Night Sky", "A picture taken of the stars at night", ImageType.ASTRONOMY, 14, 12,
				2022, "NightSky.jpg")); // record for the night sky
		manager.add(new ImageRecord("Onion Skin", "Microscopic picture of the epidermis of an onion", ImageType.OTHER, 16,
				5, 2020, "OnionSkin.jpg")); // record for onion skin
		manager.add(new ImageRecord("Sir Patrick Stewart", "Headshot of Sir Patrick Stewart", ImageType.PORTRAIT, 21, 6,
				2021, "PatrickStewart.jpg")); // record for patrick stewart
		manager.add(new ImageRecord("Sailboat", "An action shot of 2 men sailing a dinghy in a race", ImageType.SPORT, 30,
				7, 2019, "Sailing.jpg")); // record for sailboat
		manager.add(new ImageRecord("The Shore", "Birds eye photograph of a rocky shore", ImageType.AERIAL, 23, 2, 2002,
				"Shoreline.png")); // record for the shore
		manager.add(new ImageRecord("Yellow Tulips", "A collection of yellow tulips in a field", ImageType.NATURE, 10, 10,
				2023, "Tulips.jpg")); // record for tulips
	}
}
