package ticketSystemTest;

import ticketSystem.User;
import ticketSystem.UserMapper;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserMapperTest {

	@Test
	public void UserMappingTest() {
		String start = "U-000001;Vanderstraeten;Sam;03041987";
		UserMapper mapper = new UserMapper();
		User user = mapper.map(start.split(";"));
		assertEquals(new User("U-000001", "Sam","Vanderstraeten" ,"03/04/1987"), user);
		
	}

}
