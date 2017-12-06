package ticketSystem;

import java.util.HashMap;

public class TicketSystem {
	private QueueService queueService;
	private static HashMap<String, User> users;
	private static HashMap<String, Venue> venues;
	private static HashMap<String, Event> events;
	
	public TicketSystem() {
		queueService = new QueueService();
		users = new HashMap<>();
		venues = new HashMap<>();
		events = new HashMap<>();
	}
	
	public void requestTicket(Event event, User user){
		queueService.addToQueue(event.getId(), user.getId());
	}
	
	public void viewNext(String eventId){
		System.out.println(queueService.getNextInLine(eventId));
	}

	public void addUser(User user){
		users.put(user.getId(), user);
	}
	
	public void addVenue(Venue venue){
		venues.put(venue.getId(), venue);
	}
	
	public void addEvent(Event event){
		events.put(event.getId(), event);
	}
	
	public static User getUserById(String id){
		return users.get(id);
	}
	
	public static Event getEventById(String id){
		return events.get(id);
	}
	
	public static Venue getVenueById(String id){
		return venues.get(id);
	}
	

}
