package ticketSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
	private String name;
	private String firstName;
	private LocalDate birthDate;
	private String id;
	private static int idNumberGenerator = 1;
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	

	public User(String firstName, String name, String birthDate) {
		setFirstName(firstName);
		setName(name);
		setBirthDate(birthDate);
		id = generateId();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = LocalDate.parse(birthDate, DATE_FORMAT);
	}

	public String getId() {
		return id;
	}

	private static String generateId(){
		StringBuilder returnString = new StringBuilder("U-" + idNumberGenerator);
		while(returnString.length() < 8){
			returnString.insert(2, '0');
		}
		idNumberGenerator++;
		return  returnString.toString();
	}

}
