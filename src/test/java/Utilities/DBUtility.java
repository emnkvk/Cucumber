package Utilities;

import org.testng.annotations.AfterTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    private static Connection connection;
    protected static Statement statement;

    public static ArrayList<ArrayList< String >> getListData(String query)  {
        ArrayList< ArrayList< String > > tablo=new ArrayList<>();
        //DB den bütün satırları ve kolonları okuyup liste atacak

        // 1- Db bağlantısını aç
        DBConnectionOpen();
        // 2- Sorguyu calistir
try {


        ResultSet resultSet=statement.executeQuery(query);
        int columnCount = resultSet.getMetaData().getColumnCount();



        // 3- Sorgu Sonucunu tabloya doldur

        while (resultSet.next())
        {
            ArrayList<String> satir = new ArrayList<>();
            for(int i=1; i<= columnCount; i++)
                satir.add(resultSet.getString(i));

            tablo.add(satir);
        }
}
catch (Exception e){
    e.getMessage();
}
        // 4- Db bağlantısnı kapat
        DBConnectionClose();
        return tablo;
    }

    public static void DBConnectionOpen() {
        //hotstname,port,db adını (user db
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root"; //username
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void DBConnectionClose() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        ArrayList< ArrayList< String > > tablo= getListData("select * from actor" );

       //System.out.println("tablo = " + tablo);
        for (ArrayList< String > getDBTable:tablo) {
            System.out.printf("  %-20s  \n", getDBTable);
        }
    }
}
