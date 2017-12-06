package ticketSystem;

public class UserMapper implements Mapper<User> {

	@Override
	public User map(String[] dataInput) {
		StringBuilder birthDate = new StringBuilder(dataInput[3]);
		birthDate.insert(4, '/');
		birthDate.insert(2, '/');
		
		return new User(dataInput[0], dataInput[1], dataInput[2], birthDate.toString());
	}
	
}
