package part01;

/**
 * This class represents:
 * @author Michael Herron (40403863)
 * @version V1.0
 */

public class ImageRecord {
	
	private static int nextID; // class variable for the next available id
	private int ID; // record ID
	private String title; // record title
	private String description; // record description
	private ImageType type; // record type
	private Date date; // record date
	private String thumbnailFile; // record thumbnail file
	
	/**
	 * Constructor for the class
	 * @param title - record title
	 * @param description - record description
	 * @param type - record type
	 * @param day - record date day
	 * @param month - record date month
	 * @param year - record date year
	 * @param thumbnailFile - record thumbnail file
	 */
	public ImageRecord(String title, String description, ImageType type, int day, int month, int year, String thumbnailFile) {
		this.title = title;
		this.description = description;
		this.type = type;
		this.date = new Date(day, month, year);
		this.thumbnailFile = thumbnailFile;
		this.ID = nextID;
		nextID++;
	}
	
	/**
	 * @return - ID
	 */
	public int getID() {
		return this.ID;
	}
	
	/**
	 * @return - title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * @return - description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * @return - type
	 */
	public ImageType getType() {
		return this.type;
	}
	
	/**
	 * @return - date
	 */
	public Date getDate() {
		return this.date;
	}
	
	/**
	 * @return - thumbnail file
	 */
	public String getThumbnail() {
		return this.thumbnailFile;
	}
	
	/**
	 * @return - string with a new line for each value and the names of each value
	 */
	public String toString() {
		return "ID: " + this.ID + "\nTitle: " + this.title + "\nDescription: " + this.description + "\nGenre: " + this.type.name() + "\nGenre Description: " + this.type + "\nDate: " + this.date + "\nThumbnail: " + this.thumbnailFile + "\n";
	}
}
