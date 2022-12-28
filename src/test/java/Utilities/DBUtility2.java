package Utilities;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility2 {
    private static Connection connection;
    protected static Statement statement;

    public static ArrayList<ArrayList< String >> getListData(String query) throws SQLException {
        ArrayList< ArrayList< String > > tablo=new ArrayList<>();
        //DB den bütün satırları ve kolonları okuyup liste atacak

        // 1- Db bağlantısını aç
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root"; //username
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // 2- Sorguyu calistir
        ResultSet resultSet=statement.executeQuery(query);

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();


        // 3- Sorgu Sonucunu tabloya doldur

        for(int i=1; i<= resultSetMetaData.getColumnCount(); i++)
            System.out.printf("%-20s",resultSetMetaData.getColumnName(i));

        System.out.println();

        while (resultSet.next())
        {
            for(int i=1; i<= resultSetMetaData.getColumnCount(); i++)
                System.out.printf("%-20s",resultSet.getString(i));

            System.out.println();
        }

        // 4- Db bağlantısnı kapat
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tablo;
    }

    public static void main(String[] args) throws SQLException {
        ArrayList< ArrayList< String > > tablo= getListData("select * from actor");

       System.out.println("tablo = " + tablo);
    }
}
