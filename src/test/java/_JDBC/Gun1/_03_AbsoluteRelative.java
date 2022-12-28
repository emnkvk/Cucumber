package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent {

    @Test
    private void test1() throws SQLException {
        // next(): bir sonraki row
        // previous() : bir önceki row
        // absolute(4) : baştan itibaren 4.ROW a gider, direkt verine ROW a gider
        // relative(4) : bulunduğu noktadan 4 sonraki ROW a gider.

        ResultSet resultSet = statement.executeQuery("select * from film");
        resultSet.absolute(10);
        String title = resultSet.getString("title");
        System.out.println("10.satırdaki filmin baslıgı: "+title); //ALADDIN CALENDAR


        resultSet.absolute(15);
        title = resultSet.getString("title");
        System.out.println("10.satırdaki filmin baslıgı: "+title); // ALIEN CENTER


        resultSet.absolute(-15); // (-15) alırsak sondan itibaren 15.satıra gider.
        title = resultSet.getString("title");
        System.out.println("10.satırdaki filmin baslıgı: "+title); // WONKA SEA


        resultSet.absolute(10);
        title = resultSet.getString("title");
        System.out.println("10.satırdaki filmin baslıgı: "+title); // ALADDIN CALENDAR


        resultSet.relative(5) ; // en son bulunduğun yerden 5 satır ileri
        title=resultSet.getString("title");
        System.out.println("title = " + title); //WORST BANGER

        resultSet.relative(-5) ; // en son bulunduğun yerden 5 satır geri
        title=resultSet.getString("title");
        System.out.println("title = " + title); //WONKA SEA


        System.out.println("--------------------------------------------------------");
        for (int i =10; i>0;i--){

            resultSet.absolute(i) ; // en son bulunduğun yerden 5 satır ileri
            title=resultSet.getString("title");
            System.out.println("title = " + title); //WORST BANGER
        }



    }
}
