package ticketSystem;

public class UserMapper implements Mapper<User> {

	@Override
	public User map(String[] dataInput) {
		String id = dataInput[0];
		String name = dataInput[1];
		String firstName = dataInput[2];
		StringBuilder birthDate = new StringBuilder(dataInput[3]);
		birthDate.insert(4, '/');
		birthDate.insert(2, '/');
		
		return new User(id, firstName, name, birthDate.toString());
	}
	
}
