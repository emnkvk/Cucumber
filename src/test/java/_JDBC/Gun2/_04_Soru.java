package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {

    // Actor tablosundaki tüm verileri yeni excelle yazdırınız.
    @Test
    public void test1() throws SQLException, IOException {
        ResultSet resultSet = statement.executeQuery("select * from actor");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        int colCount = resultSetMetaData.getColumnCount();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = workbook.createSheet("Actor Table from SakilaDB");
        XSSFRow xssfRow = xssfSheet.createRow(0);

        for (int i=0;i<colCount;i++){
            XSSFCell xssfCell = xssfRow.createCell(i);
            xssfCell.setCellValue(resultSetMetaData.getColumnName(i+1));
        }

        int count = 1;
        while(resultSet.next()){
            xssfRow = xssfSheet.createRow(count);
            for (int i=0;i<resultSetMetaData.getColumnCount();i++){
                XSSFCell xssfCell = xssfRow.createCell(i);
                xssfCell.setCellValue(resultSet.getString(i+1));
            }
            count++;
        }

        // Yazma işlemini YAZMA modunda açıp öyle yapacağız.
        String yeniExcelPath="src/test/java/ApachePOI/resources/actorDB.xlsx";
        FileOutputStream outputStream=new FileOutputStream(yeniExcelPath);
        workbook.write(outputStream);
        workbook.close();  // hafıza boşaltıldı
        outputStream.close();
        System.out.println("işlem tamamlandı");
    }

}
