package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _02_GetAllRowColumn extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from language");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int getColumnCount = resultSetMetaData.getColumnCount();
        System.out.println("getColumnCount = " + getColumnCount);


        for (int i=1; i<=getColumnCount;i++){
            String columnName = resultSetMetaData.getColumnName(i);
            String columnType = resultSetMetaData.getColumnTypeName(i);

            System.out.println("columnName = " + columnName);
            System.out.println("columnType = " + columnType);
        }
    }

    @Test
    public void test2() throws SQLException {
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi

        ResultSet resultSet = statement.executeQuery("select * from language");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();


        int columnCount = resultSetMetaData.getColumnCount();
        System.out.println("columnCount = " + columnCount);

      // Sütun Başlıkları
        for(int i=1; i<= resultSetMetaData.getColumnCount(); i++)
            System.out.print(resultSetMetaData.getColumnName(i)+"\t");

        System.out.println();

        // Satırları okumak
        while (resultSet.next())
        {
            for(int i=1; i<= resultSetMetaData.getColumnCount(); i++)
                System.out.print(resultSet.getString(i)+"\t");

            System.out.println();
        }

    }

    @Test
    public void test3() throws SQLException {
        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi : aralıklarını düzenli nasıl yaparız

        ResultSet resultSet=statement.executeQuery("select * from language");

        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

        for(int i=1; i<= resultSetMetaData.getColumnCount(); i++)
            System.out.printf("%-20s |",resultSetMetaData.getColumnName(i));
        // % : değişkenin değerini işaret eder
        // - : sola dayalı yazdırır, default sağa dayalı
        // 20: kaç hane kullanılacak herzaman onun bilgisi
        // s : string değerler içis , sayısal değerler için d kullanılır
        // "%5.2d" : sayı için 5 hane kullan, ondalıklı kısım için 2 hane

        System.out.println();

        while (resultSet.next()) // bir sonraki
        {
            for(int i=1; i<= resultSetMetaData.getColumnCount(); i++)
                System.out.printf("%-20s |",resultSet.getString(i));

            System.out.println();
        }
    }

    // actor tablosundaki tüm satırları ve tüm sütunları yazdırınız, aynı mysql sonuç ekranında olduğu gibi
    // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.
    @Test
    public void test4() throws SQLException {

        getTable("select * from actor");
    }

    public void getTable(String sqlQuery) throws SQLException {
        ResultSet resultSet=statement.executeQuery(sqlQuery);

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        for(int i=1; i<= resultSetMetaData.getColumnCount(); i++)
            System.out.printf("%-20s",resultSetMetaData.getColumnName(i));

        System.out.println();

        while (resultSet.next())
        {
            for(int i=1; i<= resultSetMetaData.getColumnCount(); i++)
                System.out.printf("%-20s",resultSet.getString(i));

            System.out.println();
        }
    }

    @Test
    public void test5() throws SQLException {
        getTable2("select*from language");
    }
    public void getTable2(String sorgu) throws SQLException {
        ResultSet rs = statement.executeQuery(sorgu);
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%d ", rsmd.getColumnDisplaySize(i));

        System.out.println();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s", rsmd.getColumnName(i));

        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {

                if (rsmd.getColumnDisplaySize(i) > 100) {
                    System.out.printf("%-100s ", rs.getString(i).substring(0, rs.getString(i).length() > 100 ? 100 : rs.getString(i).length()));
                } else
                    System.out.printf("%-" + rsmd.getColumnDisplaySize(i) + "s ", rs.getString(i));
            }

            System.out.println();
        }
    }


}
