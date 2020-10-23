package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class CustomerManager {
    public boolean FindCustomer(Connection con,String phonenumber) throws SQLException {
        boolean result=false;
        Statement stmt=con.createStatement();
        String query2="SELECT * FROM resturant.customer where resturant.customer.phonenumber="
                +phonenumber+"''";
        ResultSet rs=stmt.executeQuery(query2);
        ResultSetMetaData rsmd1=(ResultSetMetaData) rs.getMetaData();
        if(rsmd1!=null)
            result=true;
        else
            result=false;
        stmt.close();
        return result;
    }

    public void addCustomer(Connection con,String phonenumber, String name,int region,String postalcode) throws SQLException {

        Statement stmt=con.createStatement();
        String query2="INSERT INTO resturant.customer (phonenumber, customerName" +
                ", customerRegion, customerPostalcode) VALUES ("+phonenumber+","+name+","+
                String.valueOf(region)+","+phonenumber+")";
        stmt.executeUpdate(query2);


        stmt.close();

    }
}
