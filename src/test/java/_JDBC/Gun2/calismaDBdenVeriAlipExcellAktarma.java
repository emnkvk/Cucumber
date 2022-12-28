package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class calismaDBdenVeriAlipExcellAktarma extends JDBCParent {

    @Test
    public void test1() throws SQLException, IOException {


// Customer tablosundaki tüm verileri yeni excelle yazdırınız.
        ResultSet resultSet = statement.executeQuery("select * from customer");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        int colCount=resultSetMetaData.getColumnCount();
        System.out.println("colCount = " + colCount);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet =xssfWorkbook.createSheet("Customer Table from SakilaDB");
        XSSFRow xssfRow = xssfSheet.createRow(0);
        //      setting up the basic styles for the workbook


        for (int i=0;i<colCount;i++){ // dbden sütunları al ve yazdır
            XSSFCell xssfCell = xssfRow.createCell(i);
            xssfCell.setCellValue(resultSetMetaData.getColumnName(i+1));
        }

        int count = 1;
        while (resultSet.next()){
            xssfRow = xssfSheet.createRow(count);
            for (int i=0;i<resultSetMetaData.getColumnCount();i++){
                XSSFCell xssfCell = xssfRow.createCell(i);
                xssfCell.setCellValue(resultSet.getString(i+1)); // dbden satırları al ve yazdır
            }
            count++;
        }

        String path = "src/test/java/ApachePOI/resources/customerDB.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        xssfWorkbook.write(outputStream);
        xssfWorkbook.close();
        outputStream.close();
    }


}
