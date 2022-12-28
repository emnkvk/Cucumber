package _JDBC.Gun1;

import org.testng.annotations.Test;

import javax.xml.transform.Result;
import java.sql.*;

public class _01_Intro {

    @Test
    public void Test1() throws SQLException {

        //hotstname,port,db adını (user db
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username="root"; //username
        String password="'\"-LhCB'.%k[4S]z";

        // Db connection burada
        Connection connection = DriverManager.getConnection(url,username,password); // click to link
        // SQL lerin yazılacağı sayfa
        Statement statement = connection.createStatement(); // sorguları çalıştırmak sayfa açıldı

        ResultSet result = statement.executeQuery("select*from actor"); // sorgunun sonucunu aldım

        result.next(); // ilk satır bilgisayarıma geldi, ilk satırı aldım.

        String first_name = result.getString("first_name");

        String last_name = result.getString("last_name");

        System.out.println("1.satır first_name ve last_name : " + first_name+" "+last_name);

        result.next(); // 2.Satırı getir
         first_name = result.getString("first_name");
         last_name = result.getString("last_name");
        System.out.println("2.satır first_name ve last_name : " + first_name+" "+last_name);
         connection.close(); // connection kapatılıyor.







    }
}
