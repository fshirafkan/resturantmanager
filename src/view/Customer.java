package view;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Customer implements Serializable {
    private String phonenumber;
    private String name;
    private String postalcode;
    private int datemodified;
    Map<String, Integer> food  = new HashMap<String, Integer>();

    public Customer() {
    }

    public Customer(String phonenumber, String name, int postalcode, String datemodified) {
        this.phonenumber = phonenumber;
        this.name = name;
        this.postalcode = postalcode;
        this.datemodified = datemodified;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "phonenumber='" + phonenumber + '\'' +
                ", name='" + name + '\'' +
                ", datemodified=" + datemodified +
                '}';
    }

    public void addFood(Food newfood, Integer numberoffood) {
        food.put(newfood.getName(),numberoffood);
    }

    public  void writefactor() {
        File file = new File(name+".txt");

        BufferedWriter bf = null;;

        try{
            bf = new BufferedWriter( new FileWriter(file) );
            for(Map.Entry<String, Integer> entry : food.entrySet()){
                bf.write( entry.getKey() + ":" + entry.getValue() );
                bf.newLine();
            }
            bf.flush();
        }catch(IOException e){
            e.printStackTrace();
        }finally{

            try{
                bf.close();
            }catch(Exception e){}
        }
    }
}
