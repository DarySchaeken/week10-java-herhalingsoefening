package ticketSystem;

public class VenueMapper implements Mapper<Venue> {

	@Override
	public Venue map(String[] dataInput) {
		return new Venue(dataInput[0], dataInput[1], Integer.parseInt(dataInput[2]), Integer.parseInt(dataInput[3]),
				dataInput[4], Integer.parseInt(dataInput[5]));
	}

}
