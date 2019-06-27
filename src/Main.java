import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException, MessagingException {
        List<String> parameterList = new ArrayList<>();
        FunctionParamMap testOpenEmail = new FunctionParamMap(ENUMS.Functions.OpenEmail,parameterList);
        parameterList.add("Excel");
        FunctionParamMap testSearchEmail = new FunctionParamMap(ENUMS.Functions.SearchEmail,parameterList);
        FunctionParamMap testOpenAttachement = new FunctionParamMap(ENUMS.Functions.OpenAttachment, parameterList);
        FunctionParamMap testSaveAttachement = new FunctionParamMap(ENUMS.Functions.SaveAttachment, parameterList);
        ArrayList<FunctionParamMap> testActionMap = new ArrayList<>();
        testActionMap.add(testOpenEmail);
        testActionMap.add(testSearchEmail);
        testActionMap.add(testOpenAttachement);
        testActionMap.add(testSaveAttachement);
        new Hub("hacktyras@outlook.com", "Adrianistheboss123!",testActionMap );


    }

}
