package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _04_ApachePOI_GetAllData {
    public static void main(String[] args) throws IOException {
        String path ="src/test/java/ApachePOI/resources/ApacheExcel2.xlsx";

        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i=0; i<rowCount;i++){
            Row row = sheet.getRow(i); //i. satır alındı

            int cellCount = row.getPhysicalNumberOfCells();
            for (int j=0; j<cellCount; j++){
                Cell cell = row.getCell(j);
                System.out.print(cell+"\t");
            }
            System.out.println();
        }
        //2.Yontem
        for (int i=0; i<sheet.getPhysicalNumberOfRows();i++){
            for (int j=0; j<sheet.getRow(i).getPhysicalNumberOfCells(); j++){

                System.out.print(sheet.getRow(i).getCell(j)+"\t");
            }
            System.out.println();
        }



    }
}
