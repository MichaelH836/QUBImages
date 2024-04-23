package part01;

/**
 * This class represents:
 * @author Michael Herron (40403863)
 * @version V1.0
 */

public enum ImageType {
	ASTRONOMY("Astronomy", "Photograpy or imagin of astronomical objects, celestial events, or areas of the night sky."),
	ARCHITECTURE("Architecture","Focuses on the capture of images that accurately represent the design and feel of buildings."),
	SPORT("Sport","Covers all types of sports and can be considered a branch of photojournalism."),
	LANDSCAPE("Landscape","The study of the textured surface of the Earth and features images of natural scenes."),
	PORTRAIT("Portrait","Images of a person or a group of people where the face and facial features are predominant."),
	NATURE("Nature","Focused on elements of the outdoors including sky, water, and land, or the flora and fauna."),
	AERIAL("Aerial","Images taken from an aircraft or other airborne platforms."),
	FOOD("Food","Captures everything related to food, from fresh ingredients and plated dishes to the cooking process."),
	OTHER("Other","Covers just about any other type of image and photography type.");

	private String name; // the name of the type (eg. astronomy)
	private String description; // the description of the type
	
	/**
	 * Constructor for the class
	 * @param name
	 * @param description
	 */
	private ImageType(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	/**
	 * @return - the description for the type
	 */
	public String toString() {
		return this.description;
	}
	
}
