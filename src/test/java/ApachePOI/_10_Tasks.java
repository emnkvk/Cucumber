package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class _10_Tasks {
    public static void main(String[] args) throws IOException {
        /**  Soru 1:
         *  yeni excel
         *  Çarpım tablosunu excele yazdırınız.
         *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
         *  sıfırdan excel oluşturarak.
         *  her bir onluktan sonra 1 satır boşluk bırakarak alt alata
         */

        /**  Soru 2:
         * yeni excel
         *  Çarpım tablosunu excele yazdırınız.
         *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
         *  sıfırdan excel oluşturarak.
         *  her bir onluktan sonra 1 kolon boşluk bırakarak yan yana
         */
        String path="src/test/java/ApachePOI/resources/carpimTablosuExcell2.xlsx";
        File dosya = new File(path);
        if (!dosya.exists()){
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook();// hafızada yeni excell oluşturuldu.
            XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sayfa1"); // içinde sheet oluşturdum.
            Row yeniSatir= xssfSheet.createRow(0); // satır oluşturuldu 0.yerde
            Cell yeniHucre= yeniSatir.createCell(0); // yeni satırda ilk hucre oluşturuldu

            yeniHucre.setCellValue(1); // bilgi yazıldı.

            FileOutputStream outputStream=new FileOutputStream(path);
            xssfWorkbook.write(outputStream);
            xssfWorkbook.close();  // hafıza boşaltıldı
            outputStream.close();
            System.out.println("işlem tamamlandı");

        }

        else {// dosya var ise

            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            int rowCnt = sheet.getPhysicalNumberOfRows();
            //Hafızada İşlemlere devam ediyor
            Row yenisatir = sheet.createRow(rowCnt); // Satır oluşturuldu 0 ıncı yerde
            Cell yenihucre = yenisatir.createCell(0);
              // int carp = 0;
            int i=1;
               while(i<=10){
                   yenihucre.setCellValue(i+1);
                   i++;
               }



          inputStream.close(); // okuma modu kanalı kapatılıyor.

            // Yazma işlemini YAZMA modunda açıp öyle yapacağız.
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream); //workbook excell dosyasına yazıldı.
            outputStream.close(); //yazma için açılan kanal kapatıldı.
            System.out.println("İşlem tamamlandı, Yeni satıra geçildi..");

        }

    }
}
