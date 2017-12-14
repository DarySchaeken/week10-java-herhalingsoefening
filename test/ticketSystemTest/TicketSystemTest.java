package ticketSystemTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ticketSystem.TicketSystem;
import ticketSystem.TicketWriter;

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

}
