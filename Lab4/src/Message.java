// Nico Rojas
// CSE 271, Lab 4
// 2.23.16

public class Message {

	private String sender, recipient, message = "";

	public Message(String sender, String recipient) {
		this.sender = sender;
		this.recipient = recipient;
	}

	public void append(String text) {
		message += text + "\n"; // add text to end of current message
	}

	public String toString() {

		final String from = "\nFrom: ";
		final String to = "\nTo: ";

		// convert message into String
		String outString = from + sender + to + recipient + "\n\n" + message + "\n\n";

		return outString;
	}

} // end class