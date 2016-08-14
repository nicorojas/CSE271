// Nico Rojas
// CSE 271, Lab 4
// 2.23.16

public class MessageTester {

	public static void main(String[] args) {

		String sender = "Kanye West", recipient = "Drake";
		Message email = new Message(sender, recipient);

		email.append("Hey Drake, I've come into some debt.");
		email.append("Do you mind venmo-ing me a few mill...?");
		email.toString();
		System.out.println(email);
	} // end main

} // end class