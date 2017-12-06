package ticketSystem;

public class EventMapper implements Mapper<Event> {

	@Override
	public Event map(String[] dataInput) {
		String dateAndTime = dataInput[1];
		StringBuilder date = new StringBuilder(dateAndTime.substring(0, 8));
		StringBuilder time = new StringBuilder(dateAndTime.substring(8));
		date.insert(4, '/');
		date.insert(2, '/');
		time.insert(2, ':');

		return new Event(dataInput[0], dataInput[2], date.toString(), time.toString(), dataInput[3],
				Double.parseDouble(dataInput[4]), dataInput[5]);
	}

}
