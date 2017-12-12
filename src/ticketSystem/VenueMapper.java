package ticketSystem;

public class VenueMapper implements Mapper<Venue> {

	@Override
	public Venue map(String[] dataInput) {
		return new Venue(dataInput[0], dataInput[1], dataInput[2],Integer.parseInt(dataInput[3]), Integer.parseInt(dataInput[4]),
				dataInput[5], Integer.parseInt(dataInput[6]));
	}

}
