package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _05_GetASpecificData {
    /**
     * Verilen Exceldeki password bilgisini bir metoda aracılığı bularak yazdırınız,
     * yani metoda "password" kelimesi gönderilecek, dönen değer password un kendisi olacak.
     * src/test/java/ApachePOI/resources/LoginData.xlsx
     */
    public static void main(String[] args) {
        System.out.print("Search Word=");
        Scanner oku= new Scanner(System.in);
        String searchWord= oku.next();

        String returnResult=find(searchWord);
        System.out.println("returnResult = " + returnResult);

}


    public static String find(String searchWord)
    {
        String returnResult="";

        String path="src/test/java/ApachePOI/resources/LoginData.xlsx";

        Workbook workbook=null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook= WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet= workbook.getSheetAt(0); // .getSheet("Login");

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row=sheet.getRow(i);
            Cell cell=row.getCell(0);

            if (cell.toString().equalsIgnoreCase(searchWord))
                for (int j = 1; j < row.getPhysicalNumberOfCells(); j++)
                    returnResult +=  row.getCell(j)+" ";
        }

        return returnResult;
    }
}
