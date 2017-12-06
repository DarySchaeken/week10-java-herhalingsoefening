package ticketSystemTest;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import ticketSystem.Event;


public class EventTest {
	private Event test;
	private Event test2;
	
	@Before
	public void init() {
		 test = new Event("Test", "01/01/2001", "19:30", "Test event 1", 12.50);
		 test2 = new Event("Test2", "02/02/2002", "20:00", "Test event 2", 25);
	}
	
	@Test
	public void idGeneratorTest(){
		assertEquals("TES-00001", test.getId());
		assertEquals("TES-00002", test2.getId());
	}
	
	@Test
	public void dateParserTest(){
		assertEquals(LocalDate.of(2001, 01, 01), test.getEventDate());
		assertEquals(LocalDate.of(2002, 02, 02), test2.getEventDate());
	}
	
	@Test
	public void timeParserTest(){
		assertEquals(LocalTime.of(19, 30), test.getStartTime());
		assertEquals(LocalTime.of(20, 00), test2.getStartTime());
	}
}
