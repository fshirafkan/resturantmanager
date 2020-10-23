package dao;


import view.Resturantinfo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResturantinfoManager {
    public int sale;

    public List<Resturantinfo> getresturantsinfo(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        String query2 = "select * from resturant.resturantinfo " ;
        ResultSet rs = stmt.executeQuery(query2);
        ResultSetMetaData rsmd1 = (ResultSetMetaData) rs.getMetaData();

        List<Resturantinfo> info = new ArrayList();
        while (rs.next()) {

            info.add(new Resturantinfo(rs.getInt(1), rs.getDouble(2), rs.getString(3)));
        }
        stmt.close();
        return info;
    }
}
