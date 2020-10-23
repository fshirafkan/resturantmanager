package dao;

import view.Resturant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ResturantManager {
    public List<Resturant> getresturantList(Connection con, int region) throws SQLException {
        Statement stmt=con.createStatement();
        String query2="select * from resturant.resturant where resturant.resturant.resturantRegion= '"
                +String.valueOf(region)+"'";
        ResultSet rs=stmt.executeQuery(query2);
        ResultSetMetaData rsmd1=(ResultSetMetaData) rs.getMetaData();

        List<Resturant> resturants=new ArrayList();
        while(rs.next()) {

            resturants.add(new Resturant(rs.getString(1),
                    rs.getInt(2),rs.getDouble(3)));
        }
        stmt.close();
        return resturants;

    }

    public void addresturant(Connection con, String resturantName,double resturantSendPrice,int resturantRegion) throws SQLException {
        Statement stmt=con.createStatement();
        String query2="INSERT INTO `resturant`(`resturantName`, `resturantSendPrice`, `resturantRegion`) VALUES ("+
                resturantName+","+String.valueOf(resturantSendPrice)+","+String.valueOf(resturantRegion)+")";
        stmt.executeUpdate(query2);



        stmt.close();
    }
}
