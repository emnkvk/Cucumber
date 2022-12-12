package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09_Soru {
    public static void main(String[] args) throws IOException {
        /*
      Yeni bir excele merhaba Dünya 1 şeklinde yazdıktan sonra , programı tekrar
      çalıştırdığınızda aynı excelin bir alt satırına devam ediniz.
      Program her çalıştıkça aşağıdaki gibi olmalı
      Merhaba Dünya 1
      Merhaba Dünya 2
      Merhaba Dünya 3
       ....
       ....
       path="";
       File dosya=new File(path)

       if (dosya.exists()  // dosya var mı
     */

        String path="src/test/java/ApachePOI/resources/YeniExcelMerhaba3.xlsx";
        File dosya = new File(path);
        if (!dosya.exists()){
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook();// hafızada yeni excell oluşturuldu.
            XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sayfa1"); // içinde sheet oluşturdum.
//            XSSFCell cell = xssfWorkbook.createSheet("sayfa2").createRow(1).createCell(1);
//            cell.setCellValue("Merhaba");
            // HAFIZADA oluşturma ve yazma işlemelri yapılıyor
            Row yeniSatir= xssfSheet.createRow(0); // satır oluşturuldu 0.yerde
            Cell yeniHucre= yeniSatir.createCell(0); // yeni satırda ilk hucre oluşturuldu
            yeniHucre.setCellValue("Merhaba Dünya"); // bilgi yazıldı.


            // Yazma işlemini YAZMA modunda açıp öyle yapacağız.
            //String yeniExcelPath="src/test/java/ApachePOI/resources/YeniExcel.xlsx";
            FileOutputStream outputStream=new FileOutputStream(path);
            xssfWorkbook.write(outputStream);
            xssfWorkbook.close();  // hafıza boşaltıldı
            outputStream.close();
            System.out.println("işlem tamamlandı");

        }

        else {// dosya var ise

            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook =WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            int rowCnt = sheet.getPhysicalNumberOfRows();
            //Hafızada İşlemlere devam ediyor
            Row yenisatir = sheet.createRow(rowCnt); // Satır oluşturuldu 0 ıncı yerde
            Cell yenihucre = yenisatir.createCell(0);
            yenihucre.setCellValue("Merhaba Dünya"+(rowCnt+1));
            inputStream.close(); // okuma modu kanalı kapatılıyor.

            // Yazma işlemini YAZMA modunda açıp öyle yapacağız.
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream); //workbook excell dosyasına yazıldı.
            outputStream.close(); //yazma için açılan kanal kapatıldı.
            System.out.println("İşlem tamamlandı, Yeni satıra geçildi..");




        }


    }
}
