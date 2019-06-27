//import javax.mail.BodyPart;
//import javax.mail.Message;
//import javax.mail.Session;
//import javax.mail.Store;
//import javax.mail.internet.MimeBodyPart;
//import java.util.List;
//
//public class State {
//    private String SID;
//    private String password;
//    private List<String> parameters;
//    private String error;
//    private Store mailSession;
//    private Message[] messages;
//
//    private MimeBodyPart attachment;
//
//    public State(String SID, String password) {
//        this.SID = SID;
//        this.password = password;
//    }
//
//    public Store getMailStore() {
//        return mailSession;
//    }
//
//    public void setMailStore(Store mailSession) {
//        this.mailSession = mailSession;
//    }
//
//    public String getError() {
//        return error;
//    }
//
//    public void setError(String error) {
//        this.error = error;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getSID() {
//        return SID;
//    }
//
//    public void setSID(String SID) {
//        this.SID = SID;
//    }
//
//    public List<String> getParameters() {
//        return parameters;
//    }
//
//    public void setParameters(List<String> parameters) {
//        this.parameters = parameters;
//    }
//
//    public Message[] getMessages() {
//        return messages;
//    }
//
//    public void setMessages(Message[] messages) {
//        this.messages = messages;
//    }
//
//    public Store getMailSession() {
//        return mailSession;
//    }
//
//    public void setMailSession(Store mailSession) {
//        this.mailSession = mailSession;
//    }
//
//    public MimeBodyPart getAttachment() {
//        return attachment;
//    }
//
//    public void setAttachment(MimeBodyPart attachment) {
//        this.attachment = attachment;
//    }
//}
