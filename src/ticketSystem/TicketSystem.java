package ticketSystem;

import java.time.LocalDate;
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

	public void requestTicket(Event event, User user) {
		queueService.addToQueue(event.getId(), user.getId());
	}

	public void viewNext(String eventId) {
		System.out.println(queueService.getNextInLine(eventId));
	}

	public void addUser(User user) {
		users.put(user.getId(), user);
	}

	public void addVenue(Venue venue) {
		venues.put(venue.getId(), venue);
	}

	public void addEvent(Event event) {
		events.put(event.getId(), event);
	}

	public void filterEventsOnName(String name) {
		events.values().stream().filter(e -> e.getName().equals(name)).forEach(System.out::println);
	}

	public void filterFullEvents() {
		events.values().stream().filter(e -> e.isFull()).forEach(System.out::println);
	}

	public void filterQueuesOnUser(String userID) {
		User user = getUserById(userID);
		queueService.filterQueuesOnUser(user);
	}

	public void filterEventsOnUser(String userID) {
		User user = getUserById(userID);
		events.values().stream().filter(e -> e.getTicketHolders().contains(user)).map(e -> e.getId())
				.forEach(System.out::println);
	}

	public void filterLocationsOnEventsWithinWeek() {
		events.values().stream()
				.filter(e -> e.getEventDate().isAfter(LocalDate.now())
						&& e.getEventDate().isBefore(LocalDate.now().plusDays(7)))
				.map(e -> e.getVenue().getId()).forEach(System.out::println);
	}
	
	public void assignTickets(String eventId, int amount){
		for(int i = 0; i < amount; i++){
			User user = queueService.getNextInLine(eventId);
			if(user != null){
				events.get(eventId).addTicketHolder(user);
			} else {
				queueService.removeQueue(eventId);
			}
		}
	}

	public static User getUserById(String id) {
		return users.get(id);
	}

	public static Event getEventById(String id) {
		return events.get(id);
	}

	public static Venue getVenueById(String id) {
		return venues.get(id);
	}

}
