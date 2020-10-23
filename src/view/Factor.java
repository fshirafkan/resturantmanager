package view;

import java.io.Serializable;

public class Factor implements Serializable {
    private String name;
    private String resturantname;
    private String foodname;
    private int count;

    public Factor() {
    }

    public Factor(String name, String resturantname, String foodname, int count) {
        this.name = name;
        this.resturantname = resturantname;
        this.foodname = foodname;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getResturantname() {
        return resturantname;
    }

    public void setResturantname(String resturantname) {
        this.resturantname = resturantname;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    @Override
    public String toString() {
        return "Factor{" +
                "name='" + name + '\'' +
                ", resturantname='" + resturantname + '\'' +
                ", foodname='" + foodname + '\'' +
                ", count=" + count +
                '}';
    }
}
