package part01;

import java.util.ArrayList;

/**
 * This class represents:
 * @author Michael Herron (40403863)
 * @version V1.0
 */

public class ImageAlbum {

	private ArrayList<ImageRecord> records; // list of records in the album
	
	/**
	 * Constructor for the class
	 */
	public ImageAlbum() {
		this.records = new ArrayList<>();
	}
	
	/**
	 * takes record as input and adds it to the list
	 * @param record
	 */
	public void addRecord(ImageRecord record) {
		if (this.records.isEmpty()) {
			this.records.add(record);
		} else {
			for (int i = 0; i < this.records.size(); i++) {
				if (this.records.get(i).getDate().isAfter(record.getDate())) {
					ArrayList<ImageRecord> newRecords = new ArrayList<>();
					if (i > 0) {
						for (int j = 0; j < i; j++) {
							newRecords.add(this.records.get(j));
						}
					}
					newRecords.add(record);
					for (int k = i; k < this.records.size(); k++) {
						newRecords.add(this.records.get(k));
					}
					this.records = newRecords;
					break;
				} else if (i == this.records.size() - 1 && record.getDate().isAfter(this.records.get(i).getDate())){
					this.records.add(record);
					break;
				}
			}
		}
	}
	
	/**
	 * @return - list of all the records in the album
	 */
	public ArrayList<ImageRecord> getRecords() {
		return this.records;
	}
}
