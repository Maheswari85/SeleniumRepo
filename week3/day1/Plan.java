package week3.day1;

public interface Plan {
	/**
	 * This method gives the overview on the number of bedrooms 
	 * that the house is going to have
	 * @author Maheswari
	 * @param numbers -the no of bedrooms that a house should have.
	 */
	
	public void buildBedRooms (int numbers);
	/**
	 * 
	 * 
	 */
	public void buildBalcony();
	/**
	 * 
	 * 
	 * 
	 */
	public void builParking ();
	int totalsft = 1800;
	String name = "Jasmine Towers ";
	String [] flats = {"F1","F2"};
	public void buildGarden();
}
