package ticketSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TicketWriter {

	public static void writeTicket(User user, Event event){
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(event.getId() + "-" + user.getId() + ".txt"))){
			bufferedWriter.write(event.getId());
			bufferedWriter.write(event.getName());
			bufferedWriter.write(String.format("%d", event.getPrice()));
			bufferedWriter.write(user.getId());
			bufferedWriter.write(user.getFirstName() + " " + user.getName());
			bufferedWriter.write(String.format("Premium: %b", user.isPremium()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
