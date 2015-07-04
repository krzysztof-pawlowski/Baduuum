package pl.baduuum.server.service;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import pl.baduuum.client.ContactFormService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ContactFormServiceImpl extends RemoteServiceServlet implements
		ContactFormService {

	private static final long serialVersionUID = 4759275195552762534L;

	@Override
	public void submit(String name, String email, String messageBody) {

		// Recipient's email ID needs to be mentioned.
		String to = "baduuum@baduuum.pl";

		// Sender's email ID needs to be mentioned
		String from = "baduuum@baduuum.pl";

		// Assuming you are sending email from localhost
		String host = "ssl0.ovh.net";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(properties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("baduuum@baduuum.pl",
								"1415926535");
					}
				});

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			Address[] addresses = { new InternetAddress(email) };
			message.setReplyTo(addresses);

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			// Set Subject: header field
			message.setSubject("Kontakt z formularza na stronie.");

			// Now set the actual message
			message.setText("Od: " + name + "\n" + "E-mail: " + email + "\n"
					+ "Wiadomość: " + messageBody);

			// Send message
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}