package cli;

import dao.ConnectionManager;
import dao.CustomerManager;
import dao.FoodManager;
import dao.ResturantManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import view.Customer;
import java.sql.Connection;
import java.util.Scanner;

public class Cli {
    public static void main (String args[]){
    userentering();

    }
    public static void userentering(){
        System.out.println("enter app as :\n 1.user \n 2.admin");
        Scanner scanner=new Scanner(System.in);
        if(scanner.nextInt()==1)
            customermenue();
        if(scanner.nextInt()==2)
            adminmenue();
        else
            System.out.println("wrong number!");
    }
    public static void adminmenue(){
        System.out.println("enter username and password");
        Scanner scanner= new Scanner(System.in);
        if (scanner.next().equals("admin") && scanner.next().equals("admin")){
            do{
                System.out.println("you registered as admin \n choose:\n1.about customers \n 2.about resturant");
                int choose=scanner.nextInt();
                if(choose==1)
                    showcustomerinfo();
                if(choose==2)
                    showresturantinfo();
                System.out.println("want to exit? press 0");
                if(scanner.nextInt()==0)
                    break;
            }while (true);
        }else{
            System.out.println("wrong username or password");
            userentering();
        }
    }
    public static void customermenue(){
        Customer customer=new Customer();
        Logger logger = LoggerFactory.getLogger(Cli.class);
        try {
            Connection con= ConnectionManager.connectionManager.getConnection();
            boolean end=false;
            Scanner s=new Scanner(System.in);
            String a =s.next();
            switch(a) {

                case("customer"):
                    while(!end) {

                        System.out.println("enter phone number:");
                        String phone=s.next();
                        customer.setPhonenumber(phone);
                        logger.info("a customer entred");
                        System.out.println("enter phone the region:");
                        int region = s.nextInt();
                        ResturantManager resturantmanager=new ResturantManager();
                        resturantmanager.getresturantList(con,region);
                        logger.info("getting the resturant list");
                        for(int i = 0; i < resturantmanager.getresturantList(con,region).size(); i++) {
                            System.out.println(resturantmanager.getresturantList(con,region).get(i).toString());
                        }
                        System.out.println("enter"
                                + " the resturant name:");
                        String resturant = s.next();
                        logger.info("choosing the resturant");
                        FoodManager foodmanager=new FoodManager();
                        foodmanager.getresturantFoodList(con,resturant);
                        for(int i = 0; i < foodmanager.getresturantFoodList(con,resturant).size(); i++) {
                            System.out.println(foodmanager.getresturantFoodList(con,resturant).get(i).toString());
                        }
                        String food=null;
                        while(true) {
                            if(food.equals("finish"))
                                break;
                            food=s.next();
                            for(int i = 0; i < foodmanager.getresturantFoodList(con,resturant).size(); i++) {
                                if (foodmanager.getresturantFoodList(con,resturant).get(i).getName().equals(food)) {
                                    System.out.println("enter number of choosen food");
                                    Integer addFood=s.nextInt();
                                    customer.addFood(foodmanager.getresturantFoodList(con,resturant).get(i), addFood);
                                    logger.info("customer has choosen a food");
                                }
                            }
                        }

                        CustomerManager customermanager=new CustomerManager();
                        if(!customermanager.FindCustomer(con, phone)) {
                            System.out.println("you don't have an account"+"/n"+"enter your name");
                            String name=s.next();
                            System.out.println("enter your postalcode");
                            String postcode=s.next();
                            customer= new Customer(phone,name,region,postcode);
                            customermanager.addCustomer(con, phone,name,region,postcode);
                            logger.info("a customer registered");
                        }
                        customer.writefactor();
                        logger.info("the factor has been printed");
                    }
                    break;

            }


            con.close();

        }catch(Exception e) {
            System.out.println(e);
        }

    }
    public static void showcustomerinfo(){

    }
    public static void  showresturantinfo(){}
}
