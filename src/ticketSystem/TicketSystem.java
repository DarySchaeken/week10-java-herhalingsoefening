package ticketSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		readData();
	}
	
	public String mapSizes(){
		return users.size() + ";" + venues.size() + ";" + events.size();
	}

	public void requestTicket(Event event, User user) {
		queueService.addToQueue(event.getId(), user.getId());
	}

	public User viewNext(String eventId) {
		User user = queueService.getNextInLine(eventId);
		System.out.println(user);
		return user;
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

	public void assignTickets(String eventId, int amount) {
		for (int i = 0; i < amount; i++) {
			User user = queueService.getNextInLine(eventId);
			if (user != null) {
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

	private void readData() {
		readUsers();
		readVenues();
		readEvents();
	}

	private void readUsers() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("userdata.txt"))) {
			String line = null;
			UserMapper userMapper = new UserMapper();
			while ((line = bufferedReader.readLine()) != null) {
				User newUser = userMapper.map(line.split(";"));
				users.put(newUser.getId(), newUser);
			}
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}
	
	private void readVenues() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("venuedata.txt"))) {
			String line = null;
			VenueMapper venueMapper  = new VenueMapper();
			while ((line = bufferedReader.readLine()) != null) {
				Venue newVenue = venueMapper.map(line.split(";"));
				venues.put(newVenue.getId(), newVenue);
			}
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}
	
	private void readEvents() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("eventdata.txt"))) {
			String line = null;
			EventMapper eventMapper = new EventMapper();
			while ((line = bufferedReader.readLine()) != null) {
				Event newEvent = eventMapper.map(line.split(";"));
				events.put(newEvent.getId(), newEvent);
			}
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}

}
