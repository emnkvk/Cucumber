package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOI_Start {
    public static void main(String[] args) throws IOException {
        String path ="src/test/java/ApachePOI/resources/ApacheExcel2.xlsx";

        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);


        Sheet sheet = workbook.getSheet("Sheet1");

        Row satir = sheet.getRow(0);

        Cell hucre = satir.getCell(0);

        System.out.println("Hucre= "+hucre);
    }
}
