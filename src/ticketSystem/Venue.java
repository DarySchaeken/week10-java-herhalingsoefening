package ticketSystem;

public class Venue {
	private String name;
	private String street;
	private int houseNumber;
	private int postalCode;
	private String borough;
	private int capacity;
	private String id;
	private static int idGeneratorNumber = 1;

	public Venue(String name, String street, int houseNumber, int postalCode, String borough, int capacity) {
		setBorough(borough);
		setCapacity(capacity);
		setName(name);
		setPostalCode(postalCode);
		setStreet(street);
		id = generateId();
	}
	
	public Venue(String id, String name, String street, int houseNumber,int postalCode, String borough, int capacity) {
		this(name, street, houseNumber ,postalCode, borough, capacity);
		this.id = id;
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

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
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
		/*StringBuilder returnString = new StringBuilder("V-" + idGeneratorNumber);
		while(returnString.length() < 6){
			returnString.insert(2, '0');
		}
		idGeneratorNumber++;*/
		return String.format("V-%05d", idGeneratorNumber++);
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%s", id, name);
	}


}
