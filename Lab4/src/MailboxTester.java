// Nico Rojas
// CSE 271, Lab 4
// 2.23.16

public class MailboxTester {
	
	public static void main(String[] args) {
		
		//                             sender       recipient
		Message email = new Message("Notorious BIG", "Tupac");
		email.append("Hey bro, what's good?");
		
		Mailbox inbox = new Mailbox(); // create mailbox "inbox"
		inbox.addMessage(email); // add email to inbox
		
		Message email2 = new Message("Miami University", "Student Body");
		email2.append("Hoverboards are banned.");
		inbox.addMessage(email2);
		
		System.out.println(inbox.getMessage(0));
		System.out.println(inbox.getMessage(1));
		
	} // end main
	
} // end class