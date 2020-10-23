package dao;

import view.Food;
import view.Resturantinfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AdminTables {
    public void getresturantFoodList(Connection con, String resturantName) throws SQLException {
        Statement stmt = con.createStatement();
        String query2 = "select  * from resturant.resturantinfo";
        ResultSet rs = stmt.executeQuery(query2);
        ResultSetMetaData rsmd1 = (ResultSetMetaData) rs.getMetaData();


        stmt.close();

    }
    public void  showresturantinfotable(Connection con ) throws SQLException {
        ResturantinfoManager rim=new ResturantinfoManager();
        ArrayList<Resturantinfo> infotable= (ArrayList<Resturantinfo>) rim.getresturantsinfo(con);
        int counter=1;
        Function<Integer, Stream<ResturantinfoManager>> regionfilter= region -> infotable.stream()
                .filter(r->r.region==region);
        Predicate<Integer> hasregion= region-> infotable.stream().anyMatch(r->r.region==region);
        System.out.println("region,sale,resturant name, ");
        for(int i =1 ; i<4 ;i++){
            if(hasregion.test(i)){
                if(regionfilter.apply(i).anyMatch(r->r.sale<10000)){
                    regionfilter.apply(i).filter(r->r.sale<10000)
                            .forEach(cutomer->System.out.println(customer.resturantname+","+));

                }
            }

        }

    }

}
