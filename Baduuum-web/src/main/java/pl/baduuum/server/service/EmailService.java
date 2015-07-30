package pl.baduuum.server.service;

import com.google.gwt.thirdparty.javascript.rhino.IR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.baduuum.shared.model.Reservation;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

@Service("emailService")
@PropertySource("classpath:Messages_pl.properties")
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private Environment env;

	public void sendReservationEmailToClient(Reservation reservation) throws MessagingException, UnsupportedEncodingException {
		// Prepare the evaluation context
		final Context ctx = prepareContext(reservation);

		// Prepare message using a Spring helper
		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
		message.setSubject(env.getProperty("mail.reservation.subject"));
		message.setFrom(new InternetAddress(env.getProperty("mail.reservation.address.from"), env.getProperty("mail.reservation.from")));
		message.setTo(reservation.getContactPersonEmail());

		// Create the HTML body using Thymeleaf
		final String htmlContent = this.templateEngine.process("reservation.html", ctx);
		message.setText(htmlContent, true);

		// Send email
		if (Boolean.valueOf(env.getProperty("send.emails"))){
			this.mailSender.send(mimeMessage);
		}

		System.out.print(htmlContent);

	}

	public void sendNotification(Reservation reservation) throws MessagingException, UnsupportedEncodingException {
		// Prepare the evaluation context
		final Context ctx = prepareContext(reservation);

		// Prepare message using a Spring helper
		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");

		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd (EEEE)");
		SimpleDateFormat hourFormatter = new SimpleDateFormat("HH:mm");

		String subject = dateFormatter.format(reservation.getDate())+ " "
				+ hourFormatter.format(reservation.getHourStart()) + "-" + hourFormatter.format(reservation.getHourEnd()) ;
		message.setSubject(subject);
		message.setFrom(new InternetAddress(env.getProperty("mail.reservation.address.from"), env.getProperty("mail.reservation.from")));
		message.setTo(env.getProperty("mail.reservation.address.notification.to"));
		message.setReplyTo(reservation.getContactPersonEmail());

		// Create the HTML body using Thymeleaf
		final String htmlContent = this.templateEngine.process("reservationNotification.html", ctx);
		message.setText(htmlContent, true);

		// Send email
		if (Boolean.valueOf(env.getProperty("send.emails"))){
			this.mailSender.send(mimeMessage);
		}
	}

	/*
	 * Send HTML mail with attachment.
	 */
	public void sendMailWithAttachment(final String recipientName,
			final String recipientEmail, final String attachmentFileName,
			final byte[] attachmentBytes, final String attachmentContentType,
			final Locale locale) throws MessagingException {

		// Prepare the evaluation context
		final Context ctx = new Context(locale);
		ctx.setVariable("name", recipientName);
		ctx.setVariable("subscriptionDate", new Date());
		ctx.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));

		// Prepare message using a Spring helper
		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
				true /* multipart */, "UTF-8");
		message.setSubject("Example HTML email with attachment");
		message.setFrom("thymeleaf@example.com");
		message.setTo(recipientEmail);

		// Create the HTML body using Thymeleaf
		final String htmlContent = this.templateEngine.process(
				"email-withattachment.html", ctx);
		message.setText(htmlContent, true /* isHtml */);

		// Add the attachment
		final InputStreamSource attachmentSource = new ByteArrayResource(
				attachmentBytes);
		message.addAttachment(attachmentFileName, attachmentSource,
				attachmentContentType);

		// Send mail
		this.mailSender.send(mimeMessage);

	}

	/*
	 * Send HTML mail with inline image
	 */
	public void sendMailWithInline(final String recipientName,
			final String recipientEmail, final String imageResourceName,
			final byte[] imageBytes, final String imageContentType,
			final Locale locale) throws MessagingException {

		// Prepare the evaluation context
		final Context ctx = new Context(locale);
		ctx.setVariable("name", recipientName);
		ctx.setVariable("subscriptionDate", new Date());
		ctx.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));
		ctx.setVariable("imageResourceName", imageResourceName); // so that we
																	// can
																	// reference
																	// it from
																	// HTML

		// Prepare message using a Spring helper
		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
				true /* multipart */, "UTF-8");
		message.setSubject("Example HTML email with inline image");
		message.setFrom("thymeleaf@example.com");
		message.setTo(recipientEmail);

		// Create the HTML body using Thymeleaf
		final String htmlContent = this.templateEngine.process(
				"email-inlineimage.html", ctx);
		message.setText(htmlContent, true /* isHtml */);

		// Add the inline image, referenced from the HTML code as
		// "cid:${imageResourceName}"
		final InputStreamSource imageSource = new ByteArrayResource(imageBytes);
		message.addInline(imageResourceName, imageSource, imageContentType);

		// Send mail
		this.mailSender.send(mimeMessage);

	}

	private Context prepareContext(Reservation reservation) {
		Context ctx = new Context(new Locale("pl"));
		ctx.setVariable("reservation", reservation);
		return ctx;
	}
}
