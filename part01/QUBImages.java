package part01;

import java.util.Scanner;

/**
 * This class represents:
 * 
 * @author Michael Herron (40403863)
 * @version V1.0
 */

public class QUBImages {

	private static boolean loop = true; // loop until the exit command is executed
	private static ImageAlbum album = new ImageAlbum();
	private static ImageManager manager = new ImageManager(album); // imageManager for the class
	
	private static Scanner scanner  = new Scanner(System.in); // scanner for class

	public static void main(String[] args) {
		basePhotos();
		while (loop) {
			mainMenu();
		}
	}
	
	/**
	 * Runs main menu screen and runs whichever option the user inputs
	 */
	public static void mainMenu() {
		String options[] = new String[4]; // options array for menu class
		options[0] = "Add Image";
		options[1] = "Search";
		options[2] = "Display All";
		options[3] = "Exit";

		Menu mainMenu = new Menu("Main Menu", options); // menu instance for main menu
		int mainMenuChoice = mainMenu.getChoice(); // user's choice
		switch (mainMenuChoice) {
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
		System.out.println("\n+++++++++");
		System.out.println("Add Image");
		System.out.println("+++++++++\n");
		System.out.print("Title: ");
		String title = scanner.nextLine(); // image title
		System.out.print("Description: ");
		String description = scanner.nextLine(); // image description
		System.out.print("Type: ");
		ImageType type = typeInput(); // image type
		String dmy[] = dateInput(); // array to split the date into day month and year
		System.out.print("Thumbnail: ");
		String thumbnail = scanner.nextLine(); // image thumbnail file
		System.out.println();

		int day = Integer.valueOf(dmy[0]); // converting day to an integer
		int month = Integer.valueOf(dmy[1]); // converting month to an integer
		int year = Integer.valueOf(dmy[2]); // converting year to an integer

		ImageRecord newRecord = new ImageRecord(title, description, type, day, month, year, thumbnail); // creating record to add to the manager
		manager.add(newRecord);
	}

	/**
	 * Shows the search menu allowing the user to choose what they search by
	 * Runs whichever method the user selects
	 */
	public static void search() {
		String searchOptions[] = new String[5]; // options array for search class
		searchOptions[0] = "Record ID";
		searchOptions[1] = "Title";
		searchOptions[2] = "Description";
		searchOptions[3] = "Type";
		searchOptions[4] = "Date Range";

		Menu searchMenu = new Menu("Search", searchOptions); // menu instance for search
		System.out.println("Search By:");
		int searchChoice = searchMenu.getChoice(); // user's choice
		switch (searchChoice) {
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
		default:
			System.out.println("That is not a valid option!");
		}
	}

	/**
	 * Prompts id input and returns matching records
	 */
	public static void searchID() {
		System.out.print("Enter ID: ");
		int ID = Integer.valueOf(scanner.nextLine()); // id input
		System.out.println();
		manager.searchId(ID);
	}

	/**
	 * Prompts title input and returns matching records
	 */
	public static void searchTitle() {
		System.out.print("Enter Title: ");
		String title = scanner.nextLine(); // title input
		System.out.println();
		manager.searchTitle(title);
	}

	/**
	 * Prompts description input and returns matching records
	 */
	public static void searchDescription() {
		System.out.print("Enter Description: ");
		String description = scanner.nextLine(); //description input
		System.out.println();
		manager.searchDescription(description);
	}

	/**
	 * Prompts type input and returns matching records
	 */
	public static void searchImageType() {
		System.out.print("Enter Type: ");
		String type = scanner.nextLine(); // type input
		System.out.println();
		manager.searchGenre(ImageType.valueOf(type.toUpperCase()));
	}

	/**
	 * Prompts two date inputs and returns matching records
	 */
	public static void searchDateRange() {
		System.out.print("Input a Date: ");
		String dateOne[] = dateInput(); // lower bound input
		System.out.print("Input another Date: ");
		String dateTwo[] = dateInput(); // upper bound input
		System.out.println();
		manager.searchByDateRange(dateOne, dateTwo);
	}

	/**
	 * returns all records in the manager
	 */
	public static void displayAll() {
		System.out.println("\n+++++++++++");
		System.out.println("Display All");
		System.out.println("+++++++++++\n");
		manager.displayAll();
	}

	/**
	 * stops the loop
	 */
	public static void exit() {
		loop = false;
		System.out.println("\n++++++++");
		System.out.println("Goodbye!");
		System.out.println("++++++++\n");
	}
	
	/**
	 * Allows the user to input image types and validates their existence
	 * @return the value of the image type input (if it exists)
	 */
	public static ImageType typeInput() {
		ImageType types[] = ImageType.values(); // array of all type names
		ImageType type = null; // type input instantiation
		while (true) {
			System.out.print("Type: ");
			String typeInput = scanner.nextLine().toUpperCase(); // text input for type
			for (int i = 0; i < types.length; i++) {
				if (types[i].name().equals(typeInput)) { // if the type exists
					return ImageType.valueOf(typeInput);
				}
			}
			if (type == null) {
				System.out.println("Our system does not have that type! Please try again.");
			}
		}
	}
	
	/**
	 * Asks the user to input a date and splits this into day month and year
	 * @return array of [day, month, year]
	 */
	public static String[] dateInput() {
		while (true) {
			System.out.print("Date Taken (dd-mm-yyyy): ");
			String date = scanner.nextLine(); // image date
			 String dmy[] = date.split("-"); // splitting string between the '-'
			if (Integer.valueOf(dmy[0]) >= 1 && Integer.valueOf(dmy[0]) <= 31 && Integer.valueOf(dmy[1]) >= 1
					&& Integer.valueOf(dmy[1]) <= 12) { // validation
				return dmy;
			} else {
				System.out.println("That is not a valid date. Please Try again.");
			}
		}
	}

	/**
	 * loads the manager with a range of images of various types
	 */
	public static void basePhotos() {
		manager.add(new ImageRecord("La Sangrada Familia", "Large building located in Barcelona",
				ImageType.ARCHITECTURE, 17, 4, 2016, "SangradaFamilia.jpg")); // record for la sangrada familia
		manager.add(new ImageRecord("Mount Errigal",
				"The Mountain Errigal located in County Donegal, Ireland", ImageType.LANDSCAPE, 25, 8, 2021, "Errigal.jpg")); // record for errigal
		manager.add(new ImageRecord("Forest", "A beautiful forest clearing", ImageType.NATURE, 9, 10, 2012,
				"Forest.jpg")); // record for forest
		manager.add(new ImageRecord("Ice Cream", "A delicious selection of ice cream", ImageType.FOOD, 31, 1, 2024,
				"IceCream.jpg")); // record for ice cream
		manager.add(new ImageRecord("The Night Sky", "A picture taken of the stars at night", ImageType.ASTRONOMY,
				14, 12, 2022, "NightSky.jpg")); // record for the night sky
		manager.add(new ImageRecord("Onion Skin", "Microscopic picture of the epidermis of an onion",
				ImageType.OTHER, 16, 5, 2020, "OnionSkin.jpg")); // record for onion skin
		manager.add(new ImageRecord("Sir Patrick Stewart", "Headshot of Sir Patrick Stewart", ImageType.PORTRAIT,
				21, 6, 2021, "PatrickStewart.jpg")); // record for patrick stewart
		manager.add(new ImageRecord("Sailboat", "An action shot of 2 men sailing a dinghy in a race",
				ImageType.SPORT, 30, 7, 2019, "Sailing.jpg")); // record for sailboat
		manager.add(new ImageRecord("The Shore", "Birds eye photograph of a rocky shore", ImageType.AERIAL, 23, 2,
				2002, "Shoreline.png")); // record for the shore
		manager.add(new ImageRecord("Yellow Tulips", "A collection of yellow tulips in a field",
				ImageType.NATURE, 10, 10, 2023, "Tulips.jpg")); // record for tulips

	}
}
