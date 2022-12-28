package _JDBC.Gun1;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_BeforeAfter {

    private static Connection connection;
    private static Statement statement;


    @BeforeTest
    public void DBConnectionOpen(){
        //hotstname,port,db adını (user db
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username="root"; //username
        String password="'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement= connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void DBConnectionClose()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test1() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select * from language");

        resultSet.next();
        String dilAdi = resultSet.getString(2);
        System.out.println(" dil adı: "+dilAdi);

        resultSet.next();
        System.out.println(" dil adı: "+resultSet.getString(2));
        resultSet.next();
        System.out.println(" dil adı: "+resultSet.getString(2));
    }
    @Test
    public void test2() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select * from language");

        resultSet.next();
        String dilAdi = resultSet.getString(2);
        System.out.println(" dil adı: "+dilAdi);

        resultSet.next();
        System.out.println("dil adı: "+resultSet.getString(2));

        resultSet.previous();
        System.out.println("dil adı: "+resultSet.getString(2));
    }
    @Test
    public void test3() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select * from language");

        resultSet.next();
        String dilAdi = resultSet.getString(2);
        System.out.println(" dil adı: "+dilAdi);

        resultSet.next();
        System.out.println("dil adı: "+resultSet.getString(2));

        resultSet.previous();
        System.out.println("dil adı: "+resultSet.getString(2));
    }




}
