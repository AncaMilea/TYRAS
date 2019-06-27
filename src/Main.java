import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException, MessagingException {
        List<String> parameterList = new ArrayList<String>();
        FunctionParamMap testOpenEmail = new FunctionParamMap(ENUMS.Functions.OpenEmail,parameterList);
        parameterList.add("Excel");
        FunctionParamMap testSearchEmail = new FunctionParamMap(ENUMS.Functions.SearchEmail,parameterList);
        FunctionParamMap testOpenAttachement = new FunctionParamMap(ENUMS.Functions.OpenAttachment, parameterList);
        FunctionParamMap testSaveAttachement = new FunctionParamMap(ENUMS.Functions.SaveAttachment, parameterList);
        FunctionParamMap testSendAttachement = new FunctionParamMap(ENUMS.Functions.SendEmail, parameterList);
        FunctionParamMap testSaveExcel = new FunctionParamMap(ENUMS.Functions.SaveExcel, parameterList);
        FunctionParamMap testDeleteExcel = new FunctionParamMap(ENUMS.Functions.DeleteExcel, parameterList);
        ArrayList<FunctionParamMap> testActionMap = new ArrayList<FunctionParamMap>();
        testActionMap.add(testOpenEmail);
        testActionMap.add(testSearchEmail);
        testActionMap.add(testOpenAttachement);
        testActionMap.add(testSaveAttachement);
        testActionMap.add(testSendAttachement);
        testActionMap.add(testSaveExcel);
        testActionMap.add(testDeleteExcel);
        new Hub("hacktyras@outlook.com", "Adrianistheboss123!",testActionMap );

    }

}
