import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.mail.MessagingException;
import java.io.*;
import java.util.Iterator;

public class Excel {
    private State state;

    public Excel(State state){
        this.state=state;
        try {
            state.getAttachment().saveFile("." + File.separator +"example.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
            state.setError("Couldn't find Excel file!");
        }
        try {
            FileInputStream file = new FileInputStream(new File("." + File.separator + "example.xlsx"));
            Workbook workbook = new XSSFWorkbook(file);
            state.setExcelPage(workbook);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            state.setError("Couldn't find Excel file!");
        } catch (IOException e) {
            e.printStackTrace();
            state.setError("Couldn't open Excel file!");
        }
    }

    public boolean selectExcel() {

        return false;
    }

    public boolean deleteExcel() {

        Workbook workbook = state.getExcelPage();
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i< 5; i++) {
            sheet.removeRow(sheet.getRow(i));
        }

        saveExcel();
        return false;

    }

    public boolean filterExcel() {


        return false;

    }

    public boolean saveExcel() {

        Workbook workbook = state.getExcelPage();

        try {
            FileOutputStream outputStream = new FileOutputStream(new File( "C:\\Users\\Bianca\\IdeaProjects\\TYRAS\\tmp\\example2.xlsx"));
            workbook.write(outputStream);
            workbook.close();
            System.out.println("Excel with formula cells written successfully");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            state.setError("Couldn't save Excel file!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
