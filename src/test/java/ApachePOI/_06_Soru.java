package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _06_Soru {
    public static void main(String[] args) {
        System.out.print("Istenen Column=");
        Scanner oku= new Scanner(System.in);
        int searchColumn= oku.nextInt();

        String returnResult=find(searchColumn);
        System.out.println("returnResult = \n" + returnResult);

    }


    public static String find(int searchColumn)
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
            if (sheet.getRow(i).getCell(searchColumn)!=null)
          returnResult+=sheet.getRow(i).getCell(searchColumn)+"\n";

        }

        return returnResult;
    }
}
