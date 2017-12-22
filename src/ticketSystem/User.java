package ticketSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
	private String name;
	private String firstName;
	private LocalDate birthDate;
	private String id;
	private boolean premium;

	private static int idNumberGenerator = 1;
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	

	public User(String firstName, String name, String birthDate) {
		setFirstName(firstName);
		setName(name);
		setBirthDate(birthDate);
		id = generateId();
	}
	
	public User(String id, String firstName, String name, String birthDate) {
		this(firstName, name, birthDate);
		this.id = id;
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

	public String getBirthDate() {
		return birthDate.format(DATE_FORMAT);
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = LocalDate.parse(birthDate, DATE_FORMAT);
	}
	
	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public String getId() {
		return id;
	}

	private static String generateId(){
		/*StringBuilder returnString = new StringBuilder("U-" + idNumberGenerator);
		while(returnString.length() < 8){
			returnString.insert(2, '0');
		}
		idNumberGenerator++;*/
		return  String.format("U-%06d", idNumberGenerator++);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public int compareTo(User user){
		if(this.isPremium() == user.isPremium()){
			return 1;
		} else if( this.isPremium() == true){
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public String toString() {
		return String.format("%s\t%s %s", id, firstName, name);
	}

}
