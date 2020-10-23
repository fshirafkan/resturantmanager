package view;

import java.io.Serializable;

public class Resturant implements Serializable {
    private String name;
    private int region;
    private double serviceprice;

    public Resturant() {
    }

    public Resturant(String name, int region, double serviceprice) {
        this.name = name;
        this.region = region;
        this.serviceprice = serviceprice;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public double getServiceprice() {
        return serviceprice;
    }

    public void setServiceprice(double serviceprice) {
        this.serviceprice = serviceprice;
    }

    @Override
    public String toString() {
        return "Resturant{" +
                "name='" + name + '\'' +
                ", region=" + region +
                ", serviceprice=" + serviceprice +
                '}';
    }
}
