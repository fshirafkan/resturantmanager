package dao;

import view.Food;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FactorManager {

    public void insertOrders(Connection con , Food orderedfood , String name , String resturantname, int count) throws SQLException {
        Statement stmt = con.createStatement();
        
            String query2 = "INSERT INTO `factor`(`name`,`foodname`, `foodprice`, `foodtype`, `resturantname`, `count`) VALUES (" +
                    orderedfood.getName() + "," + String.valueOf(orderedfood.getPrice()) + ","
                    + orderedfood.getType() + "," + resturantname +"," +String.valueOf(count)+ ")";
            stmt.executeUpdate(query2);
       

        stmt.close();
    }
}
