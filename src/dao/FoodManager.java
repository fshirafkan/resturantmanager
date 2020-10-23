package dao;

import view.Food;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FoodManager {

    public List<Food> getresturantFoodList(Connection con, String resturantName) throws SQLException {
        Statement stmt = con.createStatement();
        String query2 = "select * from resturant.food where resturant.food.resturant_resturantName='" + resturantName + "'";
        ResultSet rs = stmt.executeQuery(query2);
        ResultSetMetaData rsmd1 = (ResultSetMetaData) rs.getMetaData();

        List<Food> foods = new ArrayList();
        while (rs.next()) {
            String foodtype = String.valueOf(rs.getString(3));
            foods.add(new Food(rs.getString(1), rs.getInt(2), foodtype));
        }
        stmt.close();
        return foods;
    }

    public Food getfood(Connection con, String foodName, String resturantName) throws SQLException {
        Statement stmt = con.createStatement();
        String query2 = "select * from resturant.food where resturant.food.foodName=" + foodName +
                "resturant.food.resturant_resturantName=" + resturantName;
        ResultSet rs = stmt.executeQuery(query2);
        ResultSetMetaData rsmd1 = (ResultSetMetaData) rs.getMetaData();
        Food food;
        String foodtype = String.valueOf(rs.getString(3));
        food = new Food(rs.getString(1), rs.getInt(2), foodtype);
        stmt.close();
        return food;
    }

    public void addfood(Connection con, String foodName, String resturantName, String type, int price) throws SQLException {
        Statement stmt = con.createStatement();
        String query2 = "INSERT INTO `food`(`foodName`, `foodprice`, `foodtype`, `resturant_resturantName`) VALUES (" +
                foodName + "," + String.valueOf(price) + "," + type + "," + resturantName + ")";
        stmt.executeUpdate(query2);
        stmt.close();
    }
}
