package ticketSystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Event {
	private static int idNumberGenerator = 1;
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");
	
	private String id;
	private String name;
	private LocalDate eventDate;
	private LocalTime startTime;
	private String description;
	private double price;
	private Venue venue;
	private ArrayList<User> ticketHolders;
	
	public Event(String name, String eventDate, String startTime, String description, double price) {
		setName(name);
		setPrice(price);
		setEventDate(eventDate);
		setStartTime(startTime);
		setDescription(description);
		id = generateId();
		ticketHolders = new ArrayList<User>();
	}
	
	public Event(String name, String eventDate, String startTime, String description, double price, Venue venue) {
		this(name, eventDate, startTime, description, price);
		setVenue(venue);
	}
	
	public Event(String id, String name, String eventDate, String startTime, String description, double price, Venue venue){
		this(name, eventDate, startTime, description, price, venue);
		this.id = id;
	}
	
	
	public void addTicketHolder(User tickerHolder){
		ticketHolders.add(tickerHolder);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = LocalDate.parse(eventDate, DATE_FORMAT);
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = LocalTime.parse(startTime, TIME_FORMAT);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}
	
	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	private String generateId(){
		StringBuilder returnString = new StringBuilder(getName().substring(0, 3).toUpperCase() + "-" + idNumberGenerator);
		while(returnString.length() < 9){
			returnString.insert(4, '0');
		}
		idNumberGenerator++;
		return returnString.toString();
	}
	

}
