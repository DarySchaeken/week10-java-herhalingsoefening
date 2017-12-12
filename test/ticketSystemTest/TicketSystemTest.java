package ticketSystemTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ticketSystem.TicketSystem;

public class TicketSystemTest {
	private TicketSystem ticketSystem;
	
	@Before
	public void init(){
		ticketSystem = new TicketSystem();
	}
	
	@Test
	public void dataPopulationTest(){
		assertEquals("4;4;4",ticketSystem.mapSizes());
	}
	
	
}
