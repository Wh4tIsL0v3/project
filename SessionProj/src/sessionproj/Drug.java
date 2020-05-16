package sessionproj;

import java.io.Serializable;

public class Drug implements Serializable {
    private Integer id;
    private String name;
    private double price;
    private int count;

    public Drug(Integer id, String name, double price, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public Drug() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString(){
        return id + " " + name + " " + price + " " + count;
    }
}