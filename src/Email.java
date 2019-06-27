import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.Folder;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.SearchTerm;

public class Email {

    private State state;

    public Email(State state) {
        this.state = state;
    }

    public boolean openEmail() {
        Properties props = new Properties();
        props.setProperty("mail.imap.ssl.enable", "true");
        Session mailSession = Session.getInstance(props);
        state.setMailSession(mailSession);
        mailSession.setDebug(true);
        try {
            Store mailStore = mailSession.getStore("imap");
            mailStore.connect("outlook.office365.com", state.getSID(), state.getPassword());
            state.setMailStore(mailStore);

            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            state.setError("Couldn't access Email!");
            return false;
        }

    }

    public boolean searchEmail() {

        try {
            //opens the inbox folder
            Folder folderInbox = state.getMailStore().getFolder("INBOX");
            folderInbox.open(Folder.READ_ONLY);

            //creates search criterion
            SearchTerm searchCondition = new SearchTerm() {
                @Override
                public boolean match(Message message) {
                    try {
                        if (message.getSubject().contains(state.getParameters().get(0))) {
                            return true;
                        }
                    } catch (MessagingException ex) {
                        ex.printStackTrace();
                        state.setError("Couldn't find E-mail with given parameter!");
                    }
                    return false;
                }
            };

            //performs search
            Message[] foundMessages = folderInbox.search(searchCondition);

            for (int i = 0; i < foundMessages.length; i++) {
                Message message = foundMessages[i];
                String subject = message.getSubject();
                System.out.println("Found message #" + i + ": " + subject);
            }

            state.setMessages(foundMessages);

            // disconnect
           // folderInbox.close(false);
          //  state.getMailStore().close();

        } catch (MessagingException e) {
            e.printStackTrace();
            state.setError("Couldn't access Inbox!");
        }
        return false;
    }

    public boolean openAttachement() {
        List<File> attachments = new ArrayList<File>();
        try {
            for (Message message : state.getMessages()) {
                Multipart multipart = (Multipart) message.getContent();
                int numberOfParts = multipart.getCount();
                for (int i = 0; i < multipart.getCount(); i++) {
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
                        MimeBodyPart part = (MimeBodyPart) multipart.getBodyPart(partCount);
                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                            // this part is attachment
                            state.setAttachment(part);
                        }
                    }
                   // InputStream is = bodyPart.getInputStream();

                  //  MimeBodyPart part = new MimeBodyPart(is);

                    //state.setAttachment(part);
                    return true;
                }
            }
        } catch (MessagingException e) {
            e.printStackTrace();
            state.setError("Couldn't retrieve message!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveAttachment() throws MessagingException, IOException {
       // new FileOutputStream(new File(".example.txt"));
       // state.getAttachment().writeTo(new FileOutputStream(new File(".\\tmp\\example.xlsx")));
        state.getAttachment().saveFile("." + File.separator +"example.xlsx");
        return false;
    }

    public boolean sendEmail() {
        try {
            Message message = new MimeMessage(Session.getInstance(System.getProperties()));
            message.setFrom(new InternetAddress("hackertyras@outlook.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("hackertyras@outlook.com"));
            message.setSubject("test");
            // create the message part
            MimeBodyPart content = new MimeBodyPart();
            // fill message
            content.setText("test");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(content);
            // add attachments
                MimeBodyPart attachment = new MimeBodyPart();
                DataSource source = new FileDataSource("."+File.separator+"example.xlsx");
                attachment.setDataHandler(new DataHandler(source));
                attachment.setFileName("example.xlsx");
                multipart.addBodyPart(attachment);
            // integration
            message.setContent(multipart);
            // store file
            message.writeTo(new FileOutputStream(new File("."+File.separator+"test.eml")));
        } catch (MessagingException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
           ex.printStackTrace();;
        }


        return false;
    }
}
