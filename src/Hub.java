////import javax.mail.MessagingException;
//import java.io.IOException;
//import java.util.List;
//
//public class Hub {
//
//    private String SID;
//    private String password;
//
//    public Hub(String SID, String password, List<FunctionParamMap> actions) throws IOException, MessagingException {
//        State state = new State(SID, password);
//        state.setSID(SID);
//        state.setPassword(password);
//        this.SID = SID;
//        this.password = password;
//
//        int i;
//        for (i = 0; i < actions.size(); i++) {
//
//            switch (actions.get(i).getFunction()) {
//                case OpenEmail:
//                    state.setParameters(actions.get(i).getParameters());
//                    System.out.println("Opening Email");
//                    Email email = new Email(state);
//                    if (!email.openEmail()) {
//                        System.out.println(state.getError());
//                    }
//                    break;
//                case SearchEmail:
//                    state.setParameters(actions.get(i).getParameters());
//                    System.out.println("Searching Email");
//                    email = new Email(state);
//                    if (!email.searchEmail()) {
//                        System.out.println(state.getError());
//                    }
//                    break;
//                case OpenAttachment:
//                    state.setParameters(actions.get(i).getParameters());
//                    System.out.println("Opening Attachment");
//                    email = new Email(state);
//                    if (!email.openAttachement()) {
//                        System.out.println(state.getError());
//                    }
//                    break;
//                case SendEmail:
//                    state.setParameters(actions.get(i).getParameters());
//                    System.out.println("Attempting to send email");
//                    email = new Email(state);
//                    if (!email.sendEmail()) {
//                        System.out.println(state.getError());
//                    }
//                    break;
//                case MoveEmail:
//                    System.out.println("Excel case accessed");
//                    break;
//                case SaveAttachment:
//                    state.setParameters(actions.get(i).getParameters());
//                    System.out.println("Saving Attachment");
//                    email = new Email(state);
//                    if (!email.saveAttachment()) {
//                        System.out.println(state.getError());
//                    }
//                    break;
//                case SelectExcel:
//                    System.out.println("Email case accessed");
//                    break;
//                case DeleteExcel:
//                    System.out.println("Excel case accessed");
//                    break;
//                case FilterExcel:
//                    System.out.println("Folder case accessed");
//                    break;
//                case SaveExcel:
//                    System.out.println("Folder case accessed");
//                    break;
//
//                default:
//                    System.out.println("Error case accessed");
//                    break;
//            }
//
//        }
//    }
//
//
//}
