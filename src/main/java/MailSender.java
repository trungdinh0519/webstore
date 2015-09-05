import java.security.Security;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	private String mailhost = "smtp.gmail.com";

	public synchronized void sendMail(String subject, String body,
			String sender, String recipients) throws Exception {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", mailhost);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("abc@gmail.com",
								"password cua ban   o day");
					}
				});
		MimeMessage message = new MimeMessage(session);
		message.setSender(new InternetAddress(sender));
		message.setSubject(subject);
		message.setContent(body, "text/plain");
		if (recipients.indexOf(',') > 0)
			message.setRecipients(Message.RecipientType.TO, InternetAddress
					.parse(recipients));
		else
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					recipients));
		System.out.println("waiting...");
		Transport.send(message);
		System.out.println("Sent");
	}

	public static void main(String args[]) throws Exception {
		MailSender mailutils = new MailSender();
		mailutils.sendMail("From gi� v�", "xin ch�o b� con, h�y Gi�v� nh�!",
				"abc@gmail.com", "xyz@gmail.com");
	}
}