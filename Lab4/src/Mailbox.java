// Nico Rojas
// CSE 271, Lab 4
// 2.23.16

import java.util.ArrayList;

public class Mailbox {

	final String signature = "\nSender Signature\nSignature Line Two";

	private ArrayList<Message> emailMsgs = new ArrayList<Message>();

	public Mailbox() {
		emailMsgs = new ArrayList<Message>();
	}

	public void addMessage(Message m) {
		emailMsgs.add(m); // add message to mailbox
		m.append(signature);
	}

	public Message getMessage(int i) {
		return emailMsgs.get(i); // return message
	}

	public void removeMessage(int i) {
		emailMsgs.remove(i); // remove message
	}

} // end class