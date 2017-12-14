package ticketSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TicketWriter {

	public static void writeTicket(User user, Event event){
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(event.getId() + " - " + user.getId() + ".txt"))){
			bufferedWriter.write(event.getId() + "\t");
			bufferedWriter.write(event.getName() + System.lineSeparator());
			bufferedWriter.write(String.format("%.2f" + System.lineSeparator(), event.getPrice()));
			bufferedWriter.write(user.getId() + "\t");
			bufferedWriter.write(user.getFirstName() + " " + user.getName() + System.lineSeparator());
			bufferedWriter.write(String.format("Premium: %b", user.isPremium()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
