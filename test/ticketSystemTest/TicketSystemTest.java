package ticketSystemTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ticketSystem.TicketSystem;
import ticketSystem.TicketWriter;
import ticketSystem.User;

public class TicketSystemTest {
	private TicketSystem ticketSystem;

	@Before
	public void init() {
		ticketSystem = new TicketSystem();
	}

	@Test
	public void dataPopulationTest() {
		assertEquals("4;4;4", ticketSystem.mapSizes());
	}

	@Test
	public void ticketWriterTest() {
		TicketWriter.writeTicket(TicketSystem.getUserById("U-000001"), TicketSystem.getEventById("RUN-00001"));
	}
	
	@Test
	public void premiumQueueTest(){
		User premiumUser = new User("Dary", "Schaeken", "08/08/1996");
		premiumUser.setPremium(true);
		ticketSystem.addUser(premiumUser);
		ticketSystem.requestTicket(TicketSystem.getEventById("RUN-00001"), TicketSystem.getUserById("U-000001"));
		ticketSystem.requestTicket(TicketSystem.getEventById("RUN-00001"), TicketSystem.getUserById("U-000005"));
		assertEquals(premiumUser, ticketSystem.viewNext("RUN-00001"));
	}

}
