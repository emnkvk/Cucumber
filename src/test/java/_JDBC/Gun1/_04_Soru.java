package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {

    // city tablosundaki tüm kayıtlardaki isimleri next ile yazdırınız
    // city tablosundaki tüm kayıtlardaki isimleri absolute ile yazdırınız
    // city tablosundaki tüm kayıtlardaki isimleri relative ile yazdırınız.

    @Test
    public void cityTablosundakiCityAdlariNext() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from city");

        int count = 0;
        while (resultSet.next()){
            System.out.println(resultSet.getString(2)+ " Country id >  " + resultSet.getString(3));

            count++;
        }
        System.out.println("Total Count :" + count);
    }

    @Test
    public void cityTablosundakiCityAdlariAbsolute() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from city");
        int count = 1;
        while (resultSet.absolute(count)){
            System.out.println(resultSet.getString(2));
            count++;
        }
        System.out.println("Total Count :" + (count-1));
    }

    @Test
    public void cityTablosundakiCityAdlariRelative() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from city");
        int count =0;
        while (resultSet.relative(1)){
            System.out.println(resultSet.getString(2));
            count++;
        }
        System.out.println("Total Count :" + count);
    }
}
