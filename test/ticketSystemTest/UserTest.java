package ticketSystemTest;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import ticketSystem.User;

public class UserTest {
	private User test;
	private User test2;
	
	@Before
	public void init(){
		test = new User("Test","Test","01/01/2001");
		test2 = new User("Test2","Test2","02/02/2002");
	}
	
	@Test
	public void idGeneratorTest() {
		assertEquals("U-000001", test.getId());
		assertEquals("U-000002", test2.getId());	
	}
	
	@Test
	public void dateInputTest(){
		assertEquals(LocalDate.of(2001, 01, 01), test.getBirthDate());
		assertEquals(LocalDate.of(2002, 02, 02), test2.getBirthDate());
	}

}
