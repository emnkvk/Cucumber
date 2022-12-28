package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _11_CarpimTablosu {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/resources/carpimTablosuExcell5.xlsx";
        FileInputStream inputStream = new FileInputStream(path); // Okuma modu açıldı
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        //Hafızada İşlemlere devam ediyor
        Row yenisatir = sheet.createRow(0); // Satır oluşturuldu 0 ıncı yerde
        Cell yenihucre = yenisatir.createCell(0);
        //yenihucre.setCellValue("Emin");


        for (int i = 1; i <= 10 ; i++) {
            yenihucre.setCellValue(i);
            yenihucre.setCellValue(i);
            yenihucre.setCellValue(i);
            yenihucre.setCellValue(i);
            yenihucre.setCellValue(i);
            yenihucre.setCellValue(i);
            yenihucre.setCellValue(i);
            yenihucre.setCellValue(i);
            yenihucre.setCellValue(i);
            yenihucre.setCellValue(i);

        }
        // sıra kaydetmeye geldi, bütün bilgiler hafızada buraya kadar, her şey WORKBOOK da
        inputStream.close(); // okuma modu kanalı kapatılıyor.

        // Yazma işlemini YAZMA modunda açıp öyle yapacağız.
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream); //workbook excell dosyasına yazıldı.
        workbook.close(); // hafıza boşaltıldı.
        outputStream.close(); //yazma için açılan kanal kapatıldı.
        System.out.println("İşlem tamamlandı.");



    }

}
