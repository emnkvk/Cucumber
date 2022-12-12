package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {
    public static void main(String[] args) throws IOException {
        //Workbook var olan excell in yapısı
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();// hafızada yeni excell oluşturuldu.
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sayfa1"); // içinde sheet oluşturdum.
        XSSFCell cell = xssfWorkbook.createSheet("sayfa2").createRow(1).createCell(1);
        cell.setCellValue("Merhaba");
        // HAFIZADA oluşturma ve yazma işlemelri yapılıyor
        Row yeniSatir= xssfSheet.createRow(0); // satır oluşturuldu 0.yerde
        Cell yeniHucre= yeniSatir.createCell(0); // yeni satırda ilk hucre oluşturuldu
        yeniHucre.setCellValue("Merhaba Dünya"); // bilgi yazıldı.

        for (int i = 1; i < 10 ; i++) {

            yeniSatir.createCell(i).setCellValue(i);
        }

        // Yazma işlemini YAZMA modunda açıp öyle yapacağız.
        String yeniExcelPath="src/test/java/ApachePOI/resources/YeniExcel.xlsx";
        FileOutputStream outputStream=new FileOutputStream(yeniExcelPath);
        xssfWorkbook.write(outputStream);
        xssfWorkbook.close();  // hafıza boşaltıldı
        outputStream.close();
        System.out.println("işlem tamamlandı");

    }
}
