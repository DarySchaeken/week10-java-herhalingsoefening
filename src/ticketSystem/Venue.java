package ticketSystem;

public class Venue {
	private String name;
	private String street;
	private int postalCode;
	private String borough;
	private int capacity;
	private String id;
	private static int idGeneratorNumber = 1;

	public Venue(String name, String street, int postalCode, String borough, int capacity) {
		setBorough(borough);
		setCapacity(capacity);
		setName(name);
		setPostalCode(postalCode);
		setStreet(street);
		id = generateId();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getBorough() {
		return borough;
	}

	public void setBorough(String borough) {
		this.borough = borough;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getId() {
		return id;
	}

	private String generateId(){
		StringBuilder returnString = new StringBuilder("V-" + idGeneratorNumber);
		while(returnString.length() < 6){
			returnString.insert(2, '0');
		}
		idGeneratorNumber++;
		return returnString.toString();
	}

}
